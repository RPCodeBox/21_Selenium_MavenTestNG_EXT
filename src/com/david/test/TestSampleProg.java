package com.david.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.david.source.Sampleprograms;

public class TestSampleProg {

	Sampleprograms Sp = new Sampleprograms();
	String sampleStr = "This is TEST Prog";
	
	@Test
	public void testReverseStr() {
		assertEquals("ESREVER", Sp.reverseStr("REVERSE"));
		
	}
	@Test
	public void testReverseStr6() {
		assertEquals(sampleStr, Sp.reverseStr("gorP TSET si sihT"));
		
	}
	
	
	
	@Test
	public void testAddnumbers() {
		assertEquals(20, Sp.Addnumbers("15", "5"));
	}
	
	@Test
	public void testReverseStr1() {
		assertEquals("ESREVER ", Sp.reverseStr("REVERSE"));
	}
	
	@Test
	public void testReverseStr2() {
		assertEquals("ESREVER ", Sp.reverseStr("Reverse"));
	}
	
	@Test
	public void testAddnumbers1() {
		assertEquals(20, Sp.Addnumbers("Fifteen", "Five"));
	}

}
