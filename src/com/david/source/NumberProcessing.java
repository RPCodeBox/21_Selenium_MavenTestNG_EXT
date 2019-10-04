package com.david.source;

public class NumberProcessing {

	public int addNumbers(int n1, int n2) {
		int sum = n1 + n2;
		return sum;
	}

	public int subNumbers(int n1, int n2) {
		int remainder = 0;
		if (n1 > n2) {
			remainder = n1 - n2;
		} else {
			remainder = n2 - n1;
		}
		return remainder;
	}

	public int divideNumbers(int n1, int n2) {
		int quotient = 0;
		quotient = n1 / n2;
		return quotient;
	}

}
