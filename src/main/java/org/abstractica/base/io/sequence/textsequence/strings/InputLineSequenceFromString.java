package org.abstractica.base.io.sequence.textsequence.strings;

import org.abstractica.base.io.sequence.textsequence.InputLineSequence;

public class InputLineSequenceFromString implements InputLineSequence
{
	private final String[] lines;
	private int pos;

	public InputLineSequenceFromString(String str)
	{
		lines = str.split("\\r?\\n");
		pos = 0;
	}

	@Override
	public boolean hasNext()
	{
		return pos < lines.length;
	}

	@Override
	public String getNext()
	{
		return lines[pos++];
	}
}
