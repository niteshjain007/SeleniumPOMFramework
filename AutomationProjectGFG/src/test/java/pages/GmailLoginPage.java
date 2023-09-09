package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GmailLoginPage {

	WebDriver driver;
	public GmailLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	// Using FindBy for locating elements
	@FindBy(how = How.ID, using ="login_email")
	WebElement emailTextBox;
	@FindBy(how = How.ID, using ="login_password")	
	WebElement passwordTextBox;
	@FindBy(how = How.CSS, using ="button[class *= 'btn-login'][type='submit']")
	WebElement loginButton;
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
	public void clickOnNextButton() {
		loginButton.click();
	}
}
