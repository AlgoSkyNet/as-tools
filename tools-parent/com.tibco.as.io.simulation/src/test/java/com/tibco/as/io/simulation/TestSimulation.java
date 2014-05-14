package com.tibco.as.io.simulation;

import java.util.Calendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Assert;
import org.junit.Test;

import com.tibco.as.space.DateTime;
import com.tibco.as.space.FieldDef;
import com.tibco.as.space.MemberDef;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.SpaceDef;
import com.tibco.as.space.Tuple;
import com.tibco.as.space.browser.Browser;

public class TestSimulation {

	@Test
	public void testSpaceDef() throws Exception {
		Simulation simulation = getSimulation("simulation.xml");
		MemberDef memberDef = MemberDef.create(null, "tcp", null);
		memberDef.setConnectTimeout(10000);
		Metaspace metaspace = Metaspace.connect(null, memberDef);
		SimulationImporter importer = new SimulationImporter(metaspace,
				simulation);
		SpaceDef spaceDef = importer.getSpaceDef("position");
		FieldDef[] fieldDefs = spaceDef.getFieldDefs().toArray(new FieldDef[0]);
		Assert.assertEquals(7, fieldDefs.length);
		Assert.assertEquals("portfolioId", fieldDefs[0].getName());
		importer.execute();
		Browser browser = metaspace.browse("quote",
				com.tibco.as.space.browser.BrowserDef.BrowserType.GET);
		Tuple tuple;
		while ((tuple = browser.next()) != null) {
			DateTime dateTime = tuple.getDateTime("tradeTime");
			Calendar calendar = dateTime.getTime();
			Assert.assertEquals(2013, calendar.get(Calendar.YEAR));
			Assert.assertEquals(9, calendar.get(Calendar.MONTH));
			Assert.assertEquals(15, calendar.get(Calendar.DATE));
		}
		com.tibco.as.space.Space positionSpace = metaspace.getSpace("position");
		Assert.assertEquals(100000, positionSpace.size());
	}

	private Simulation getSimulation(String resourceName) throws JAXBException {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		JAXBContext jc = JAXBContext.newInstance(Simulation.class.getPackage()
				.getName(), classLoader);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		@SuppressWarnings("unchecked")
		JAXBElement<Simulation> element = (JAXBElement<Simulation>) unmarshaller
				.unmarshal(classLoader.getResourceAsStream("simulation.xml"));
		return element.getValue();
	}

}
