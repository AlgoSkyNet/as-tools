package com.tibco.as.convert.format;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.xml.bind.DatatypeConverter;

public class ISO8601Format extends Format {

	private static final long serialVersionUID = 6066579310108163156L;

	private TimeZone timeZone;

	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}

	@Override
	public StringBuffer format(Object obj, StringBuffer buffer,
			FieldPosition pos) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime((Date) obj);
		return buffer.append(DatatypeConverter.printDateTime(calendar));
	}

	@Override
	public Object parseObject(String source, ParsePosition position) {
		if (source == null) {
			return null;
		}
		Calendar calendar = DatatypeConverter.parseDateTime(source);
		if (calendar.getTimeZone() == null && timeZone != null) {
			calendar.setTimeZone(timeZone);
		}
		position.setIndex(source.length());
		return calendar.getTime();
	}

}
