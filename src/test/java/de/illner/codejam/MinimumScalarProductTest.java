package de.illner.codejam;

import static org.apache.commons.io.FileUtils.readFileToString;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

public class MinimumScalarProductTest extends AbstractCodejamTest {

	@Override
	public void testWithSmallInput() throws IOException {
		classToTest.solve(MinimumScalarProductTest.class, MinimumScalarProduct.IN_SMALL,
				MinimumScalarProduct.OUT_SMALL);
		assertEquals(MESSAGE, readFileToString(new File(path + MinimumScalarProduct.OUT_SMALL)),
				readFileToString(new File(path + "solution-small.out")));
	}

	@Override
	public void testWithLargeInput() throws IOException {
		classToTest.solve(MinimumScalarProductTest.class, MinimumScalarProduct.IN_LARGE,
				MinimumScalarProduct.OUT_LARGE);
		assertEquals(MESSAGE, readFileToString(new File(path + MinimumScalarProduct.OUT_LARGE)),
				readFileToString(new File(path + "solution-large.out")));
	}

	@Override
	protected Class<? extends AbstractCodejam> getClassOfClassToTest() {
		return MinimumScalarProduct.class;
	}
}