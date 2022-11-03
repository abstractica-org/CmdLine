package org.abstractica.base.io.sequence.textsequence.strings;

import org.abstractica.base.io.sequence.textsequence.OutputLineSequence;

public class OutputLineSequenceToString implements OutputLineSequence
{
	private final StringBuilder builder;
	private boolean closed;

	public OutputLineSequenceToString()
	{
		builder = new StringBuilder();
		closed = false;
	}


	@Override
	public void putNext(String item)
	{
		if(closed)
		{
			throw new RuntimeException("Adding to sequence after it has been closed!");
		}
		builder.append(item);
		builder.append(System.lineSeparator());
	}

	@Override
	public void endOfSequence()
	{
		closed = true;
	}
}
