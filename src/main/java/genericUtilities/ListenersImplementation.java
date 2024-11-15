package genericUtilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener interface of TestNG
 */
public class ListenersImplementation implements ITestListener{
	
	/*Capture the current system date and time for screenshot name and report name*/
	Date d = new Date();
	SimpleDateFormat f = new SimpleDateFormat(" dd-MM-yyyy hh-mm-ss");
	String date = f.format(d);
	
	ExtentReports report;
	

	@Override
	public void onTestStart(ITestResult result) {
		
		/*Capture the method name of @Test*/
		String methodName = result.getMethod().getMethodName();
		
		/*@Test execution is started*/
		System.out.println(methodName+" -> Test script execution started");
		
		/*Intimate extent reports for @Test execution*/
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		/*Capture the method name of @Test*/
		String methodName = result.getMethod().getMethodName();
		
		/*@Test execution is PASS*/
		System.out.println(methodName+" -> Test script is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		/*Capture the method name of @Test*/
		String methodName = result.getMethod().getMethodName();
		
		/*@Test execution is FAIL*/
		System.out.println(methodName+" -> Test script is FAIL");
		
		/*Capture the exception*/
		System.out.println(result.getThrowable());
		
		/*Capture the screenshot*/
		SeleniumUtility s = new SeleniumUtility();
		
		/*Screenshot name configured*/
		String screenshotName = methodName+date;
		
		try {
			s.captureScreenShot(BaseClass.sDriver, screenshotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		/*Capture the method name of @Test*/
		String methodName = result.getMethod().getMethodName();
		
		/*@Test execution is SKIP*/
		System.out.println(methodName+" -> Test script is SKIP");
		
		/*Capture the exception*/
		System.out.println(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		/*Suite execution started*/
		System.out.println("Suite execution started");
		
		/*Basic configuration of extent report*/
		ExtentSparkReporter esr = new ExtentSparkReporter("C:\\Users\\Adnan\\eclipse-workspace\\AutomationFramework.QCO-SOEAJD-E12\\ExtentReports"+date+".html");
		esr.config().setDocumentTitle("SWAG LABS execution report");
		esr.config().setReportName("Execution Build version 1.12");
		esr.config().setTheme(Theme.DARK);
		
		/*Feed the configuration to extent report class*/
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Env", "Test Env");
		report.setSystemInfo("Base Browser", "Google Chrome");
		report.setSystemInfo("Base Platform", "Windows 10");
		report.setSystemInfo("Base URL", "test.saucedemo.com");
		report.setSystemInfo("Reporter Name", "Adnan");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		/*Suite execution finished*/
		System.out.println("Suite execution finished");
		
		/*Generate the extent report*/
		report.flush();
	}
	
	

}
