package de.illner.codejam;

import java.io.FileNotFoundException;

public interface ICodejam {

	void solve(Class<?> caller, String inFile, String outFile) throws FileNotFoundException;

}
