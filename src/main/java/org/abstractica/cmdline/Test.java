package org.abstractica.cmdline;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Test
{
	public static void main(String[] args) throws IOException, ExecutionException, InterruptedException
	{
		CmdLine.runCommand("dir");
	}
}
