package com.david.test;

import org.testng.annotations.Test;

import com.david.source.NumberProcessing;

public class TestExpectedException {

	@Test(expectedExceptions=ArithmeticException.class)
	public void testDivideNumbers_1()
	{
		NumberProcessing np = new NumberProcessing();
		int actQuotient = np.divideNumbers(1, 0);
		
	}
}
