package com.david.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.david.source.CiscoSan;

public class TestCisco {

	CiscoSan CSan = new CiscoSan();
	
	@Test
	public void testHasClubHouse() {
		assertTrue("Its having a club house", CSan.hasClubHouse());
	}

	@Test
	public void testHasGoodCafetaria() {
		assertTrue("Its having a cafeteria", CSan.hasGoodCafetaria());
	}

	@Test
	public void testAbout() {
		assertEquals("Located in Sanjose US", CSan.About());
	}

	@Test
	public void testNoOfQACCMembers() {
		assertEquals(30, CSan.noOfQACCMembers());
	}

	

}
