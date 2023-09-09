package loginPackage;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest {

	WebDriver dr= null;
	@BeforeClass
	public void beforeTestClassSetup()
	{
		dr = new ChromeDriver();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@BeforeMethod
	public void openWebsiteAnvigateToLogin() throws InterruptedException {
		
		Thread.sleep(4000);
		
        
		dr.get("https://test.techlift.in/");
		dr.findElement(By.linkText("Login")).click();
	
	}
	
	/*
	 * @AfterClass public void closeBrowser() { dr.close(); dr.quit();
	 * 
	 * }
	 */
	
	@Test(priority = 3,enabled=false)
	public void verifyLoginPageTitle()
	{
	// test1 start
		
		String actualTitle= dr.getTitle();
		String expectedTitle = "Login";
		
		System.out.println("actual title=" + actualTitle);
		boolean check = actualTitle.equals(expectedTitle);
		
		
		Assert.assertTrue(check,"title not matching");
		
	}
	
	@Test(priority = 1,enabled=false)
	public void verifyContactLinkDisplay()
	{
	// test2 start
	
		WebElement contactElm= dr.findElement(By.xpath("//div[@id='navbarSupportedContent']//li[@class='nav-item']//a[contains(text(),'Contact')]"));

		boolean check = contactElm.isDisplayed();
		Assert.assertTrue(check, "contact link not available");
		// test2 end

	}
	
	@Test(priority = 2,enabled=false)
	public void verifyForgotPasswordEnabled()
	{
	// test3 start
	
	//	WebElement forgotpasswordLink = dr.findElement();
		Wait<WebDriver> wait = new WebDriverWait(dr, Duration.ofSeconds(10));
       
		WebElement forgotpasswordLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Forgot Password?")));
      //  wait.until(d -> revealed.isDisplayed());
		
		
		Assert.assertTrue(forgotpasswordLink.isEnabled(), "forgotpasswordLink is not enables");
		
		// test3 end
	}
	
	
	@Test(priority=5, dataProvider = "dataforLogin")
	public void invalidLogin(String email,String password) throws InterruptedException
	{
		dr.findElement(By.id("login_email")).sendKeys(email); Thread.sleep(4000);
		dr.findElement(By.id("login_password")).sendKeys(password);Thread.sleep(4000);
		dr.findElement(By.cssSelector("button[class *= 'btn-login'][type='submit']")).click();
		Thread.sleep(4000);
	}
	
	
	@DataProvider(name = "dataforLogin")
	public Object[][] createData1() {
	 return new Object[][] {
	   { "test@test.com","abcd" },
	   { "Anne@check.com", "xyz"},
	 };
	}
	 

	
	
	
	
	
	
	
	
	
	
	
}
