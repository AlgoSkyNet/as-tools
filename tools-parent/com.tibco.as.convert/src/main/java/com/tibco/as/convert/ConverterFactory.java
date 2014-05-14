package com.tibco.as.convert;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import com.tibco.as.convert.converters.Idem;
import com.tibco.as.convert.format.Base64Format;
import com.tibco.as.convert.format.BlobFormat;
import com.tibco.as.convert.format.BooleanFormat;
import com.tibco.as.convert.format.HexFormat;
import com.tibco.as.space.FieldDef;
import com.tibco.as.space.FieldDef.FieldType;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ConverterFactory {

	public enum Blob {
		BASE64, HEX
	}

	public static final String DEFAULT_PATTERN_DATE = "yyyy-MM-dd'T'HH:mm:ss.SSS";

	public final static String DEFAULT_PATTERN_BOOLEAN = "true|false";

	public static BlobFormat getBlobFormat(Attributes attributes) {
		Blob attribute = attributes.get(Attribute.FORMAT_BLOB);
		if (attribute == Blob.BASE64) {
			return new Base64Format();
		}
		return new HexFormat();
	}

	public static BooleanFormat getBooleanFormat(Attributes attributes) {
		return new BooleanFormat(getBooleanPattern(attributes));
	}

	public static String getBooleanPattern(Attributes attributes) {
		String pattern = attributes.get(Attribute.FORMAT_BOOLEAN);
		if (pattern == null) {
			return DEFAULT_PATTERN_BOOLEAN;
		}
		return pattern;
	}

	public static DateFormat getDateFormat(Attributes attributes) {
		DateFormat format = new SimpleDateFormat(getDatePattern(attributes));
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		return format;
	}

	public static String getDatePattern(Attributes attributes) {
		String pattern = attributes.get(Attribute.FORMAT_DATE);
		if (pattern == null) {
			return DEFAULT_PATTERN_DATE;
		}
		return pattern;
	}

	private Collection<Conversion> conversions = new ArrayList<Conversion>();

	private Collection<ChainedConversion> chainedConversions = new ArrayList<ChainedConversion>();

	private Map<FieldType, Class> classes = new HashMap<FieldType, Class>();

	private Map<Class, FieldType> types = new HashMap<Class, FieldType>();

	public ConverterFactory(Config... configs) {
		Config config = getConfig("config.xml");
		for (Config extra : configs) {
			if (extra.getTypes() != null) {
				config.getTypes().getType().addAll(extra.getTypes().getType());
			}
			if (extra.getConverters() != null) {
				config.getConverters().getConverter()
						.addAll(extra.getConverters().getConverter());
			}
			if (extra.getPivots() != null) {
				config.getPivots().getPivot()
						.addAll(extra.getPivots().getPivot());
			}
		}
		for (Type type : config.getTypes().getType()) {
			addType(type.getField(), type.getJava(), type.isDefault());
		}
		for (Converter converter : config.getConverters().getConverter()) {
			Class from = converter.getFrom();
			Class to = converter.getTo();
			Class clazz = converter.getType();
			Conversion conversion = new Conversion(from, to, clazz);
			for (Class pivot : config.getPivots().getPivot()) {
				if (pivot.isAssignableFrom(to)) {
					for (Conversion conversion2 : conversions) {
						if (conversion2.getFrom().isAssignableFrom(to)) {
							chainedConversions.add(new ChainedConversion(
									conversion, conversion2));
						}
					}
				}
				if (from.isAssignableFrom(pivot)) {
					for (Conversion conversion2 : conversions) {
						if (from.isAssignableFrom(conversion2.getTo())) {
							chainedConversions.add(new ChainedConversion(
									conversion2, conversion));
						}
					}
				}
			}
			conversions.add(conversion);
		}
	}

	private void addType(FieldType fieldType, Class clazz, Boolean isDefault) {
		if (Boolean.TRUE.equals(isDefault)) {
			classes.put(fieldType, clazz);
		}
		types.put(clazz, fieldType);
	}

	public static Config getConfig(String resourceName) {
		try {
			ClassLoader cl = com.tibco.as.convert.ObjectFactory.class
					.getClassLoader();
			JAXBContext jc = JAXBContext.newInstance(
					com.tibco.as.convert.ObjectFactory.class.getPackage()
							.getName(), cl);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			InputStream in = cl.getResourceAsStream(resourceName);
			JAXBElement<Config> element = (JAXBElement<Config>) unmarshaller
					.unmarshal(in);
			return element.getValue();
		} catch (Exception e) {
			return new Config();
		}
	}

	private IConverter newConverterInstance(Class clazz, Attributes attributes)
			throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Constructor[] constructors = clazz.getConstructors();
		for (Constructor constructor : constructors) {
			Class[] parameterTypes = constructor.getParameterTypes();
			if (parameterTypes.length == 0) {
				return (IConverter) constructor.newInstance();
			}
			return (IConverter) constructor.newInstance(attributes);
		}
		throw new InstantiationException("Could not instanciate type "
				+ clazz.getName());
	}

	public IConverter getConverter(Attributes attributes, Class from,
			FieldDef to) throws UnsupportedConversionException {
		if (to == null) {
			return null;
		}
		Attributes nameAttributes = attributes.getAttributes(to.getName());
		return getConverter(nameAttributes, from, getType(to.getType()));
	}

	public IConverter getConverter(Attributes attributes, FieldDef from,
			Class to) throws UnsupportedConversionException {
		Attributes nameAttributes = attributes.getAttributes(from.getName());
		return getConverter(nameAttributes, getType(from.getType()), to);
	}

	public Class getType(FieldType type) {
		return classes.get(type);
	}

	public IConverter getConverter(Attributes attributes, Class from, Class to)
			throws UnsupportedConversionException {
		if (from.isAssignableFrom(to)) {
			return new Idem();
		}
		for (Conversion candidate : conversions) {
			if (matches(from, to, candidate.getFrom(), candidate.getTo())) {
				try {
					return newConverterInstance(candidate.getConverter(),
							attributes);
				} catch (Exception e) {
					throw new UnsupportedConversionException(from, to, e);
				}
			}
		}
		for (ChainedConversion chained : chainedConversions) {
			if (matches(from, to, chained.getConversion1().getFrom(), chained
					.getConversion2().getTo())) {
				try {
					IConverter converter1 = newConverterInstance(chained
							.getConversion1().getConverter(), attributes);
					IConverter converter2 = newConverterInstance(chained
							.getConversion2().getConverter(), attributes);
					return new ChainedConverter(converter1, converter2);
				} catch (Exception e) {
					throw new UnsupportedConversionException(from, to, e);
				}
			}
		}
		throw new UnsupportedConversionException(from, to);
	}

	private boolean matches(Class from, Class to, Class candidateFrom,
			Class candidateTo) {
		return candidateFrom.isAssignableFrom(from)
				&& to.isAssignableFrom(candidateTo);
	}

	public static Format getNumberFormat(Attributes attributes,
			Format defaultFormat) {
		String pattern = attributes.get(Attribute.FORMAT_NUMBER);
		if (pattern == null) {
			return defaultFormat;
		}
		return new DecimalFormat(pattern);
	}

	public Collection<IConverter> getTypeConverters(Attributes attributes,
			Collection<Class> types, Collection<FieldDef> fieldDefs)
			throws UnsupportedConversionException {
		Collection<IConverter> converters = new ArrayList<IConverter>();
		Iterator<Class> typeIterator = types.iterator();
		Iterator<FieldDef> fieldDefIterator = fieldDefs.iterator();
		while (fieldDefIterator.hasNext()) {
			FieldDef fieldDef = fieldDefIterator.next();
			Class type = typeIterator.next();
			converters.add(getConverter(attributes, type, fieldDef));
		}
		return converters;
	}

	public Collection<IConverter> getTypeConverters(Attributes attributes,
			Class type, Collection<FieldDef> fieldDefs)
			throws UnsupportedConversionException {
		Collection<Class> types = Collections.nCopies(fieldDefs.size(), type);
		return getTypeConverters(attributes, types, fieldDefs);
	}

	public Collection<IConverter> getFieldConverters(Attributes attributes,
			Collection<FieldDef> fieldDefs, Class... types)
			throws UnsupportedConversionException {
		Collection<IConverter> converters = new ArrayList<IConverter>();
		Iterator<FieldDef> fieldDefIterator = fieldDefs.iterator();
		Iterator<Class> typeIterator = Arrays.asList(types).iterator();
		Class type = null;
		while (fieldDefIterator.hasNext()) {
			if (typeIterator.hasNext()) {
				type = typeIterator.next();
			}
			FieldDef fieldDef = fieldDefIterator.next();
			converters.add(getConverter(attributes, fieldDef, type));
		}
		return converters;
	}

	public FieldType getFieldType(Class clazz) {
		return types.get(clazz);
	}

}