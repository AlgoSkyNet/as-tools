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

	private static JAXBContext getContext() throws JAXBException {
		return JAXBContext.newInstance(ObjectFactory.class, Tuple.class,
				Tuples.class);
	}

	private static Marshaller getMarshaller() throws JAXBException {
		Marshaller marshaller = getContext().createMarshaller();
		marshaller.setEventHandler(new JAXBValidator());
		return marshaller;
	}

	private static Unmarshaller getUnmarshaller() throws JAXBException {
		Unmarshaller unmarshaller = getContext().createUnmarshaller();
		unmarshaller.setEventHandler(new JAXBValidator());
		return unmarshaller;
	}

	public static Object unmarshall(File file) throws JAXBException {
		return getUnmarshaller().unmarshal(file);
	}

	public static Object unmarshall(String string) throws JAXBException {
		return getUnmarshaller().unmarshal(new StringReader(string));
	}

	public static Object unmarshall(InputStream in) throws JAXBException {
		return getUnmarshaller().unmarshal(in);
	}

	public static String marshallToString(Object element) throws JAXBException {
		StringWriter writer = new StringWriter();
		getMarshaller().marshal(element, writer);
		return writer.toString();
	}

	public static <T> void marshal(JAXBElement<?> element, File file)
			throws JAXBException {
		getMarshaller().marshal(element, file);
	}

}
