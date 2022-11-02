package org.abstractica.cmdline;

import org.abstractica.base.io.textio.TextInput;
import org.abstractica.base.io.textio.TextOutput;
import org.abstractica.base.io.textio.terminal.TerminalOutput;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class CmdLine
{
	public static void runCommand(String cmd, TextOutput processOut)
	{
		try
		{
			boolean isWindows = System.getProperty("os.name")
					.toLowerCase().startsWith("windows");
			String prefix = isWindows ? "cmd.exe /c " : "sh -c ";
			Process process = Runtime.getRuntime().exec(prefix + cmd);
			new BufferedReader(new InputStreamReader(process.getInputStream())).lines()
					.forEach(str ->processOut.println(str));
			int exitCode = process.waitFor();
		}catch(Exception e)
		{
			throw new RuntimeException("Could not run command: " + cmd, e);
		}
	}

	public static void runCommand(String cmd)
	{
		runCommand(cmd, new TerminalOutput());
	}
}
