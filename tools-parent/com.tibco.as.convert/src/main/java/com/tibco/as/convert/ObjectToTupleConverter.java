package com.tibco.as.convert;

import java.util.Collection;

import com.tibco.as.accessors.ITupleAccessor;
import com.tibco.as.space.Tuple;

public abstract class ObjectToTupleConverter<T> implements IConverter<T, Tuple> {

	private ITupleAccessor[] accessors;

	public ObjectToTupleConverter(Collection<ITupleAccessor> accessors) {
		this.accessors = accessors
				.toArray(new ITupleAccessor[accessors.size()]);
	}

	@Override
	public Tuple convert(T element) throws ConvertException {
		Tuple tuple = Tuple.create();
		for (int index = 0; index < accessors.length; index++) {
			ITupleAccessor accessor = accessors[index];
			if (accessor == null) {
				continue;
			}
			Object value = get(element, index);
			if (value == null) {
				continue;
			}
			accessor.set(tuple, value);
		}
		return tuple;
	}

	protected abstract Object get(T element, int index) throws ConvertException;

}
