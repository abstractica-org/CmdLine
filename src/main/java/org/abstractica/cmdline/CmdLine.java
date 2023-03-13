package org.abstractica.cmdline;

import org.abstractica.base.io.textio.TextInput;
import org.abstractica.base.io.textio.TextOutput;
import org.abstractica.base.io.textio.terminal.TerminalOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CmdLine
{
	public static int runCommand(String cmd, TextOutput processOut)
	{
		try
		{
			boolean isWindows = System.getProperty("os.name")
					.toLowerCase().startsWith("windows");
			String prefix = isWindows ? "cmd.exe /c " : "sh -c ";
			processOut.println("Running cmd: " + cmd);
			Process process = Runtime.getRuntime().exec(prefix + cmd);
			new BufferedReader(new InputStreamReader(process.getInputStream())).lines()
					.forEach(str ->processOut.println(str));
			int exitCode = process.waitFor();
			processOut.println("Command exit code: " + exitCode);
			return exitCode;
		}catch(Exception e)
		{
			throw new RuntimeException("Could not run command: " + cmd, e);
		}
	}

	public static int runCommand(String cmd)
	{
		return runCommand(cmd, new TerminalOutput());
	}
}
