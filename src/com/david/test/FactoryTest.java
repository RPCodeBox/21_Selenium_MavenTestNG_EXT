package com.david.test;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryTest {
  
	
  
  
  @Factory
  public Object[] createInstances() {
   Object[] result = new Object[10]; 
   for (int i = 1; i < 3; i++) {
      result[i] = new Webtest(i * 10);
    return result;
  }
return result;
  }
}

