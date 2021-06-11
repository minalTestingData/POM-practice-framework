package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
	int count = 0;
	int maxRetryCount = 1;
	@Override
	public boolean retry(ITestResult result) {		
			while(count<maxRetryCount) {
				count++;
				return true;
			}		
		return false;
	}
	
}
  