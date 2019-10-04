package com.david.test;

import org.testng.Assert;
import org.testng.annotations.*;
import com.david.source.*;


public class Test1 {
	@Test(groups = { "functest", "checkintest" })
	public void testMethod1() {
	}

	@Test(groups = { "functest", "checkintest" })
	public void testMethod2() {
	}

	@Test(groups = { "functest" })
	public void testMethod3() {
	}
}
