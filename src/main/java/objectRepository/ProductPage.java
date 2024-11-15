package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {//Rule 1: Create separate POM class for web page
	
	//Rule 2: Identify the web element using annotations
	@FindBy(id = "add-to-cart") private WebElement addToCartBtn;
	
	@FindBy(id = "shopping_cart_container") private WebElement cartContainerBtn;
	
	//Rule 3: Create a constructor and initialize the web elements
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4: Provide getters to access the web elements
	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	public WebElement getCartContainerBtn() {
		return cartContainerBtn;
	}
	
	//Business library
	
	/**
	 * This method will add product to cart
	 */
	public void addToCart()
	{
		addToCartBtn.click();
	}
	
	/**
	 * This method will open cart
	 */
	public void openCart()
	{
		cartContainerBtn.click();
	}

	
}
