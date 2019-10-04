package com.david.source;

import java.util.Scanner;

public class Sampleprograms {
	
	public String reverseStr(String inputStr)
	{
			String original, reverse ="";
			Scanner in = new Scanner(inputStr);
	 
			System.out.println("Enter a string to reverse");
			original = in.nextLine();
	 
			int length = original.length();
	 
			for ( int i = length - 1 ; i >= 0 ; i-- )
				reverse = reverse + original.charAt(i);
	 
			System.out.println("Reverse of entered string is "+reverse);
			
			return reverse;
	}
	
	
	public int Addnumbers (String num1, String num2)
	{
			int a = Integer.parseInt(num1);
			int b = Integer.parseInt(num2);
			int sum = a + b;
			System.out.println("Sum: " + sum);
			
			return sum;
	}

}
