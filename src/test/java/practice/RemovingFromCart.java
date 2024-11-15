package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class RemovingFromCart {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/v1/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()=\"Sauce Labs Fleece Jacket\"]/../../..//button[@class=\"btn_primary btn_inventory\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()=\"Sauce Labs Backpack\"]/../../..//button[text()=\"ADD TO CART\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class=\"shopping_cart_link fa-layers fa-fw\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()=\"Sauce Labs Fleece Jacket\"]/../..//button[text()=\"REMOVE\"]")).click();
		Thread.sleep(5000);
		driver.close();
	}

}
