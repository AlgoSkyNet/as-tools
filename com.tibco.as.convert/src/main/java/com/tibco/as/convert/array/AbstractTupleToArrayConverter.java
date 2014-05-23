package com.tibco.as.convert.array;

import java.util.Collection;

import com.tibco.as.accessors.ITupleAccessor;
import com.tibco.as.convert.TupleToObjectConverter;

public abstract class AbstractTupleToArrayConverter<T> extends
		TupleToObjectConverter<T[]> {

	public AbstractTupleToArrayConverter(Collection<ITupleAccessor> accessors) {
		super(accessors);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void set(T[] array, Object value, int index) {
		array[index] = (T) value;
	}

}
