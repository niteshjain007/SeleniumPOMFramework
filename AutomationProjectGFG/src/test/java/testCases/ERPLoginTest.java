package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ERPLoginPage;


public class ERPLoginTest extends TestBase {

	
	@Test
	public void init() throws Exception {

		ERPLoginPage loginpage =	PageFactory.initElements(driver,
				ERPLoginPage.class);
	
		loginpage.setEmail("abc@gmail.com");
		
		loginpage.setPassword("23456@qwe");
		loginpage.clickOnLoginButton();
		
		
	}
	
	@Test
	public void verifyPageTitle()
	{
		ERPLoginPage loginpage =	PageFactory.initElements(driver,
				ERPLoginPage.class);
	
		String actualPageTitle = loginpage.getPageTitle();
		String expectedTitle = "Login";
		
		Assert.assertTrue(actualPageTitle.equals(expectedTitle),"page title not matching");
	}

	
}
