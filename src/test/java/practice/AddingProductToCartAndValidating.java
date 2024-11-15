package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddingProductToCartAndValidating {
	public static void main(String[] args) throws InterruptedException {
		//Step 1: Launching Browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Step 2: Opening URL
		driver.get("https://www.saucedemo.com");
		System.out.println("Page title: "+driver.getTitle());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		
		//Step 3: Login
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//Step 4: Click on Product
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']")).click();
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
