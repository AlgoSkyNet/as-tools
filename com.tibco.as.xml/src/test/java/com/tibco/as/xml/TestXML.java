package com.tibco.as.xml;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.tibco.as.space.DateTime;
import com.tibco.as.space.FieldDef.FieldType;

public class TestXML {

	@Test
	public void testUnmarshallSpace() throws JAXBException {
		@SuppressWarnings("unchecked")
		JAXBElement<Space> element = (JAXBElement<Space>) XMLFactory
				.unmarshall(ClassLoader.getSystemResourceAsStream("space1.xml"));
		Space space1 = element.getValue();
		assertEquals("space1", space1.getName());
		List<Field> fields = space1.getField();
		assertEquals(2, fields.size());
		assertEquals("field1", fields.get(0).getName());
		assertEquals("field2", fields.get(1).getName());
	}

	@Test
	public void testMarshallTuple() throws JAXBException, IOException,
			SAXException, ParseException, ParserConfigurationException {
		Tuple tuple = new Tuple(createTuple());
		Document doc = XMLFactory.marshallToDocument(tuple);
		Element element = doc.getDocumentElement();
		element.normalize();
		Assert.assertEquals("tuple", element.getTagName());
		NodeList children = element.getChildNodes();
		for (int index = 0; index < children.getLength(); index++) {
			Node child = children.item(index);
			String value = child.getFirstChild().getNodeValue();
			if ("field1".equals(child.getNodeName())
					|| "field2".equals(child.getNodeName())) {
				Assert.assertEquals("12345", value);
			} else {
				Assert.assertEquals(createDate(), DatatypeConverter
						.parseDateTime(value).getTime());
			}
		}
	}

	private com.tibco.as.space.Tuple createTuple() throws ParseException {
		com.tibco.as.space.Tuple tuple = com.tibco.as.space.Tuple.create();
		tuple.putLong("field1", 12345);
		tuple.putString("field2", "12345");
		tuple.putDateTime("field3", DateTime.create(createDate().getTime()));
		return tuple;
	}

	private Date createDate() {
		return DatatypeConverter.parseDateTime("2001-07-04T12:08:56.235-07:00")
				.getTime();
	}

	@Test
	public void testUnmarshallTuple() throws JAXBException, IOException,
			SAXException, ParseException {
		String xml = getXML("tuple.xml");
		Tuple tuple = (Tuple) XMLFactory.unmarshall(xml);
		com.tibco.as.space.Tuple controlTuple = createTuple();
		Assert.assertEquals(controlTuple, tuple.getTuple());
	}

	@Test
	public void testMarshallSpace() throws JAXBException, IOException,
			SAXException {
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
	}

	private String getXML(String name) throws IOException {
		return IOUtils.toString(ClassLoader.getSystemResourceAsStream(name));
	}
}
