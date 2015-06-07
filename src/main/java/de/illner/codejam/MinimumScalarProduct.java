package de.illner.codejam;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class MinimumScalarProduct implements ICodejam {

	public static final String IN_SMALL = "A-small-practice.in";
	public static final String OUT_SMALL = "A-small-practice.out";
	public static final String IN_LARGE = "A-large-practice.in";
	public static final String OUT_LARGE = "A-large-practice.out";

	public static void main(String[] args) throws FileNotFoundException {
		MinimumScalarProduct minimumScalarProduct = new MinimumScalarProduct();
		minimumScalarProduct.solve(MinimumScalarProduct.class, IN_LARGE, OUT_LARGE);
		System.out.println("Finished successfully!");
	}

	public void solve(Class<?> caller, String inFile, String outFile) throws FileNotFoundException {
		IoHelperForCodejam ioHelper = new IoHelperForCodejam(caller, inFile, outFile);
		int cntTests = Integer.parseInt(ioHelper.getScanner().nextLine());

		for (int test = 1; test <= cntTests; test++) {
			int cntNumbers = Integer.parseInt(ioHelper.getScanner().nextLine());
			ArrayList<BigInteger> vectorOne = convertStringArrayToBigIntegerArray(
					ioHelper.getScanner().nextLine().split(" "));
			ArrayList<BigInteger> vectorTwo = convertStringArrayToBigIntegerArray(
					ioHelper.getScanner().nextLine().split(" "));
			Collections.sort(vectorOne);
			Collections.sort(vectorTwo);

			BigInteger solution = new BigInteger("0");
			for (int i = 0; i < cntNumbers; i++) {
				solution = solution.add((vectorOne.get(i).multiply(vectorTwo.get(cntNumbers - 1 - i))));
			}

			ioHelper.printLineWithWriter("Case #" + test + ": " + solution);
		}
		ioHelper.closeScanner();
		ioHelper.closeWriter();
	}

	private static ArrayList<BigInteger> convertStringArrayToBigIntegerArray(String[] stringArray) {
		ArrayList<BigInteger> intArray = new ArrayList<>();
		for (int i = 0; i < stringArray.length; i++) {
			intArray.add(BigInteger.valueOf(Long.parseLong(stringArray[i])));
		}
		return intArray;
	}

}
