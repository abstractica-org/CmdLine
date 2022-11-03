package org.abstractica.base.io.sequence;

import org.abstractica.base.io.Output;

public interface OutputSequence<T> extends Output<T>
{
	void endOfSequence();
}
