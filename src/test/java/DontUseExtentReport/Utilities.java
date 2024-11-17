package DontUseExtentReport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {
    public static WebDriver driver;

    public static String takeScreenShot() throws IOException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy hhmmss");
        String ReportTime = sdf.format(date).replace(" ", "_");

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
//        String base64 = ts.getScreenshotAs(OutputType.BASE64);
        File des = new File(System.getProperty("user.dir")+"\\ScreenshotLog\\" + ReportTime + ".png");
        String absolutePath = des.getAbsolutePath();
        FileUtils.copyFile(src, des);
        return absolutePath;
    }
}