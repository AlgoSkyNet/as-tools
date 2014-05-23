package com.tibco.as.io.cli.simulator;

import com.beust.jcommander.ParametersDelegate;
import com.tibco.as.io.cli.AbstractCLIApplication;
import com.tibco.as.io.cli.Command;

public class Application extends AbstractCLIApplication {

	@ParametersDelegate
	private CommandSimulate command = new CommandSimulate();

	public static void main(String[] args) throws Exception {
		new Application().execute(args);
	}

	@Override
	protected String getProgramName() {
		return "as-simulator";
	}

	@Override
	protected Command getDefaultCommand() {
		return command;
	}

}
