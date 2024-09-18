package day16;

import org.testng.annotations.Test;

public class PaymentTest {

	@Test(priority = 1, groups = { "sanity", "regression" })
	public void payinDollars() {
		System.out.println("Pay in dollars");
	}

	@Test(priority = 2, groups = { "sanity", "regression" })
	public void payinEuro() {
		System.out.println("Pay in Euro");
	}

}
