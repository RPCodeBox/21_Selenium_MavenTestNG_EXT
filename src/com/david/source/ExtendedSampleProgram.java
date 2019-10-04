package com.david.source;

import org.testng.annotations.TestInstance;

public class ExtendedSampleProgram extends Sampleprograms{
	
	public void testInheritance()
	{
		String revStr = reverseStr("DAVID");
	}
	
	public static void main(String args[])
	{
		ExtendedSampleProgram esp = new ExtendedSampleProgram();
		esp.testInheritance();
		
	}

}
