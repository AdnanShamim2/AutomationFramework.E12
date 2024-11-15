package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllProductsPage {//Rule 1: Create separate POM class for web page
	
	//Rule 2: Identify the web element using annotations
	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']") private WebElement ProductName;
	
	@FindBy(id = "react-burger-menu-btn") private WebElement menuBtn;
	
	@FindBy(id = "logout_sidebar_link") private WebElement logoutBtn;
	
	//Rule 3: Create a constructor and initialize the web elements
	public AllProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4: Provide getters to access the web elements
	public WebElement getProductName() {
		return ProductName;
	}

	public WebElement getMenuBtn() {
		return menuBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	//Business library
	
	/**
	 * This method will open product page
	 */
	public void clickOnProduct()
	{
		ProductName.click();
	}
	
	/**
	 * This method will return name of the product
	 * @return
	 */
	public String productTitle()
	{
		String ProductTitle = ProductName.getText();
		return ProductTitle;
	}
	
	/**
	 * This method will click on menu button
	 */
	public void clickOnMenuButton()
	{
		menuBtn.click();
	}
	
	/**
	 * This method will logout of application
	 */
	public void logoutOfApp()
	{
		menuBtn.click();
		logoutBtn.click();
	}
}
