package de.illner.codejam.storecredit;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import de.illner.codejam.IoHelperForCodejam;
import de.illner.codejam.reversewords.ReverseWords;

public class StoreCredit {
	
	//private static final String inFile = "A-small-practice.in";
	//private static final String outFile = "A-small-practice.out";
	private static final String inFile = "A-large-practice.in";
	private static final String outFile = "A-large-practice.out";

	public static void main(String[] args) throws FileNotFoundException {
		
		IoHelperForCodejam ioHelper = new IoHelperForCodejam(ReverseWords.class, inFile, outFile);
		int tests = ioHelper.getScanner().nextInt();
		for (int test = 1; test <= tests; test++)
		{
			List<Integer> solution = findCorrectItemIndices(ioHelper.getScanner());
			ioHelper.printLineWithWriter("Case #" + test + ": " + (solution.get(0) + 1) + " " + (solution.get(1) + 1));
		}
		ioHelper.closeScanner();
		ioHelper.closeWriter();

	}

	private static List<Integer> findCorrectItemIndices(Scanner scanner)
	{
		int credit = scanner.nextInt();
		int items = scanner.nextInt();
		scanner.nextLine();
		String itemLine = scanner.nextLine();
		String [] prices = itemLine.split(" ");
		
		for (int itemOne = 0; itemOne < items - 1; itemOne++)
		{
			for (int itemTwo = itemOne+1; itemTwo < items; itemTwo++)
			{
				if (Integer.parseInt(prices[itemOne]) + Integer.parseInt(prices[itemTwo]) == credit)
				{
					return Arrays.asList(itemOne, itemTwo);
				}
			}
		}
		return null;
	}
	
}
