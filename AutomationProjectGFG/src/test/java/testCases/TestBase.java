package testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	public static WebDriver driver = null;

	@BeforeSuite
	public void initialize() throws IOException {
	
		driver = new EdgeDriver();
	
		// To maximize browser
		driver.manage().window().maximize();
	
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// To open Gmail site
		driver.get("https://test.techlift.in/login#login");
	}

	@AfterSuite
	// Test cleanup
	public void TeardownTest() {
		TestBase.driver.quit();
	}
}
