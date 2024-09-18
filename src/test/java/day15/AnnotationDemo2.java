package day15;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationDemo2 {

	@BeforeClass
	public void launchApp() {
		System.out.println("Before class - launch app");
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("After class- close browser");
	}

	@Test(priority = 1)
	public void loginWithEmail() {
		System.out.println("Login with email");
	}

	@Test(priority = 2)
	public void loginWithTwitter() {
		System.out.println("Login with Twitter");
	}

	@Test(priority = 3)
	public void loginWithPhoneNumber() {
		System.out.println("Login with phone number");
	}

	@AfterMethod
	public void sendEmail() {
		System.out.println("Sending email");
	}

	@BeforeTest
	public void connectToDB() {
		System.out.println("Before Test - connecting to DB");
	}

	@AfterTest
	public void disconnectingDB() {
		System.out.println("After Test - disconnecting to DB");
	}

	@BeforeSuite
	public void BS() {
		System.out.println("Before suite");
	}

	@AfterSuite
	public void AS() {
		System.out.println("After suite");
	}

}
