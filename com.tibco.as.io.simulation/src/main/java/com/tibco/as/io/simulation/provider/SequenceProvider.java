package com.tibco.as.io.simulation.provider;

import com.tibco.as.io.simulation.IValueProvider;
import com.tibco.as.io.simulation.Sequence;

public class SequenceProvider implements IValueProvider {

	private long index;
	private Long end;

	public SequenceProvider(Sequence field) {
		this.index = field.getStart();
		this.end = field.getEnd();
	}

	@Override
	public Long getValue() {
		return end == null ? index++ : (index++ % end);
	}
}
