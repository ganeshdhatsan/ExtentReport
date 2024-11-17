package practice;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReporterClass extends FunctionalUtilities {
	private static ExtentReports extent;
	private static ExtentTest test;
	private static File file;

	public static void generateReport(String testName) {
		String genarateRandomDate = null;
		try {
			genarateRandomDate = genarateRandomDate();
			file = new File(
					System.getProperty("user.dir") + "\\ReportLog\\report_" + genarateRandomDate + ".html");
			ExtentSparkReporter spark = new ExtentSparkReporter(file);
			extent = new ExtentReports();
			extent.attachReporter(spark);
			test = extent.createTest(testName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addScreenshot(String status, String description) {

		String screenshotPath = FunctionalUtilities.screenshot();

		switch (status.toUpperCase()) {

		case "PASS":
			test.pass(description, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//			test.pass(description,MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
			break;
		case "FAIL":
			test.fail(description, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//			test.fail(description,MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
			break;
		case "SKIP":
			test.skip(description, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//			test.skip(description,MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
			break;
		case "INFO":
			test.info(description, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//			test.info(description,MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
			break;

		default:
			break;

		}
	}

	public void flushReport() throws IOException {
		
		extent.flush();
		Desktop.getDesktop().browse(file.toURI());

	}

}
