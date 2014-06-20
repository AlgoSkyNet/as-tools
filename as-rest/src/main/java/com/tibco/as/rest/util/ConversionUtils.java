package com.tibco.as.rest.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.tibco.as.rest.exception.ConversionException;
import com.tibco.as.space.DateTime;
import com.tibco.as.space.FieldDef;

public class ConversionUtils {

	public static Object decode(Object val, String type)
			throws ConversionException {
		try {
			if ("blob".equals(type)) {
				return decodeBlob(val);
			}
			if ("boolean".equals(type)) {
				return decodeBoolean(val);
			}
			if ("char".equals(type)) {
				return decodeChar(val);
			}
			if ("datetime".equals(type)) {
				return decodeDateTime(val);
			}
			if ("double".equals(type)) {
				return decodeDouble(val);
			}
			if ("float".equals(type)) {
				return decodeFloat(val);
			}
			if ("integer".equals(type)) {
				return decodeInteger(val);
			}
			if ("long".equals(type)) {
				return decodeLong(val);
			}
			if ("short".equals(type)) {
				return decodeShort(val);
			}
			if ("string".equals(type)) {
				return decodeString(val);
			}
		} catch (ConversionException e) {
			throw e;
		} catch (Exception e) {
			throw new ConversionException(e);
		}
		throw new ConversionException("Unknown type: " + type);
	}

	public static Object decode(Object val, FieldDef.FieldType type)
			throws ConversionException {
		try {
			switch (type) {
			case BLOB:
				return decodeBlob(val);
			case BOOLEAN:
				return decodeBoolean(val);
			case CHAR:
				return decodeChar(val);
			case DATETIME:
				return decodeDateTime(val);
			case DOUBLE:
				return decodeDouble(val);
			case FLOAT:
				return decodeFloat(val);
			case INTEGER:
				return decodeInteger(val);
			case LONG:
				return decodeLong(val);
			case SHORT:
				return decodeShort(val);
			case STRING:
				return decodeString(val);
			}
		} catch (ConversionException e) {
			throw e;
		} catch (Exception e) {
			throw new ConversionException(e);
		}
		throw new ConversionException("Unknown type: " + type);
	}

	public static Object encode(Object val, FieldDef.FieldType type) {
		if (val == null) {
			return null;
		}
		switch (type) {
		case DATETIME:
			return ((DateTime) val).getTime().getTime();
		default:
			return val;
		}
	}

	public static byte[] decodeBlob(Object val) throws Exception {
		if (val == null)
			return null;
		if (!(val instanceof String))
			throw new ConversionException("Unsupported blob: "
					+ String.valueOf(val));
		for (char c : ((String) val).toCharArray()) {
			if ((((int) c) & 0xffffff00) != 0)
				throw new ConversionException("Unsupported blob: "
						+ String.valueOf(val));
		}
		return ((String) val).getBytes("ISO-8859-1");
	}

	public static Boolean decodeBoolean(Object val) throws Exception {
		if (val == null)
			return null;
		if (val instanceof Boolean)
			return (Boolean) val;
		if (val instanceof String)
			return Boolean.valueOf((String) val);
		if (val instanceof Number)
			return ((Number) val).intValue() != 0;
		throw new ConversionException("Unsupported boolean: "
				+ String.valueOf(val));
	}

	public static Float decodeFloat(Object val) throws Exception {
		if (val == null)
			return null;
		if (val instanceof Float)
			return (Float) val;
		if (val instanceof String)
			return Float.valueOf((String) val);
		if (val instanceof Number)
			return ((Number) val).floatValue();
		throw new ConversionException("Unsupported float: "
				+ String.valueOf(val));
	}

	public static Double decodeDouble(Object val) throws Exception {
		if (val == null)
			return null;
		if (val instanceof Double)
			return (Double) val;
		if (val instanceof String)
			return Double.valueOf((String) val);
		if (val instanceof Number)
			return ((Number) val).doubleValue();
		throw new ConversionException("Unsupported double: "
				+ String.valueOf(val));
	}

	public static Character decodeChar(Object val) throws Exception {
		if (val == null)
			return null;
		if (val instanceof Character)
			return (Character) val;
		if (val instanceof String && ((String) val).length() == 1)
			return ((String) val).charAt(0);
		if (val instanceof Number)
			return (char) (((Number) val).intValue());
		throw new ConversionException("Unsupported character: "
				+ String.valueOf(val));
	}

	public static DateTime decodeDateTime(Object val) throws Exception {
		if (val == null)
			return null;
		if (val instanceof Date)
			return DateTime.create(((Date) val).getTime());
		if (val instanceof String)
			return DateTime.create(new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss.SSS").parse((String) val).getTime());
		if (val instanceof Number)
			return DateTime.create(((Number) val).longValue());
		throw new ConversionException("Unsupported date-time: "
				+ String.valueOf(val));
	}

	public static Integer decodeInteger(Object val) throws Exception {
		if (val == null)
			return null;
		if (val instanceof Integer)
			return (Integer) val;
		if (val instanceof String)
			return Integer.parseInt((String) val);
		if (val instanceof Number)
			return ((Number) val).intValue();
		throw new ConversionException("Unsupported integer: "
				+ String.valueOf(val));
	}

	public static Long decodeLong(Object val) throws Exception {
		if (val == null)
			return null;
		if (val instanceof Long)
			return (Long) val;
		if (val instanceof String)
			return Long.parseLong((String) val);
		if (val instanceof Number)
			return ((Number) val).longValue();
		throw new ConversionException("Unsupported long: "
				+ String.valueOf(val));
	}

	public static Short decodeShort(Object val) throws Exception {
		if (val == null)
			return null;
		if (val instanceof Short)
			return (Short) val;
		if (val instanceof String)
			return Short.parseShort((String) val);
		if (val instanceof Number)
			return ((Number) val).shortValue();
		throw new ConversionException("Unsupported short: "
				+ String.valueOf(val));
	}

	public static String decodeString(Object val) throws Exception {
		if (val == null)
			return null;
		if (val instanceof String)
			return (String) val;
		return String.valueOf(val);
	}

}
