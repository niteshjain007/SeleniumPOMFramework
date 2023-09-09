package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {
	
	WebDriver driver;
	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how= How.ID  , using="forgot_email")
	WebElement emailtxt;
	
	@FindBy(how = How.CSS, using = "button[class *= 'btn-forgot'][type='submit']")
	WebElement resetpasswordBtn;
	
	public void specifyEmail(String email)
	{
		emailtxt.sendKeys(email);
	}
	
	public void clickOnResetPassword()
	{
		resetpasswordBtn.click();
	}

}
