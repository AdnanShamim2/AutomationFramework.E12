package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {//Rule 1: Create separate POM class for web page
	
	//Rule 2: Identify the web element using annotations
	@FindBy(className = "inventory_item_name") private WebElement productName;
	
	@FindBy(id = "remove-sauce-labs-backpack") private WebElement removeBtn;
	
	@FindBy(id = "checkout") private WebElement checkoutBtn;
	
	//Rule 3: Create a constructor and initialize the web elements
	public YourCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4: Provide getters to access the web elements
	public WebElement getProductName() {
		return productName;
	}

	public WebElement getRemoveBtn() {
		return removeBtn;
	}

	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}
	
	//Business library
	
	/**
	 * This method will get the name of the product
	 * @return
	 */
	public String productNameFromCart()
	{
		String ProductInCart = productName.getText();
		return ProductInCart;
	}
	
	public void removeProductFromCart()
	{
		removeBtn.click();
	}
}
