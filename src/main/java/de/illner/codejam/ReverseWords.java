package de.illner.codejam;

import java.io.FileNotFoundException;

public class ReverseWords implements ICodejam {

	public static final String IN_SMALL = "B-small-practice.in";
	public static final String OUT_SMALL = "B-small-practice.out";
	public static final String IN_LARGE = "B-large-practice.in";
	public static final String OUT_LARGE = "B-large-practice.out";

	public static void main(String[] args) throws FileNotFoundException {
		ReverseWords reverseWords = new ReverseWords();
		reverseWords.solve(ReverseWords.class, IN_LARGE, OUT_LARGE);
		System.out.println("Finished successfully!");
	}

	public void solve(Class<?> caller, String inFile, String outFile) throws FileNotFoundException {
		IoHelperForCodejam ioHelper = new IoHelperForCodejam(caller, inFile, outFile);
		int tests = ioHelper.getScanner().nextInt();
		ioHelper.getScanner().nextLine();
		for (int test = 1; test <= tests; test++) {
			ioHelper.printLineWithWriter("Case #" + test + ": " + reverse(ioHelper.getScanner().nextLine()));
		}
		ioHelper.closeScanner();
		ioHelper.closeWriter();
	}

	public static String reverse(String text) {
		String[] words = text.split(" ");
		StringBuilder builder = new StringBuilder(text.length());
		for (int i = words.length - 1; i >= 0; i--) {
			builder.append(words[i]);
			builder.append(' ');
		}
		builder.deleteCharAt(builder.length() - 1);
		return builder.toString();
	}

}