package com.david.source;

public class TestSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
			Sampleprograms sp = new Sampleprograms();
			String reversdStr = sp.reverseStr("CIVIC");
			if (reversdStr.equalsIgnoreCase("CIVIC"))
			{
				System.out.println("reverseStr API passed for first scenario..");
			}
			else
			{
			System.out.println("reverseStr API failed for first scenario..");
			}
			
			if (reversdStr.equalsIgnoreCase("Malayalam"))
			{
				System.out.println("reverseStr API passed for second scenario..");
			}
			else
			{
			System.out.println("reverseStr API failed for second scenario..");
			}

	}

}
