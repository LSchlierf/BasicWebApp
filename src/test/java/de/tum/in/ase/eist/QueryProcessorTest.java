package de.tum.in.ase.eist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class QueryProcessorTest {

	private final QueryProcessor queryProcessor = new QueryProcessor();

	@Test
	void testEmptyStringIfCannotProcessQuery() {
		assertEquals("", queryProcessor.process("test"));
	}

	@Test
	void testKnowsAboutShakespeare() {
		String actual = queryProcessor.process("Shakespeare");
		if (!actual.contains("playwright")) {
			fail("The QueryProcessor does not know about Shakespeare.");
		}
	}

	@Test
	void isNotCaseSensitive() {
		String actual = queryProcessor.process("shakespeare");
		if (!actual.contains("playwright")) {
			fail("Your QueryProcessor should not be case sensitive.");
		}
	}


	@Test
	void testCanAdd() {
		String actual = queryProcessor.process("what is 12 plus 23");
		if(!actual.equals("35")) {
			fail("addition is wrong");
		}
	}

	@Test
	void testFindLargestNumber() {
		String actual = queryProcessor.process("fbe5b3e0: which of the following numbers is the largest: 360, 92, 37, 169");
		assertEquals("360", actual);
	}

	@Test
	void testCanMultiply() {
		String actual = queryProcessor.process("3775a920: what is 13 multiplied by 17");
		assertEquals("221", actual);
	}

}
