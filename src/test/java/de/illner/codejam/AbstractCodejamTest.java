package de.illner.codejam;


import java.io.IOException;

import org.junit.Before;
import org.junit.Test;


public abstract class AbstractCodejamTest
{

    String path;
    static final String MESSAGE = "The solution is incorrect!";
    Codejam classToTest;


    @Before
    public void setPath() throws InstantiationException, IllegalAccessException
    {
        classToTest = getClassToTest().newInstance();
        path = "src/test/resources/" + (this.getClass().getName().substring(0, this.getClass().getName().length() - 4).toLowerCase() + "/").replace('.', '/');
    }


    @Test
    abstract public void testWithSmallInput() throws IOException;


    @Test
    abstract public void testWithLargeInput() throws IOException;


    abstract Class< ? extends Codejam> getClassToTest();
}
