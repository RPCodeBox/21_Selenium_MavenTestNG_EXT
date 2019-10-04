package com.david.test;

import java.io.File;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelSheetWriter {

	private void writeExcelFile(String fileName) {
		System.out.println("Filename is " + fileName);
		FileOutputStream fileOutputStream = null;

		HSSFWorkbook sampleWorkbook = null;
		HSSFSheet sampleDataSheet = null;
		String randomStr = generateRandomString(null);

		System.out.println("The random String generated is " + randomStr);

		String substr = generateRandomString("GBNAME_UK");

		System.out.println("The Pre String generated is " + substr);
		try {
	

			FileInputStream myInput = new FileInputStream(fileName);
			POIFSFileSystem fs = new POIFSFileSystem(myInput);
			sampleWorkbook = new HSSFWorkbook(fs);
			sampleDataSheet = sampleWorkbook
					.getSheet("SAV_GB_Create_With_One_EL");
			HSSFRow dataRow1 = sampleDataSheet.getRow(1);
			dataRow1.getCell(5).setCellValue(randomStr);
			dataRow1.getCell(6).setCellValue(substr);

			fileOutputStream = new FileOutputStream(fileName);
			sampleWorkbook.write(fileOutputStream);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			/**
			 * Close the fileOutputStream.
			 */
			try {
				if (fileOutputStream != null) {
					fileOutputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	
	public static void main(String[] args) {
	
		ExcelSheetWriter esw = new ExcelSheetWriter();
		esw.writeExcelFile("C:\\david\\SAV_GB_GA.xls");

	}

	public Connection connectDB() {
		Connection connection = null;
		try {
			// Load the JDBC driver
			String driverName = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driverName);

			// Create a connection to the database
			String serverName = "lnxdb-pdv-102.cisco.com";
			String portNumber = "1541";
			String sid = "SITECP";
			String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber
					+ ":" + sid;
			String username = "XXAUDIT";
			String password = "Dp2T7b1W";
			connection = DriverManager.getConnection(url, username, password);
			System.out
					.println("Successfully got connected to the database ...");
		} catch (ClassNotFoundException e) {
			// Could not find the database driver
		} catch (SQLException e) {
			// Could not conect to the database
		}
		return connection;
	}

	public int executeQuery(String query) {
		int elementID = 0;
		try {
			ExcelSheetWriter esw = new ExcelSheetWriter();
			Connection con = esw.connectDB();
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);

			while (res.next()) {
				elementID = res.getInt("ENTITY_ID");

			}
			con.close();
		} catch (Exception e) {

		}

		return elementID;
	}

	public int generateRandomNumber() {
		Random randomGenerator = new Random();
		// for (int idx = 1; idx <= 10; ++idx){
		int randomInt = randomGenerator.nextInt(100);
		System.out.println("Generated : " + randomInt);
		// }
		return randomInt;

	}

	public String generateRandomString(String substr) {

		String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(10);
		for (int i = 0; i < 10; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));

		if (substr == null)
			return sb.toString();
		else
			return substr + sb.toString();

	}

}