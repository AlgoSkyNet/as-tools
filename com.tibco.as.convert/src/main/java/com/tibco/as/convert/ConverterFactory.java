package com.tibco.as.convert;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
import com.tibco.as.convert.format.ISO8601Format;
import com.tibco.as.space.FieldDef;
import com.tibco.as.space.FieldDef.FieldType;
import com.tibco.as.space.SpaceDef;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ConverterFactory {

	public enum Blob {
		BASE64, HEX
	}

	public final static String DEFAULT_PATTERN_BOOLEAN = "true|false";

	private Attributes defaultAttributes = new Attributes();

	public void setBlobFormat(Blob blobFormat) {
		defaultAttributes.put(Attribute.FORMAT_BLOB, blobFormat);
	}

	public void setDateFormat(String dateFormat) {
		defaultAttributes.put(Attribute.FORMAT_DATE, dateFormat);
	}

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

	public static Format getDateFormat(Attributes attributes) {
		return getDateFormat(attributes.get(Attribute.FORMAT_DATE));
	}

	public static Format getDateFormat(String pattern) {
		return getDateFormat(pattern, TimeZone.getTimeZone("GMT"));
	}

	public static Format getDateFormat(String pattern, TimeZone timeZone) {
		if (pattern == null) {
			ISO8601Format format = new ISO8601Format();
			format.setTimeZone(timeZone);
			return format;
		} else {
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			format.setTimeZone(timeZone);
			return format;
		}

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
			JAXBContext jc = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			InputStream in = ObjectFactory.class.getClassLoader()
					.getResourceAsStream(resourceName);
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
		return getConverter(nameAttributes, from, getType(to));
	}

	public IConverter getConverter(Attributes attributes, FieldDef from,
			Class to) throws UnsupportedConversionException {
		Attributes nameAttributes = attributes.getAttributes(from.getName());
		return getConverter(nameAttributes, getType(from), to);
	}

	public Class getType(FieldDef fieldDef) {
		return classes.get(fieldDef.getType());
	}

	public IConverter getConverter(Class from, FieldDef to)
			throws UnsupportedConversionException {
		return getConverter(defaultAttributes, from, to);
	}

	public IConverter getConverter(FieldDef from, Class to)
			throws UnsupportedConversionException {
		return getConverter(defaultAttributes, from, to);
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

	public IConverter[] getConverters(Class[] types, FieldDef[] fieldDefs)
			throws UnsupportedConversionException {
		return getConverters(defaultAttributes, types, fieldDefs);
	}

	public IConverter[] getConverters(Attributes attributes, Class[] types,
			FieldDef[] fieldDefs) throws UnsupportedConversionException {
		IConverter[] converters = new IConverter[fieldDefs.length];
		for (int index = 0; index < fieldDefs.length; index++) {
			FieldDef fieldDef = fieldDefs[index];
			Class type = index < types.length ? types[index] : types[0];
			converters[index] = getConverter(attributes, type, fieldDef);
		}
		return converters;
	}

	public IConverter[] getConverters(Attributes attributes,
			FieldDef[] fieldDefs, Class type)
			throws UnsupportedConversionException {
		return getConverters(attributes, fieldDefs, new Class[] { type });
	}

	public IConverter[] getConverters(Attributes attributes,
			FieldDef[] fieldDefs, Class[] types)
			throws UnsupportedConversionException {
		IConverter[] converters = new IConverter[fieldDefs.length];
		for (int index = 0; index < fieldDefs.length; index++) {
			FieldDef fieldDef = fieldDefs[index];
			Class type = index < types.length ? types[index] : types[0];
			converters[index] = getConverter(attributes, fieldDef, type);
		}
		return converters;
	}

	public IConverter[] getConverters(Class type, FieldDef[] fieldDefs)
			throws UnsupportedConversionException {
		return getConverters(defaultAttributes, type, fieldDefs);
	}

	public IConverter[] getConverters(Attributes attributes, Class type,
			FieldDef[] fieldDefs) throws UnsupportedConversionException {
		return getConverters(attributes, new Class[] { type }, fieldDefs);
	}

	public FieldType getFieldType(Class clazz) {
		return types.get(clazz);
	}

	public IConverter[] getConverters(Attributes attributes, Class type,
			SpaceDef spaceDef) throws UnsupportedConversionException {
		return getConverters(attributes, type, getFieldDefs(spaceDef));
	}

	private FieldDef[] getFieldDefs(SpaceDef spaceDef) {
		return spaceDef.getFieldDefs().toArray(
				new FieldDef[spaceDef.getFieldDefs().size()]);
	}

	public IConverter[] getConverters(Attributes attributes, SpaceDef spaceDef,
			Class type) throws UnsupportedConversionException {
		return getConverters(attributes, getFieldDefs(spaceDef), type);
	}

	public IConverter getConverter(FieldDef fieldDef)
			throws UnsupportedConversionException {
		return getConverter(fieldDef, getType(fieldDef));
	}

}