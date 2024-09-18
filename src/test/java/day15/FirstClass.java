package day15;

import org.testng.annotations.Test;

/*
 *  Open application
 *  Login 
 *  Logout
 */

public class FirstClass {

	@Test(priority = 1)
	public void openApp() {
		System.out.println("Opening the app...");
	}

	@Test(priority = 2)
	public void login() {
		System.out.println("Logging in...");
	}

	@Test(priority = 3)
	public void logout() {
		System.out.println("Logging out...");
	}

}
