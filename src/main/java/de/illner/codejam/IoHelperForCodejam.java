package de.illner.codejam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

final class IoHelperForCodejam {

	private Scanner scanner;
	private PrintWriter printWriter;

	IoHelperForCodejam(Class<?> caller, String inFile, String outFile) throws FileNotFoundException {
		// Set line.separator manually to avoid differences between running tests on windows or linux
		System.setProperty("line.separator", "\r\n");
		this.scanner = new Scanner(new File(constructResourcePath(caller) + inFile));
		this.printWriter = new PrintWriter(constructResourcePath(caller) + outFile);
	}

	private String constructResourcePath(Class<?> caller) {
		String[] splittedPackage = caller.getPackage().getName().split("\\.");
		String path;
		String className = caller.getName().substring(caller.getName().lastIndexOf(".") + 1);
		String lastFolder;
		if (className.endsWith("Test")) {
			path = "src/test/resources/";
			lastFolder = className.substring(0, className.length() - 4).toLowerCase();
		} else {
			path = "src/main/resources/";
			lastFolder = className.toLowerCase();
		}

		for (int i = 0; i < splittedPackage.length; i++) {
			path += splittedPackage[i] + "/";
		}
		path += lastFolder + "/";

		return path;
	}

	Scanner getScanner() {
		return scanner;
	}

	void printLineWithWriter(String line) {
		printWriter.println(line);
	}

	void closeScanner() {
		scanner.close();
	}

	void closeWriter() {
		printWriter.close();
	}
}
