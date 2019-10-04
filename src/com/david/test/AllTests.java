package com.david.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import junit.framework.Test;
import junit.framework.TestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestCisco.class, TestCiscoBang.class})
public class AllTests {
	
	}
