package de.illner.codejam;

import java.io.FileNotFoundException;

public abstract class AbstractCodejam {

	abstract public void solve(Class<?> caller, String inFile, String outFile) throws FileNotFoundException;

}
