package com.BingTranslator.Base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class FileHandling {
	
	//content reading
	 public static String sb= null;
	 public static String from=null;
	 public static String to=null;
	 public static String text=null;
	
	 public void start(WebDriver driver) throws Exception {
		// TODO Auto-generated method stub
		
		    
		 BufferedReader br = new BufferedReader(new FileReader("/home/prakharkumartiwari/workspace/BingTranslator/src/com/BingTranslator/Base/file"));
		    try {
		       
		        String line = br.readLine();

		        while (line != null) {
		            sb=line;
		            sb.concat("\n");
		            String[] parts = sb.split(",");
				    from = parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1); 
				    to = parts[1].substring(0, 1).toUpperCase() + parts[1].substring(1); 
				    text=parts[2].substring(0, 1).toUpperCase() + parts[2].substring(1);
				    
				    Webelements w2= new Webelements();
				    w2.start(driver);
				    
				    TranslatorApi t= new TranslatorApi();
					t.start(driver);
				    				    
				   System.out.println(from+" "+to+" "+text);
		           line = br.readLine();
		        }
		       // System.out.println(sb);
		    } finally {
		        br.close();
		    }
		    
		   
		    
		   

	}

}
