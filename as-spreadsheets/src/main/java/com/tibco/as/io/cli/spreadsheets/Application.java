package com.tibco.as.io.cli.spreadsheets;

import com.beust.jcommander.JCommander;
import com.tibco.as.io.cli.AbstractCLIApplication;

public class Application extends AbstractCLIApplication {

	public static void main(String[] args) throws Exception {
		new Application().execute(args);
	}

	@Override
	protected void addCommands(JCommander jc) {
		jc.addCommand(new CommandImportExcel());
		jc.addCommand(new CommandExportExcel());
	}

	@Override
	protected String getProgramName() {
		return "as-spreadsheets";
	}

}
