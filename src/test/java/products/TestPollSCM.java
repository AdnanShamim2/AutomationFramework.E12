package products;

import org.testng.annotations.Test;

public class TestPollSCM {
	@Test(groups = {"Smoke","Regression"})
	
	public void pollSCM()
	{
		System.out.println("Poll SCM successful");
	}

}
