package day15;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * Login - @BeforeMethod
 * Search -@Test
 * Logout - @AfterMethod
 * 
 * Advsearch -@Test
 */

public class AnnotationDemo1 {

	@BeforeMethod
	public void login() {
		System.out.println("Before method - login");
	}

	@AfterMethod
	public void logout() {
		System.out.println("After method - logout");
	}

	@Test(priority = 1)
	public void search() {
		System.out.println("Search");
	}

	@Test(priority = 2)
	public void advSearch() {
		System.out.println("Adv search");
	}

}
