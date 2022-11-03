package org.abstractica.base.io.textio.terminal;

import org.abstractica.base.io.textio.TextInput;

import java.util.Scanner;

public class TerminalInput implements TextInput
{
	private static final Scanner scanner = new Scanner(System.in);
	@Override
	public String getNext()
	{
		return scanner.nextLine();
	}
}
