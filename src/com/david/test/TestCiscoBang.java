package com.david.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.david.source.CiscoBangalore;
import com.david.source.CiscoSan;

public class TestCiscoBang {

CiscoSan CBang = new CiscoBangalore();
	
	@Test
	public void testHasClubHouse() {
		assertTrue("Its having a club house", CBang.hasClubHouse());
	}

	@Test
	public void testHasGoodCafetaria() {
		assertTrue("Its having a cafeteria", CBang.hasGoodCafetaria());
	}

	@Test
	public void testAbout() {
		assertEquals("Located in Sanjose US", CBang.About());
	}

	@Test
	public void testNoOfQACCMembers() {
		assertEquals(30, CBang.noOfQACCMembers());
	}

	
}
