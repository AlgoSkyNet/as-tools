package com.tibco.as.xml;

import java.io.File;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLFactory {

	private static JAXBContext getContext(Class<?> clazz) throws JAXBException {
		return JAXBContext.newInstance(clazz.getPackage().getName(),
				ClassLoader.getSystemClassLoader());
	}

	private static Marshaller getMarshaller(Class<?> clazz)
			throws JAXBException {
		Marshaller marshaller = getContext(clazz).createMarshaller();
		marshaller.setEventHandler(new JAXBValidator());
		return marshaller;
	}

	private static Unmarshaller getUnmarshaller(Class<?> clazz)
			throws JAXBException {
		Unmarshaller unmarshaller = getContext(clazz).createUnmarshaller();
		unmarshaller.setEventHandler(new JAXBValidator());
		return unmarshaller;
	}

	@SuppressWarnings("unchecked")
	public static <T> T unmarshall(File file, Class<T> clazz)
			throws JAXBException {
		JAXBElement<T> element = (JAXBElement<T>) getUnmarshaller(clazz)
				.unmarshal(file);
		return element.getValue();
	}

	@SuppressWarnings("unchecked")
	public static <T> T unmarshall(String string, Class<T> clazz)
			throws JAXBException {
		JAXBElement<T> element = (JAXBElement<T>) getUnmarshaller(clazz)
				.unmarshal(new StringReader(string));
		return element.getValue();
	}

	@SuppressWarnings("unchecked")
	public static <T> T unmarshall(InputStream in, Class<T> clazz)
			throws JAXBException {
		JAXBElement<T> element = (JAXBElement<T>) getUnmarshaller(clazz)
				.unmarshal(in);
		return element.getValue();
	}

	public static <T> String marshallToString(JAXBElement<T> element)
			throws JAXBException {
		StringWriter writer = new StringWriter();
		getMarshaller(element.getDeclaredType()).marshal(element, writer);
		return writer.toString();
	}

	public static <T> void marshal(JAXBElement<T> element, File file)
			throws JAXBException {
		getMarshaller(element.getDeclaredType()).marshal(element, file);
	}

}
