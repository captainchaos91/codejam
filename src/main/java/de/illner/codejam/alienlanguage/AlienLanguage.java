package de.illner.codejam.alienlanguage;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import de.illner.codejam.IoHelperForCodejam;

public class AlienLanguage {
	
	//private static final String inFile = "A-small-practice.in";
	//private static final String outFile = "A-small-practice.out";
	private static final String inFile = "A-large-practice.in";
	private static final String outFile = "A-large-practice.out";

	public static void main(String[] args) throws FileNotFoundException {

		IoHelperForCodejam ioHelper = new IoHelperForCodejam(AlienLanguage.class, inFile, outFile);
		
		ioHelper.getScanner().nextInt();
		int nWords = ioHelper.getScanner().nextInt();
		int nTestCases = ioHelper.getScanner().nextInt();
		
		ioHelper.getScanner().nextLine();
		ArrayList<String> wordsList = new ArrayList<>(nWords);
		
		for (int i=0; i<nWords; i++)
		{
			wordsList.add(ioHelper.getScanner().nextLine());
		}
		
		for (int i=0; i<nTestCases; i++)
		{
			Pattern pattern = Pattern.compile(ioHelper.getScanner().nextLine().replace('(', '[').replace(')', ']'));
			int count = 0;
			
			for (String word : wordsList)
			{
				Matcher m = pattern.matcher(word);
				if (m.matches())
				{
					count++;
				}
			}
			ioHelper.printLineWithWriter("Case #" + (i+1) + ": " + count);
		}
		ioHelper.closeScanner();
		ioHelper.closeWriter();
	}

}
