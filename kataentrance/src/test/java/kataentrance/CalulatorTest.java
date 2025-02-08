package kataentrance;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class CalulatorTest {

	@Test
	void testAddirionArabicMustBeEqualThree() throws InvalidInputException {
		String inputString = "1 + 2";
		String expected = "3";
		Main testObject = new Main();
		String resoult = testObject.calc(inputString);
		assertEquals(expected,resoult);
	}
	
	@Test
	void testRomanDevisinMustBeEqualTwo() throws InvalidInputException {
		String inputString = "VI / III";
		String expected = "II";
		Main testObject = new Main();
		String resoult = testObject.calc(inputString);
		assertEquals(expected,resoult);
	}

	@Test
	void testMustThrowExcepitonOrFail() throws InvalidInputException {
		
			String inputString = "I - II";
			String expected = "I";
			Main testObject = new Main();
			String resoult = testObject.calc(inputString);
			if (resoult == expected) {
				fail();
			}
	}
	
	@Test
	void testMustThrowExceptionOrFail2() throws InvalidInputException {
		String inputString = "I + 1";
		String expected = "2";
		Main testObject = new Main();
		String resoult = testObject.calc(inputString);
		if (resoult == expected) {
			fail();
		}
	}
	
	@Test
	void testMustMultiplyCorrectly() throws InvalidInputException {
		String inputString = "IX * X";
		String expected = "XC";
		Main testObject = new Main();
		String resoult = testObject.calc(inputString);
		assertEquals(expected,resoult);

	}
}
