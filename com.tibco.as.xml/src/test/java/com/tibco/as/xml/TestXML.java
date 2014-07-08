package com.tibco.as.xml;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.commons.io.IOUtils;
import org.custommonkey.xmlunit.XMLAssert;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.tibco.as.space.FieldDef.FieldType;

public class TestXML {

	@Test
	public void testUnmarshall() throws JAXBException {
		Space space1 = XMLFactory.unmarshall(
				ClassLoader.getSystemResourceAsStream("space1.xml"),
				Space.class);
		assertEquals("space1", space1.getName());
		List<Field> fields = space1.getField();
		assertEquals(2, fields.size());
		assertEquals("field1", fields.get(0).getName());
		assertEquals("field2", fields.get(1).getName());
	}

	@Test
	public void testMarshall() throws JAXBException, IOException, SAXException {
		Space space1 = new Space();
		space1.setName("space1");
		Field field1 = new Field();
		field1.setName("field1");
		field1.setKey(true);
		field1.setType(FieldType.LONG);
		field1.setDistribution(true);
		Field field2 = new Field();
		field2.setName("field2");
		field2.setType(FieldType.STRING);
		space1.getField().add(field1);
		space1.getField().add(field2);
		Index index1 = new Index();
		index1.setName("index1");
		index1.getField().add("field1");
		Index index2 = new Index();
		index2.setName("index2");
		index2.getField().add("field2");
		space1.getIndex().add(index1);
		space1.getIndex().add(index2);
		String testXML = XMLFactory.marshallToString(new ObjectFactory()
				.createSpace(space1));
		String controlXML = IOUtils.toString(ClassLoader
				.getSystemResourceAsStream("space1.xml"));
		XMLUnit.setIgnoreAttributeOrder(true);
		XMLUnit.setIgnoreComments(true);
		XMLUnit.setIgnoreWhitespace(true);
		XMLUnit.setIgnoreDiffBetweenTextAndCDATA(true);
		XMLAssert.assertXMLEqual("Comparing test xml to control xml",
				controlXML, testXML);
	}

}
