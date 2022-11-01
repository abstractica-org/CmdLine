package org.abstractica.cmdline;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class CmdLine
{
	public static boolean runCommand(String cmd)
	{
		try
		{
			boolean isWindows = System.getProperty("os.name")
					.toLowerCase().startsWith("windows");
			String prefix = isWindows ? "cmd.exe /c " : "sh -c ";
			Process process = Runtime.getRuntime().exec(prefix + cmd);
			StreamReader streamReader =
					new StreamReader(process.getInputStream(), System.out::println);
			streamReader.run();
			int exitCode = process.waitFor();
			return exitCode == 0;
		}catch(Exception e)
		{
			return false;
		}
	}

	private static class StreamReader implements Runnable {
		private InputStream inputStream;
		private Consumer<String> consumer;

		public StreamReader(InputStream inputStream, Consumer<String> consumer) {
			this.inputStream = inputStream;
			this.consumer = consumer;
		}

		@Override
		public void run() {
			new BufferedReader(new InputStreamReader(inputStream)).lines()
					.forEach(consumer);
		}
	}
}
