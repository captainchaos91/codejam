package de.illner.codejam;

import static org.apache.commons.io.FileUtils.readFileToString;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

public class RopeIntranetTest extends AbstractCodejamTest {

	@Override
	public void testWithSmallInput() throws IOException {
		classToTest.solve(RopeIntranetTest.class, RopeIntranet.IN_SMALL, RopeIntranet.OUT_SMALL);
		assertEquals(MESSAGE, readFileToString(new File(path + RopeIntranet.OUT_SMALL)), readFileToString(new File(path + "solution-small.out")));
	}

	@Override
	public void testWithLargeInput() throws IOException {
		classToTest.solve(RopeIntranetTest.class, RopeIntranet.IN_LARGE, RopeIntranet.OUT_LARGE);
		assertEquals(MESSAGE, readFileToString(new File(path + RopeIntranet.OUT_LARGE)), readFileToString(new File(path + "solution-large.out")));
	}

	@Override
	Class<? extends Codejam> getClassToTest() {
		return RopeIntranet.class;
	}
}
