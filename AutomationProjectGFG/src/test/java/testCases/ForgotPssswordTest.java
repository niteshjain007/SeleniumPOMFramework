package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.ERPLoginPage;
import pages.ForgotPasswordPage;

public class ForgotPssswordTest extends TestBase{
	
	
	@Test
	public void verifyResetPassword() throws InterruptedException
	{
		ERPLoginPage loginPageObj = PageFactory.initElements(driver,
				ERPLoginPage.class);
		
		loginPageObj.clickOnForgotPassword();
		
		ForgotPasswordPage forgotpasswordPageObj = PageFactory.initElements(driver,
				ForgotPasswordPage.class);
		
		forgotpasswordPageObj.specifyEmail("test@test.com");
		Thread.sleep(5000);
		
		forgotpasswordPageObj.clickOnResetPassword();
		
		
	}

}
