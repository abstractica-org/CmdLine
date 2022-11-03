package org.abstractica.base.io.textio;

import org.abstractica.base.io.Output;

public interface TextOutput extends Output<String>
{
	default void print(String str)
	{
		putNext(str);
	}
	default void println(String str)
	{
		putNext(str);
		putNext(System.lineSeparator());
	}
	default void println()
	{
		putNext(System.lineSeparator());
	}
}
