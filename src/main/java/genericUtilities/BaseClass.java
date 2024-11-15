package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.AllProductsPage;
import objectRepository.LoginPage;

/**
 * This class consists of basic configuration annotations of TestNG
 * @author Adnan
 */

public class BaseClass {
	
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	
	public WebDriver driver;
	
	/*Used for listener*/
	public static WebDriver sDriver;
	
	@BeforeSuite(groups = {"Smoke","Regression"})
	public void bsconfig()
	{
		System.out.println("-----Database connection successful-----");
	}
	
	//@Parameters("browser")
	//@BeforeTest(alwaysRun = true)
	@BeforeClass(alwaysRun = true)
	public void bcconfig(/*String BROWSER*/) throws IOException
	{
		
		/*For cross browser execution*/
//		if(BROWSER.equalsIgnoreCase("Chrome"))
//		{
//			driver = new ChromeDriver();
//		}
//		else if (BROWSER.equalsIgnoreCase("Edge")) 
//		{
//			driver = new EdgeDriver();
//		}
//		else
//		{
//			driver = new ChromeDriver();
//		}
		
		String URL = pUtil.readDataFromPropertyFile("url");
		
		driver = new ChromeDriver();
		
		sUtil.maximizeWindow(driver);
		sUtil.implicitlyWait(driver);
		
		driver.get(URL);
		
		System.out.println("-----Browser launch successful-----");
		
		/*Used for listener*/
		sDriver = driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmconfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("StandardUser");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("-----Login to application successful-----");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amconfig()
	{
		AllProductsPage app = new AllProductsPage(driver);
		app.logoutOfApp();
		
		System.out.println("-----logout of application successful-----");
	}
	
	//@AfterTest(alwaysRun = true)
	@AfterClass(alwaysRun = true)
	public void acconfig()
	{
		driver.quit();
		
		System.out.println("-----Browser closed successfully-----");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asconfig()
	{
		System.out.println("-----Database closure successful-----");
	}

}
