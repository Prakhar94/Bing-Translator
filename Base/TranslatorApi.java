package com.BingTranslator.Base;

import org.openqa.selenium.WebDriver;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

public class TranslatorApi {
	public static String txt;
	public static String frm;
	public static String t;
	
	public static String translatedText;
	
	public void start(WebDriver driver) throws Exception {
		// TODO Auto-generated method stub
		
		FileHandling ff=new FileHandling();
		txt= (ff.text).toUpperCase();
		frm= ff.from.toUpperCase();
		t=ff.to.toUpperCase();
		
		Translate.setClientId("8a132e1b-da1f-48a9-bf12-653ac99b289c");
	    Translate.setClientSecret("tpfhG35SXmW9ysmbpPHO+EgBS1c8n3n5lB1st5qMug0");
//	    System.out.println("training");
	    translatedText = Translate.execute(txt, Language.valueOf(frm), Language.valueOf(t));


	    System.out.println(translatedText);


	}

}
