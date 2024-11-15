package products;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.AllProductsPage;
import objectRepository.ProductPage;
import objectRepository.YourCartPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class RemoveProductFromCartTest extends BaseClass {
	
	@Test(groups = {"Smoke","Regression"})
	public void tc_002_RemoveSingleProductFromCart()throws IOException, InterruptedException
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
		
		//Step 4: Remove product from cart
		YourCartPage ycp = new YourCartPage(driver);
		ycp.removeProductFromCart();
		Thread.sleep(10000);
	}

}
