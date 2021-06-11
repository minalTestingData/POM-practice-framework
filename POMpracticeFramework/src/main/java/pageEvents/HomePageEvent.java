package pageEvents;

import BaseTest.BaseTest;
import pageObjects.HomePageElement;
import utils.ElementFetch;

public class HomePageEvent {

	public void ClickSigninButton() {
		ElementFetch EF = new ElementFetch();
	BaseTest.test.info("Clicking Sign in button");
		EF.getWebElement("XPATH", HomePageElement.signinbtn).click();
		
	}
}
