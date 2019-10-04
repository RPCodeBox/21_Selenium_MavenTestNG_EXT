package com.david.source;

public class RunCisco {
	
	public static void main (String args[])
	{
		CiscoSan CSan = new CiscoSan();
		CiscoBangalore CBang = new CiscoBangalore();
		
		System.out.println ("Is Cafteria there in Cisco Office " + CSan.hasGoodCafetaria());
		System.out.println ("Is Cafteria there in Cisco campus " + CBang.hasGoodCafetaria());
		
		
	}

}
