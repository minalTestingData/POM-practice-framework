package pageEvents;


import org.testng.Assert;

import BaseTest.BaseTest;
import pageObjects.LoginPageElement;
import utils.ElementFetch;

public class LoginPageEvent {
	
	
	public void LoginPgOpenOrNot() {  
		ElementFetch EF = new ElementFetch();
		BaseTest.test.info("Verify that Login Page open or not");
		Assert.assertTrue(EF.getListWebElements("XPATH", LoginPageElement.signText).size()==0,"Login Page did not open");
		//EF.getWebElement("XPATH", LoginPageElement.uName).sendKeys("Admin");
		//EF.getWebElement("XPATH", LoginPageElement.PassWD).sendKeys("admin123");
		//EF.getWebElement("XPATH", LoginPageElement.Loginbtn).click();
			
	}

	 public void EnterEmailAddress() {
		 ElementFetch EF = new ElementFetch();
		 BaseTest.test.info("Verify that email id is entered.");
		 EF.getWebElement("ID", LoginPageElement.email_id).sendKeys("minaldukare@gmail.com");
	 
	 }
}
