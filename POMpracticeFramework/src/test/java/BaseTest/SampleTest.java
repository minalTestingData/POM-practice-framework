package BaseTest;



import org.testng.annotations.Test;

import pageEvents.HomePageEvent;
import pageEvents.LoginPageEvent;

public class SampleTest extends BaseTest{
	
	@Test
	public void TestRunMethod() {
		HomePageEvent homepageevents = new HomePageEvent();	
		homepageevents.ClickSigninButton();
		
		LoginPageEvent loginpageevents = new LoginPageEvent();	
		loginpageevents.LoginPgOpenOrNot();
		loginpageevents.EnterEmailAddress();
	}

		
}
