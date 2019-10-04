package com.david.source;

import java.io.IOException;
import java.io.InputStream;

public class CallVBSFromBat {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception  {
		
		
		// TODO Auto-generated method stub
		
		/* String[] commands = new String[]{};
		 commands = new String[]{"cmd.exe", "/c", "C:\\david\\VBScript\\OpenDSR.bat"};
		 //System.out.println("Executing AutoIT");
		 Runtime.getRuntime().exec(commands);*/
		
		 Runtime runtime = Runtime.getRuntime();
		 try {
		     Process p1 = runtime.exec("cmd /c start C:\\david\\VBScript\\OpenDSR.bat");
		     InputStream is = p1.getInputStream();
		     int i = 0;
		     while( (i = is.read() ) != -1) {
		         System.out.print((char)i);
		     }
		 } catch(IOException ioException) {
		     System.out.println(ioException.getMessage() );
		 }
		

	}

}
