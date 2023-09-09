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

public class LoginPageTest2 {

	WebDriver dr = null;

	@BeforeClass
	public void beforeTestClassSetup() {
		dr = new ChromeDriver();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test(priority = 1)
	public void verifyLoginPageTitle() throws InterruptedException {
		// test1 start
		Thread.sleep(4000);

		dr.get("https://test.techlift.in/");
		dr.findElement(By.linkText("Login")).click();

		String actualTitle = dr.getTitle();
		String expectedTitle = "Login";

		System.out.println("actual title=" + actualTitle);
		boolean check = actualTitle.equals(expectedTitle);

		Assert.assertTrue(check, "title not matching");

	}

	@Test(priority = 2)
	public void verifyContactLinkDisplay() {

		dr.get("https://test.techlift.in/");
		dr.findElement(By.linkText("Login")).click();

		WebElement contactElm = dr.findElement(
				By.xpath("//div[@id='navbarSupportedContent']//li[@class='nav-item']//a[contains(text(),'Contact')]"));

		boolean check = contactElm.isDisplayed();
		Assert.assertTrue(check, "contact link not available");
		// test2 end

	}

	@Test()
	public void verifyForgotPasswordEnabled() {

		dr.get("https://test.techlift.in/");
		dr.findElement(By.linkText("Login")).click();

		Wait<WebDriver> wait = new WebDriverWait(dr, Duration.ofSeconds(10));

		WebElement forgotpasswordLink = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Forgot Password?")));
		// wait.until(d -> revealed.isDisplayed());

		Assert.assertTrue(forgotpasswordLink.isEnabled(), "forgotpasswordLink is not enables");

		// test3 end
	}

}
