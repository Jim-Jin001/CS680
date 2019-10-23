package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw01.Calculator;

public class CalculatorTest{
	@Test
	public void multiply3By4() {
		Calculator cut = new Calculator();
		float expected = 12;
		float actual = cut.multiply(3, 4);
		assertTrue(cut instanceof Calculator);
		assertEquals(expected, actual);
	}
	@Test
	public void divide3By2() {
		Calculator cut = new Calculator();
		float expected = (float) 1.5;
		float actual = cut.divide(3, 2);
		assertEquals(expected, actual);
	}
	@Test
	public void divide5By0withTryCatch() {
		Calculator cut = new Calculator();
		try {
			cut.divide(5, 0);
			fail("Division by zero");
		} catch (IllegalArgumentException ex) {
			assertEquals("division by zero", ex.getMessage());
		}
	}
	@Test
	public void multiply2_5By5_5(){
		Calculator cut = new Calculator();
		float expected = 13.75f;
		float actual = cut.multiply(2.5f,5.5f);
		assertEquals(expected, actual);
	}
	@Test
	public void divide5_5By2_5(){
		Calculator cut = new Calculator();
		float expected = 2.2f;
		float actual = cut.divide(5.5f,2.5f);
		assertEquals(expected, actual);
	}
}
