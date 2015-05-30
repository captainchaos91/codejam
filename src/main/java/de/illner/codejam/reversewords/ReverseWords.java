package de.illner.codejam.reversewords;

import java.io.FileNotFoundException;

import de.illner.codejam.IoHelperForCodejam;

public class ReverseWords
{
	//private static final String inFile = "B-small-practice.in";
	//private static final String outFile = "B-small-practice.out";
	private static final String inFile = "B-large-practice.in";
	private static final String outFile = "B-large-practice.out";

	public static void main(String[] args) throws FileNotFoundException
	{
		IoHelperForCodejam ioHelper = new IoHelperForCodejam(ReverseWords.class, inFile, outFile);
		int tests = ioHelper.getScanner().nextInt();
		ioHelper.getScanner().nextLine();
		for (int test=1; test<=tests; test++)
		{
			ioHelper.printLineWithWriter("Case #" + test + ": " + reverse(ioHelper.getScanner().nextLine()));
		}
		ioHelper.closeScanner();
		ioHelper.closeWriter();
	}
	
	
	public static String reverse(String text) {
		String[] words = text.split(" ");
		StringBuilder builder = new StringBuilder(text.length());
		for (int i  =words.length - 1; i >= 0; i--) {
			builder.append(words[i]);
			builder.append(' ');
		}
		builder.deleteCharAt(builder.length()-1);
		return builder.toString();
	}

}