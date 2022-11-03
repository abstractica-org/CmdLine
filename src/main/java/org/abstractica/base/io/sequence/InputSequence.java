package org.abstractica.base.io.sequence;

import org.abstractica.base.io.Input;

public interface InputSequence<T> extends Input<T>
{
	boolean hasNext();
}
