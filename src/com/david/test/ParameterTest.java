package com.david.test;

import java.util.*;
import org.testng.Assert;
import org.testng.annotations.*;

import com.david.source.*;

import jxl.*;

import java.io.*;

public class ParameterTest {

	NumberProcessing np = new NumberProcessing();
	
	@Test(dataProvider="DP1")
	public void testAddNumbers_p(String Num1, String Num2, String expSum)
	{		
		int arg1 = Integer.parseInt(Num1);
		int arg2 = Integer.parseInt(Num2);
		int arg3 = Integer.parseInt(expSum);
		//System.out.println("Calling TestAddNumbers ..");
		int actualSum = np.addNumbers(arg1, arg2);
		Assert.assertEquals(actualSum, arg3);
	}
	
	@DataProvider(name = "DP1")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=getTableArray("C:\\david\\whitebox testing\\AddNumbers.xls",
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
            e.printStackTrace();
        }

        return(tabArray);
    }
	
}
