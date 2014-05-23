package com.tibco.as.io.cli.files;

import com.beust.jcommander.JCommander;
import com.tibco.as.io.cli.AbstractCLIApplication;

public class Application extends AbstractCLIApplication {

	public static void main(String[] args) throws Exception {
		new Application().execute(args);
	}

	@Override
	protected void addCommands(JCommander jc) {
		jc.addCommand(new CommandImportDelimited());
		jc.addCommand(new CommandExportDelimited());
	}

	@Override
	protected String getProgramName() {
		return "as-files";
	}

}
