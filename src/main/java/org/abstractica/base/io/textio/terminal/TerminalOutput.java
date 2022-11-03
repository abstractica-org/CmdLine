package org.abstractica.base.io.textio.terminal;

import org.abstractica.base.io.textio.TextOutput;

public class TerminalOutput implements TextOutput
{
	@Override
	public void putNext(String item)
	{
		System.out.print(item);
	}
}
