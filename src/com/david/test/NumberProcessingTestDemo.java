package com.david.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.david.source.NumberProcessing;

public class NumberProcessingTestDemo {

  @Test
  public void addNumbers() {
    NumberProcessing np = new NumberProcessing();
    int actSum = np.addNumbers(10,20);
    Assert.assertEquals(actSum, 30);
  }

  @Test
  public void divideNumbers() {
	  NumberProcessing np = new NumberProcessing();
	    int actQuo = np.divideNumbers(20,10);
	    Assert.assertEquals(actQuo, 4);
  }

  @Test
  public void subNumbers() {
	  NumberProcessing np = new NumberProcessing();
	    int actRem = np.addNumbers(20,10);
	    Assert.assertEquals(actRem, 10);
  }
  
  
}
