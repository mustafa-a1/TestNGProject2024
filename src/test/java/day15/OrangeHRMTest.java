package day15;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*
 * Open app
 * Test logo presence
 * Login
 * Logout
 */

public class OrangeHRMTest {
	WebDriver driver;

	@Test(priority = 1)
	public void openApp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test(priority = 2)
	public void testLogo() throws InterruptedException {
		Thread.sleep(1000);
		Boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		System.out.println("Logo is displayed: " + status);
	}

	@Test(priority = 3)
	public void testLogin() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Login successful");
	}

	@Test(priority = 4)
	public void logOut() {
		driver.findElement(By.xpath("//i[contains(@class,'oxd-icon bi-caret')]")).click();
		driver.findElement(By.xpath("//a[@href='/web/index.php/auth/logout']")).click();
		System.out.println("Logged Out");
		driver.close();

	}

}
