package com.david.test;

import java.util.*;
import org.testng.Assert;
import org.testng.annotations.*;
import com.david.source.*;
import jxl.*;
import java.io.*;


public class NumberProcessingTest {
	
	NumberProcessing np ;
	
    @BeforeClass
	public void beforeTest()
	{
		//System.out.println("I am called before each Method ...");
	}
	
	@BeforeMethod
	public void setUp()
	{
		System.out.println("I am called before each Class ...");
		np = new NumberProcessing();
		
	}
	
	@BeforeTest
	public void afterTest()
	{
		//System.out.println("I am called before each Test ...");
	}
	
	@Test(groups={"ADDITION", "ALL"})
	public void testAddNumbers()
	{
		//System.out.println("Calling TestAddNumbers ..");
		int actualSum = np.addNumbers(10, 20);
		Assert.assertEquals(actualSum, 30);
	}
	
	@Test(groups={"ADDITION", "ALL"})
	public void testAddNumbers_1()
	{
		//System.out.println("Calling TestAddNumbers ..");
		int actualSum = np.addNumbers(-1, -2);
		Assert.assertEquals(actualSum, -3);
	}
	
	@Test(groups={"SUBTRACTION", "ALL"})
	public void testSubNumbers()
	{
		//System.out.println("Calling TestSubNumbers ..");
		int actualRem = np.subNumbers(10, 20);
		Assert.assertEquals(actualRem, 10);
	}
	@Test(groups={"SUBTRACTION", "ALL"})
	public void testSubNumbers_1()
	{
		//System.out.println("Calling TestSubNumbers_1 ..");
		int actualRem = np.subNumbers(20, 10);
		Assert.assertEquals(actualRem, 10);
	}
	
	@AfterClass
	public void tearDown()
	{
		np = null;
	}
	
	@Test(groups={"DIVISION", "ALL"})
	public void testDivideNumbers()
	{
		int actQuotient = np.divideNumbers(20, 10);
		Assert.assertEquals(actQuotient, 2);
	}
	
	@Test(expectedExceptions=ArithmeticException.class, groups={"DIVISION", "ALL"})
	public void testDivideNumbers_1()
	{
		int actQuotient = np.divideNumbers(1, 0);
		//Assert.assertEquals(actQuotient, 0.5);
	}
	
	@Test
	@Parameters({"n1","n2","n3"})
	public void testParameters(int Num1, int Num2, int expSum)
	{
		int actSum = np.addNumbers(Num1,Num2);
		Assert.assertEquals(actSum, expSum);
	}
	
	
	@Test(dataProvider="DP1")
	public void testAddNumbers_p(int Num1, int Num2, int expSum)
	{
		//System.out.println("Calling TestAddNumbers ..");
		int actualSum = np.addNumbers(Num1, Num2);
		Assert.assertEquals(actualSum, expSum);
	}
	
	@DataProvider(name = "DP1")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=getTableArray("C\\david\\whitebox testing\\AddNumbers.xls",
                "ADD", "AddNumber");
        return(retObjArr);
    }
	
	
	
	public String[][] getTableArray(String xlFilePath, String sheetName, String tableName){
        String[][] tabArray=null;
        try{
            Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
            Sheet sheet = workbook.getSheet(sheetName);
            int startRow,startCol, endRow, endCol,ci,cj;
            Cell tableStart=sheet.findCell(tableName);
            startRow=tableStart.getRow();
            startCol=tableStart.getColumn();

            Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,  false);                               

            endRow=tableEnd.getRow();
            endCol=tableEnd.getColumn();
            System.out.println("startRow="+startRow+", endRow="+endRow+", " +
                    "startCol="+startCol+", endCol="+endCol);
            tabArray=new String[endRow-startRow-1][endCol-startCol-1];
            ci=0;

            for (int i=startRow+1;i<endRow;i++,ci++){
                cj=0;
                for (int j=startCol+1;j<endCol;j++,cj++){
                    tabArray[ci][cj]=sheet.getCell(j,i).getContents();
                }
            }
        }
        catch (Exception e)    {
            System.out.println("error in getTableArray()");
        }

        return(tabArray);
    }

}
