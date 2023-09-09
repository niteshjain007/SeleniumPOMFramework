package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ERPLoginPage {

	
	WebDriver driver;
	public ERPLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	// Using FindBy for locating elements
	@FindBy(how = How.ID, using ="login_email")
	WebElement emailTextBox;
	
	@FindBy(how = How.ID, using ="login_password")	
	WebElement passwordTextBox;
	
	@FindBy(how = How.CSS, using ="button[class *= 'btn-login'][type='submit']")
	WebElement loginButton;
	
	@FindBy(how = How.LINK_TEXT , using ="Forgot Password?")
	WebElement forgotpasswordLink;
	// Defining all the user actions (Methods)
	//that can be performed in the Facebook home page

	// This method is to set Email in the email text box
	public void setEmail(String strEmail) {
			emailTextBox.sendKeys(strEmail);
		}
		// This method is to set Password in the password text box
	public void setPassword(String strPassword) {
			passwordTextBox.sendKeys(strPassword);
		}
		// This method is to click on Next Button
	public void clickOnLoginButton() {
		loginButton.click();
	}
	public String getPageTitle() {
		
	return driver.getTitle(); 
			
	
	}
	
	public void clickOnForgotPassword()
	{
		forgotpasswordLink.click();
	}

}
