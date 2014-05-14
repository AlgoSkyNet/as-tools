package com.tibco.as.io.excel2as;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import com.tibco.as.io.Field;
import com.tibco.as.io.FieldFormat;
import com.tibco.as.space.ASException;
import com.tibco.as.space.FieldDef;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.Space;
import com.tibco.as.space.SpaceDef;

public class TestCommandImportExcel extends TestBase {

	@Test
	public void testImportXLSX() throws ASException, IOException,
			ParseException {
		File file = new File(getDir(), "jazzfunk.xlsx");
		TestUtils.copy("jazzfunk.xlsx", file);
		String[] args = { "-discovery", "tcp", "import", file.getPath(),
				"-header", "-distribution_role", "seeder" };
		new Excel2AS().execute(args);
		Metaspace metaspace = getMetaspace();
		Space artist = metaspace.getSpace("artist");
		assertEquals(new String[] { "id[LONG key]", "name[STRING]",
				"birthdate[DATETIME]" }, artist.getSpaceDef());
		Assert.assertEquals(1, artist.getSpaceDef().getKeyDef().getFieldNames()
				.size());
		Assert.assertEquals("id", artist.getSpaceDef().getKeyDef()
				.getFieldNames().iterator().next());
		Assert.assertEquals(5, artist.size());
		Space album = metaspace.getSpace("album");
		String[] header = { "artist[LONG key]", "name[STRING key]",
				"year[INTEGER]" };
		assertEquals(header, album.getSpaceDef());
		Collection<String> keys = album.getSpaceDef().getKeyDef()
				.getFieldNames();
		Assert.assertEquals(2, keys.size());
		Iterator<String> iterator = keys.iterator();
		Assert.assertEquals("artist", iterator.next());
		Assert.assertEquals("name", iterator.next());
		Assert.assertEquals(10, album.size());
	}

	@Test
	public void testImportXLS() throws IOException, ASException,
			ParseException {
		File file = new File(getDir(), "jazzfunk-noheader.xls");
		TestUtils.copy("jazzfunk-noheader.xls", file);
		String[] args = { "-discovery", "tcp", "import", file.getPath(),
				"-fields", "id[LONG key]", "name[STRING]",
				"birthDate[DATETIME nullable]", "-distribution_role", "seeder", "-sheet", "artist" };
		new Excel2AS().execute(args);
		Space artist = getMetaspace().getSpace("artist");
		assertEquals(new String[] { "id[LONG key]", "name[STRING]",
				"birthDate[DATETIME nullable]" }, artist.getSpaceDef());
		Assert.assertEquals(1, artist.getSpaceDef().getKeyDef().getFieldNames()
				.size());
		Assert.assertEquals("id", artist.getSpaceDef().getKeyDef()
				.getFieldNames().iterator().next());
		Assert.assertEquals(5, artist.size());
	}

	private void assertEquals(String[] header, SpaceDef spaceDef)
			throws ParseException {
		FieldFormat format = new FieldFormat();
		Collection<FieldDef> fieldDefs = spaceDef.getFieldDefs();
		int index = 0;
		for (FieldDef fieldDef : fieldDefs) {
			Field field = format.parseObject(header[index]);
			Assert.assertEquals(field.getName(), fieldDef.getName());
			Assert.assertEquals(field.getType(), fieldDef.getType());
			Assert.assertEquals(field.isNullable(), fieldDef.isNullable());
			Assert.assertEquals(field.isEncrypted(), fieldDef.isEncrypted());
			index++;
		}
	}

}
