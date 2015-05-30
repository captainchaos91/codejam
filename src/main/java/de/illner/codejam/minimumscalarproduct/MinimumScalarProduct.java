package de.illner.codejam.minimumscalarproduct;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

import de.illner.codejam.IoHelperForCodejam;

public class MinimumScalarProduct {

	//private static final String inFile = "A-small-practice.in";
	//private static final String outFile = "A-small-practice.out";
	private static final String inFile = "A-large-practice.in";
	private static final String outFile = "A-large-practice.out";
	
	public static void main(String[] args) throws FileNotFoundException {
		
		IoHelperForCodejam ioHelper = new IoHelperForCodejam(MinimumScalarProduct.class, inFile, outFile);
		int cntTests = Integer.parseInt(ioHelper.getScanner().nextLine());
		
		for (int test = 1; test <= cntTests; test++)
		{
			int cntNumbers = Integer.parseInt(ioHelper.getScanner().nextLine());
			ArrayList<BigInteger> vectorOne = convertStringArrayToBigIntegerArray(ioHelper.getScanner().nextLine().split(" "));
			ArrayList<BigInteger> vectorTwo = convertStringArrayToBigIntegerArray(ioHelper.getScanner().nextLine().split(" "));
			Collections.sort(vectorOne);
			Collections.sort(vectorTwo);
			
			BigInteger solution = new BigInteger("0");
			for (int i = 0; i < cntNumbers; i++)
			{
				solution = solution.add((vectorOne.get(i).multiply(vectorTwo.get(cntNumbers - 1 - i))));
			}
			
			ioHelper.printLineWithWriter("Case #" + test + ": " + solution);
		}
		ioHelper.closeScanner();
		ioHelper.closeWriter();
	}

	private static ArrayList<BigInteger> convertStringArrayToBigIntegerArray(String[] stringArray)
	{
		ArrayList<BigInteger> intArray = new ArrayList<>();
		for (int i = 0; i < stringArray.length; i++)
		{
			intArray.add(BigInteger.valueOf(Long.parseLong(stringArray[i])));
		}
		return intArray;
	}

}
