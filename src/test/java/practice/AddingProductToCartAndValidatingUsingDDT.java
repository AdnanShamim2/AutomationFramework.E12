package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddingProductToCartAndValidatingUsingDDT {
	public static void main(String[] args) throws InterruptedException, IOException {
				// Reading common data from properties file
				FileInputStream fisp =new FileInputStream("C:\\Users\\Adnan\\eclipse-workspace\\AutomationFramework.QCO-SOEAJD-E12\\src\\test\\resources\\CommonData.properties");
				Properties p = new Properties();
				p.load(fisp);
				String URL = p.getProperty("url");
				String STANDARDUSER = p.getProperty("StandardUser");
				String PASSWORD = p.getProperty("password");
				
				//Reading test data from excel file
				FileInputStream fise = new FileInputStream("C:\\Users\\Adnan\\eclipse-workspace\\AutomationFramework.QCO-SOEAJD-E12\\src\\test\\resources\\TestData.xlsx");
				Workbook wb = WorkbookFactory.create(fise);
				Sheet sh= wb.getSheet("Products");
				Row rw = sh.getRow(1);
				Cell cl = rw.getCell(2);
				String PRODUCTNAME = cl.getStringCellValue();
						
				
				//Step 1: Launching Browser
				ChromeDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				
				//Step 2: Opening URL
				driver.get(URL);
				System.out.println("Page title: "+driver.getTitle());
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
				
				//Step 3: Login
				driver.findElement(By.id("user-name")).sendKeys(STANDARDUSER);
				driver.findElement(By.id("password")).sendKeys(PASSWORD);
				driver.findElement(By.id("login-button")).click();
				
				//Step 4: Click on Product
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).click();
				System.out.println("Page title: "+driver.getTitle());
				String ProductTitle = driver.findElement(By.xpath("//div[@class=\"inventory_details_name large_size\"]")).getText();
				System.out.println(ProductTitle);
				
				//Step 5: Add to cart
				driver.findElement(By.id("add-to-cart")).click();
				
				//Step 6: Opening Cart
				driver.findElement(By.className("shopping_cart_link")).click();
				
				//Step 7: Validating
				String ProductInCart = driver.findElement(By.className("inventory_item_name")).getText();
				System.out.println(ProductInCart);
				
				if (ProductTitle.equalsIgnoreCase(ProductInCart))
				{
					System.out.println("Product in cart is Matching");
					System.out.println("PASS");
				}
				else
				{
					System.out.println("Product in cart is not matching");
					System.out.println("FAIL");
				}
				
				//Step 8: Logout
				driver.findElement(By.id("react-burger-menu-btn")).click();
				driver.findElement(By.id("logout_sidebar_link")).click();
				
				//Step 9: Close browser
				Thread.sleep(1000);
				driver.quit();
	}
}
