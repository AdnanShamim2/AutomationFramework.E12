package products;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.AllProductsPage;
import objectRepository.ProductPage;
import objectRepository.YourCartPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class AddProductToCartTest extends BaseClass {
	
	@Test(groups = {"Smoke","Regression"})
	public void tc_001_AddSingleProductToCartTest() throws IOException
	{
		
		//Read the test data from excel file
		eUtil.readDataFromExcel("Products", 1, 2);
		
		//Step 1: Click on product name
		AllProductsPage app = new AllProductsPage(driver);
		app.clickOnProduct();
		String ProductTitle = app.productTitle();
		System.out.println("Product clicked on: "+ProductTitle);
		
		//Step 2: Add product to cart
		ProductPage pp = new ProductPage(driver);
		pp.addToCart();
		
		//step 3: Open cart
		pp.openCart();
		
		//step 4: Validating
		YourCartPage ycp = new YourCartPage(driver);
		String ProductInCart = ycp.productNameFromCart();
		System.out.println("Product in cart: "+ProductInCart); 
		Assert.assertEquals(ProductInCart, ProductTitle);
		System.out.println("Test case: Passed");
	}
}
