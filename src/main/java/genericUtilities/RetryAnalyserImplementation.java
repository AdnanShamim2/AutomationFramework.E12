package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation to IRetryAnalyzer interface of TestNG
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {
	
	int count = 0;
	int retrycount = 3;
	
	public boolean retry(ITestResult result)
	{
		if(count<retrycount)
		{
			count++;
			return true;// retry
		}
		return false;// not retry
	
	}

	
}
