package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseTest.BaseTest;

public class ElementFetch {
	
	public WebElement getWebElement(String identifierType, String identifierValue) {
		switch(identifierType) {
		case "ID" :
			return BaseTest.driver.findElement(By.id(identifierValue));
			
		case "NAME" :
			return BaseTest.driver.findElement(By.name(identifierValue));
			
		case "XPATH" :
			return BaseTest.driver.findElement(By.xpath(identifierValue));
			
		case "TAGNAME" :
			return BaseTest.driver.findElement(By.tagName(identifierValue));
			
		case "CSS" :
			return BaseTest.driver.findElement(By.className(identifierValue));
			
		case "LINKTEXT" :
			return BaseTest.driver.findElement(By.linkText(identifierValue));
			
		case "PARTIALLINKTEXT" :
			return BaseTest.driver.findElement(By.partialLinkText(identifierValue));
			
			default :
				return null;
		}	
		
	}
	
	public List<WebElement> getListWebElements(String identifierType, String identifierValue) {
		switch(identifierType) {
		case "ID" :
			return BaseTest.driver.findElements(By.id(identifierValue));
			
		case "NAME" :
			return BaseTest.driver.findElements(By.name(identifierValue));
			
		case "XPATH" :
			return BaseTest.driver.findElements(By.xpath(identifierValue));
			
		case "TAGNAME" :
			return BaseTest.driver.findElements(By.tagName(identifierValue));
			
		case "CSS" :
			return BaseTest.driver.findElements(By.className(identifierValue));
			
		case "LINKTEXT" :
			return BaseTest.driver.findElements(By.linkText(identifierValue));
			
		case "PARTIALLINKTEXT" :
			return BaseTest.driver.findElements(By.partialLinkText(identifierValue));
			
			default :
				return null;
		}		
		
	}

}
