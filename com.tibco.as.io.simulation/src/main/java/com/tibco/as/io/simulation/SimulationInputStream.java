package com.tibco.as.io.simulation;

import com.tibco.as.io.IInputStream;

public class SimulationInputStream implements IInputStream<Object[]> {

	private IValueProvider[] providers;

	private long position = 0;

	private Space space;

	private SimulationImport config;

	public SimulationInputStream(SimulationImport config,
			IValueProvider[] providers) {
		this.config = config;
		this.space = config.getSpace();
		this.providers = providers;
	}

	public SimulationImport getConfig() {
		return config;
	}

	@Override
	public void open() throws Exception {
		// do nothing
	}

	@Override
	public void close() throws Exception {
		providers = null;
	}

	@Override
	public boolean isClosed() {
		return providers == null;
	}

	@Override
	public Object[] read() throws Exception {
		Long sleep = space.getSleep();
		if (sleep != null) {
			Thread.sleep(sleep);
		}
		if (isClosed()) {
			return null;
		}
		if (space.getEnd() == null || position < space.getEnd()) {
			Object[] data = new Object[providers.length];
			for (int i = 0; i < providers.length; i++) {
				data[i] = providers[i].getValue();
			}
			position++;
			return data;
		}
		return null;
	}

	@Override
	public long size() {
		Long end = space.getEnd();
		if (end == null) {
			return UNKNOWN_SIZE;
		}
		return end;
	}

	@Override
	public long getPosition() {
		return position;
	}

}
