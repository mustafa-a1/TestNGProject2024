package day16;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter; // UI of the report
	public ExtentReports extent; // Add common information to the report
	public ExtentTest test; // Create test case entries in the report
	// and update the status of the test methods

	public void onStart(ITestContext result) {

		// Specify the location of the report being generated with file name and
		// extension
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");
		sparkReporter.config().setDocumentTitle("Automation Report"); // Setting title of the report
		sparkReporter.config().setReportName("Functional Testing"); // Naming the report
		sparkReporter.config().setTheme(Theme.STANDARD); // Theme of the display

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Mustafa Abdulwahed");
		extent.setSystemInfo("OS", "Windows 11");
		extent.setSystemInfo("Browser name", "Chrome");

	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName()); // Create a new entry in the report
		test.log(Status.PASS, "Passed test is: " + result.getName()); // Log the result
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName()); // Create a new entry in the report
		test.log(Status.FAIL, "Failed test is: " + result.getName()); // Log the result
		test.log(Status.FAIL, result.getThrowable()); // Capture throwables in the log
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName()); // Create a new entry in the report
		test.log(Status.SKIP, "Skipped test is: " + result.getName()); // Log the result
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
