package com.tibco.as.io.file2as;

import com.beust.jcommander.JCommander;
import com.tibco.as.io.cli.Application;

public class File2AS extends Application {

	public static void main(String[] args) throws Exception {
		new File2AS().execute(args);
	}

	@Override
	protected void addCommands(JCommander jc) {
		jc.addCommand(new CommandImportDelimited());
		jc.addCommand(new CommandExportDelimited());
	}

	@Override
	protected String getProgramName() {
		return "file2as";
	}

}
