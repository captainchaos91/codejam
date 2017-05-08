package de.illner.codejam;


import java.io.FileNotFoundException;


abstract class Codejam
{

    final void solve(Class< ? > caller, String inFile, String outFile) throws FileNotFoundException
    {
        IoHelperForCodejam ioHelper = new IoHelperForCodejam(caller, inFile, outFile);
        solveProblem(ioHelper);
        ioHelper.closeScanner();
        ioHelper.closeWriter();
    }


    abstract void solveProblem(IoHelperForCodejam ioHelper);

}
