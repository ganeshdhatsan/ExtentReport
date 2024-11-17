package practice;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class FunctionalUtilities {

	public static WebDriver driver; 

	// step 01
	public static String genarateRandomDate() {

		String randomNumber = null;
		try {

			Date date = new Date();

			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy hhmmss");

			randomNumber = sdf.format(date).replace(" ", "_");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return randomNumber;

	}

	public static String screenshot() {
		String absolutePath = null;
		try {
			String genarateRandom = genarateRandomDate();

			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String srcBase64 = ts.getScreenshotAs(OutputType.BASE64);
			File dest = new File(System.getProperty("usr.dir")+"\\ScreenshotLog\\shot_" + genarateRandom + ".png");
			absolutePath = dest.getAbsolutePath();
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return absolutePath;

	}
	
}
