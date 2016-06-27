package com.BingTranslator.Base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.memetix.mst.translate.Translate;

public class TestBingTranslator {
WebDriver driver;
	
		// TODO Auto-generated method stub
	ApiTranslator ap= new ApiTranslator();
	String x= ap.str;
	Webelements wb=new Webelements();
	String y=wb.translate;
		

	
	@BeforeTest
	public void Test01_openBrowser() throws Exception
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.bing.com/translator");
		
		FileHandling f=new FileHandling();
		f.start(driver);
	}
	
	
	
	@Test
	  public void httpstest(){
		Assert.assertEquals(x , y ,"Do not match");
		System.out.println("True");
	}
	
	@Test
	public void Test04_Api() throws Exception{
		TranslatorApi tt= new TranslatorApi();
		tt.start(driver);
		
	}
	
	@Test
	public void Test05_ApiTranslator() throws IOException, ParserConfigurationException, SAXException{
		ApiTranslator a= new ApiTranslator();
		a.start();
		
	}
	
}
