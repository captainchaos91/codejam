package de.illner.codejam;

import static org.apache.commons.io.FileUtils.readFileToString;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

public class StoreCreditTest extends AbstractCodejamTest {

	@Override
	public void testWithSmallInput() throws IOException {
		classToTest.solve(StoreCreditTest.class, StoreCredit.IN_SMALL, StoreCredit.OUT_SMALL);
		assertEquals(MESSAGE, readFileToString(new File(path + StoreCredit.OUT_SMALL)),
				readFileToString(new File(path + "solution-small.out")));
	}

	@Override
	public void testWithLargeInput() throws IOException {
		classToTest.solve(StoreCreditTest.class, StoreCredit.IN_LARGE, StoreCredit.OUT_LARGE);
		assertEquals(MESSAGE, readFileToString(new File(path + StoreCredit.OUT_LARGE)),
				readFileToString(new File(path + "solution-large.out")));
	}

	@Override
	protected Class<? extends AbstractCodejam> getClassOfClassToTest() {
		return StoreCredit.class;
	}
}