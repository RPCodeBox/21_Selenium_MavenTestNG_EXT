package com.david.test;

import org.testng.annotations.Test;

public class Webtest {
	int no;
	public Webtest(int i)
	{
		no = i;
	}
	
	@Test
	public void testFactory(){
		for (int k=0; k< no; k++)
		System.out.println("testing ....");
	}
	}

