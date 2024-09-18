package day16;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(day16.MyListener.class)
public class OrangeHRMTest {

	WebDriver driver;

	@BeforeClass
	public void setup() throws InterruptedException {

		String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		String browser = "chrome";

		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser");
			return;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Launched url");
		Thread.sleep(1000);
	}

	@Test(priority = 1)
	public void testLogo() {

		Boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertTrue(status);
	}

	@Test(priority = 2)
	public void testTitle() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM_T");
	}

	@Test(priority = 3, dependsOnMethods = { "testTitle" })
	public void testURL() {
		Assert.assertEquals(driver.getCurrentUrl(),
				"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
