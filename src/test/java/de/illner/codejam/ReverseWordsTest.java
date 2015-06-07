package de.illner.codejam;

import static org.apache.commons.io.FileUtils.readFileToString;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

public class ReverseWordsTest extends AbstractCodejamTest {

	@Override
	public void testWithSmallInput() throws IOException {
		classToTest.solve(ReverseWordsTest.class, ReverseWords.IN_SMALL, ReverseWords.OUT_SMALL);
		assertEquals(MESSAGE, readFileToString(new File(path + ReverseWords.OUT_SMALL)),
				readFileToString(new File(path + "solution-small.out")));
	}

	@Override
	public void testWithLargeInput() throws IOException {
		classToTest.solve(ReverseWordsTest.class, ReverseWords.IN_LARGE, ReverseWords.OUT_LARGE);
		assertEquals(MESSAGE, readFileToString(new File(path + ReverseWords.OUT_LARGE)),
				readFileToString(new File(path + "solution-large.out")));
	}

	@Override
	protected Class<? extends ICodejam> getClassOfClassToTest() {
		return ReverseWords.class;
	}
}