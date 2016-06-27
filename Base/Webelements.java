package com.BingTranslator.Base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webelements {
	
	public static String translate;
	
	public void start(WebDriver driver) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		
		// TODO Auto-generated method stub
		FileHandling f= new FileHandling();
		
		// Language selector
		List<WebElement> dropdown= driver.findElements(By.className("LS_Header"));
//		List<WebElement> td= dropdown.get(1).findElements(By.tagName("td"));
			
	     dropdown.get(0).click();
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("(//td[text()='"+f.from+"'])[1]")).click();
	     driver.findElement(By.className("srcTextarea")).sendKeys(f.text);
	     Thread.sleep(2000);
	     dropdown.get(1).click();
	     driver.findElement(By.xpath("(//td[text()='"+f.to+"'])[2]")).click();
	     Thread.sleep(2000);
	     translate=driver.findElement(By.id("destText")).getText();
	     System.out.println(translate);
	     driver.findElement(By.className("srcTextarea")).clear();
	     Thread.sleep(2000);

		

	}

}
