package day16;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ActionItem11 {

	
		WebDriver driver;
		
	
	@DataProvider(name = "dp1")
	public Object[][] automationData() {
		return new Object[][]  { 
			{ "standard_user", "secret_sauce" },
			{ "locked_out_user", "secret_sauce" },
			{ "problem_user", "secret_sauce" },
			{ "performance_glitch_user", "secret_sauce" },

		};
		
	}

	@Test(dataProvider = "dp1")
	public void testDP(String username, String password) {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/v1/");
		driver.findElement(By.id("user-name")).sendKeys(username);
		Assert.assertTrue(true);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		driver.close();
		
	}
	
	@Test
	public void testlogo() {
		boolean status = driver.findElement(By.cssSelector(".peek")).isDisplayed();
		Assert.assertTrue(status);
	}
	
	
	
	
}
