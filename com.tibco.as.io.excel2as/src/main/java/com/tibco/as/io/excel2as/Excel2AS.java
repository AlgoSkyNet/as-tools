package com.tibco.as.io.excel2as;

import com.beust.jcommander.JCommander;
import com.tibco.as.io.cli.Application;

public class Excel2AS extends Application {

	public static void main(String[] args) throws Exception {
		new Excel2AS().execute(args);
	}

	@Override
	protected void addCommands(JCommander jc) {
		jc.addCommand(new CommandImportExcel());
		jc.addCommand(new CommandExportExcel());
	}

	@Override
	protected String getProgramName() {
		return "file2as";
	}

}
