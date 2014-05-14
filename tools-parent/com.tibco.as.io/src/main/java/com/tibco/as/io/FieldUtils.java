package com.tibco.as.io;

import java.text.MessageFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.tibco.as.accessors.AccessorFactory;
import com.tibco.as.accessors.ITupleAccessor;
import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ConverterFactory;
import com.tibco.as.convert.IConverter;
import com.tibco.as.convert.UnsupportedConversionException;
import com.tibco.as.convert.array.ArrayToTupleConverter;
import com.tibco.as.convert.array.TupleToArrayConverter;
import com.tibco.as.space.FieldDef;
import com.tibco.as.space.FieldDef.FieldType;
import com.tibco.as.space.SpaceDef;

public class FieldUtils {

	private static Logger logger = Logger.getLogger(FieldUtils.class.getName());

	public static FieldDef getFieldDef(Field field) {
		if (field.getName() == null) {
			return null;
		}
		FieldType type = field.getType();
		if (type == null) {
			type = FieldType.STRING;
		}
		FieldDef fieldDef = FieldDef.create(field.getName(), type);
		fieldDef.setNullable(field.isNullable());
		fieldDef.setEncrypted(field.isEncrypted());
		return fieldDef;

	}

	public static Collection<FieldDef> getFieldDefs(Collection<Field> fields) {
		Collection<FieldDef> fieldDefs = new ArrayList<FieldDef>();
		for (Field field : fields) {
			fieldDefs.add(getFieldDef(field));
		}
		return fieldDefs;
	}

	public static List<FieldDef> getFieldDefs(SpaceDef spaceDef,
			Collection<Field> fields) {
		setFields(fields, spaceDef);
		List<FieldDef> fieldDefs = new ArrayList<FieldDef>();
		for (Field field : fields) {
			fieldDefs.add(getFieldDef(field));
		}
		return fieldDefs;
	}

	public static void setFields(Collection<Field> fields, SpaceDef spaceDef) {
		if (fields.isEmpty()) {
			for (FieldDef fieldDef : spaceDef.getFieldDefs()) {
				Field field = new Field();
				field.setName(fieldDef.getName());
				fields.add(field);
			}
		}
		for (Field field : fields) {
			if (field.getName() == null) {
				continue;
			}
			getField(spaceDef, field.getName()).copyTo(field);
		}
	}

	public static Field getField(SpaceDef spaceDef, String fieldName) {
		Field field = new Field();
		FieldDef fieldDef = spaceDef.getFieldDef(fieldName);
		field.setName(fieldDef.getName());
		field.setEncrypted(fieldDef.isEncrypted());
		field.setKey(spaceDef.getKeyDef().getFieldNames()
				.contains(fieldDef.getName()));
		field.setNullable(fieldDef.isNullable());
		field.setType(fieldDef.getType());
		return field;
	}

	public static SpaceDef createSpaceDef(String spaceName,
			Collection<Field> fields) {
		SpaceDef spaceDef = SpaceDef.create(spaceName);
		for (FieldDef fieldDef : getFieldDefs(fields)) {
			if (fieldDef != null) {
				spaceDef.getFieldDefs().add(fieldDef);
			}
		}
		for (Field field : fields) {
			if (field.isKey()) {
				spaceDef.getKeyDef().getFieldNames().add(field.getName());
			}
		}
		return spaceDef;
	}

	public static List<Field> getFields(Collection<String> fieldDefs) {
		FieldFormat format = new FieldFormat();
		List<Field> fields = new ArrayList<Field>();
		if (fieldDefs != null) {
			for (String fieldDef : fieldDefs) {
				Field field = new Field();
				if (fieldDef != null && !fieldDef.isEmpty()) {
					try {
						field = format.parseObject(fieldDef);
					} catch (ParseException e) {
						logger.log(Level.SEVERE, MessageFormat.format(
								"Could not parse field def {0}", fieldDef), e);
					}
				}
				fields.add(field);
			}
		}
		return fields;
	}

	@SuppressWarnings("rawtypes")
	public static <T> TupleToArrayConverter<T> getTupleToArrayConverter(
			ConverterFactory converterFactory, SpaceDef spaceDef,
			Collection<Field> fields, Class<T> componentType,
			Attributes attributes, Class... types)
			throws UnsupportedConversionException {
		Collection<ITupleAccessor> accessors = AccessorFactory
				.create(getFieldDefs(spaceDef, fields));
		Collection<IConverter> converters = converterFactory
				.getFieldConverters(attributes, getFieldDefs(spaceDef, fields),
						types);
		return new TupleToArrayConverter<T>(accessors, converters,
				componentType);
	}

	@SuppressWarnings("rawtypes")
	public static <T> ArrayToTupleConverter<T> getArrayToTupleConverter(
			ConverterFactory converterFactory, SpaceDef spaceDef,
			Collection<Field> fields, Class<T> componentType,
			Attributes attributes) throws UnsupportedConversionException {
		Collection<FieldDef> fieldDefs = getFieldDefs(spaceDef, fields);
		Collection<ITupleAccessor> accessors = AccessorFactory
				.create(fieldDefs);
		Collection<IConverter> converters = converterFactory.getTypeConverters(
				attributes, componentType, fieldDefs);
		return new ArrayToTupleConverter<T>(accessors, converters);
	}

	public static Collection<String> format(Collection<Field> fields) {
		FieldFormat format = new FieldFormat();
		Collection<String> fieldDefs = new ArrayList<String>();
		for (Field field : fields) {
			fieldDefs.add(format.format(field));
		}
		return fieldDefs;
	}
}
