package com.BingTranslator.Base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.memetix.mst.language.Language;

public class ApiTranslator {
	BingToken b= new BingToken();
	FileHandling fff= new FileHandling();
	TranslatorApi tt= new TranslatorApi();
	String token = b.getOauthToken();
	public static String str=null; 
	
	
	
	public void start() throws IOException, ParserConfigurationException, SAXException {

		// TODO Auto-generated method stub
		System.out.println(token);
		Language from = Language.valueOf(tt.frm);
		String text = tt.txt;
		Language to = Language.valueOf(tt.t);;
		
		String uri = "http://api.microsofttranslator.com/v2/Http.svc/Translate?text=" + text + "&from=" + from.toString() + "&to=" + to.toString();
		String authToken = "Bearer" + " " + token;
		URL url = new URL(uri);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Authorization" , authToken);
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) 
		{
			response.append(inputLine);
		}		
		String aip = new String(response);
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	    InputSource is = new InputSource();
	    is.setCharacterStream(new StringReader(aip));
	    org.w3c.dom.Document doc = db.parse(is);
	    org.w3c.dom.Element e= doc.getDocumentElement();
	    str= e.getTextContent();
		System.out.println(str);
		TestBingTranslator t=new TestBingTranslator();
//        t.test( str , str );

	}

}
