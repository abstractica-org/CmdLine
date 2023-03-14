package org.abstractica.cmdline;


public class Test2
{
	public static void execute()
	{
		int exitCode = CmdLine.runCommand("dir");
		System.out.println("Exit code: " + exitCode);
	}
}
