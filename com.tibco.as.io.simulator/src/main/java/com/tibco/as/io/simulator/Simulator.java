package com.tibco.as.io.simulator;

import com.beust.jcommander.ParametersDelegate;
import com.tibco.as.io.cli.Application;
import com.tibco.as.io.cli.Command;

public class Simulator extends Application {

	@ParametersDelegate
	private CommandSimulate command = new CommandSimulate();

	public static void main(String[] args) throws Exception {
		new Simulator().execute(args);
	}

	@Override
	protected String getProgramName() {
		return "simulator";
	}

	@Override
	protected Command getDefaultCommand() {
		return command;
	}

}
