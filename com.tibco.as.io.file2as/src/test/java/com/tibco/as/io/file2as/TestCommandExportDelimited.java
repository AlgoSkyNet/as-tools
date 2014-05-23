package com.tibco.as.io.file2as;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import au.com.bytecode.opencsv.CSVReader;

import com.tibco.as.io.TransferException;
import com.tibco.as.io.file.text.delimited.DelimitedImport;
import com.tibco.as.io.file.text.delimited.DelimitedImporter;
import com.tibco.as.io.file2as.File2AS;
import com.tibco.as.space.ASException;
import com.tibco.as.space.Member.DistributionRole;
import com.tibco.as.space.Metaspace;

public class TestCommandExportDelimited extends TestBase {

	@Test
	public void testExport() throws ASException, IOException, ParseException,
			TransferException {
		File dir = new File(getDir(), "jazzfunk");
		dir.mkdir();
		TestUtils.copy("jazzfunk/album.csv", new File(dir, "album.csv"));
		TestUtils.copy("jazzfunk/artist.csv", new File(dir, "artist.csv"));
		Metaspace metaspace = getMetaspace();
		DelimitedImporter importer = new DelimitedImporter(metaspace, dir);
		DelimitedImport config = new DelimitedImport();
		config.setHeader(true);
		config.setDistributionRole(DistributionRole.SEEDER);
		config.setKeepSpaceOpen(true);
		importer.setDefaultTransfer(config);
		importer.execute();
		File exportDir1 = new File(dir, "export1");
		exportDir1.mkdir();
		String[] args = { "-discovery", "tcp", "export", "-directory",
				exportDir1.getPath() };
		new File2AS().execute(args);
		File[] files = exportDir1.listFiles();
		Assert.assertEquals(2, files.length);
		File albumFile;
		File artistFile;
		if (files[0].getName().startsWith("album")) {
			albumFile = files[0];
			artistFile = files[1];
		} else {
			albumFile = files[1];
			artistFile = files[0];
		}
		CSVReader albumReader = new CSVReader(new FileReader(albumFile));
		try {
			List<String[]> albums = albumReader.readAll();
			Assert.assertEquals(11, albums.size());
			String[] header = albums.get(0);
			Assert.assertArrayEquals(new String[] { "artist[LONG key]",
					"name[STRING key]", "year[INTEGER]" }, header);
		} finally {
			albumReader.close();
		}
		CSVReader artistReader = new CSVReader(new FileReader(artistFile));
		try {
			List<String[]> artists = artistReader.readAll();
			Assert.assertEquals(6, artists.size());
			String[] header = artists.get(0);
			Assert.assertArrayEquals(new String[] { "id[LONG key]",
					"name[STRING]", "birthDate[DATETIME nullable]" }, header);
		} finally {
			artistReader.close();
		}
		File exportDir2 = new File(dir, "export2");
		exportDir2.mkdir();
		String[] args2 = { "-discovery", "tcp", "export", "artist", "album",
				"-directory", exportDir2.getPath() };
		new File2AS().execute(args2);
		File[] files2 = exportDir2.listFiles();
		Assert.assertEquals(2, files2.length);
	}
}
