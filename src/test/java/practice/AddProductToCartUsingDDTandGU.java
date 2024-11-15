package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;

public class AddProductToCartUsingDDTandGU {
	
	public static void main(String[] args) throws IOException {
		
		//Create Object of Utility Classes
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		//Read the common data from property file
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("StandardUser");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		//Read the test data from excel file
		String PRODUCTNAME1 = eUtil.readDataFromExcel("Products", 1, 2);
		
		//Step 1: Launch the browser
		WebDriver driver = new ChromeDriver();
		
		sUtil.maximizeWindow(driver);
		sUtil.implicitlyWait(driver);
		
		//Step 2: Load the URL
		driver.get(URL);
		
		//Step 3: Login to application
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
		//Step 4: Click on the product
		driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME1+"']")).click();
		String ProductTitle = driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME1+"']")).getText();
		System.out.println("Product clicked on: "+ProductTitle);
		
		//Step 5: Add to cart
		driver.findElement(By.id("add-to-cart")).click();
		
		//Step 6: Open Cart
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		
		//Step 7: Validating
		String ProductInCart = driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME1+"']")).getText();
		System.out.println("Product in cart: "+ProductInCart);
		if(ProductInCart.equalsIgnoreCase(ProductInCart))
		{
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
		driver.close();
	}

}
