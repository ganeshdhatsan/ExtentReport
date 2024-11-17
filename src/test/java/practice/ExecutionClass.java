package practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExecutionClass extends FunctionalUtilities{
	ReporterClass	reporter;
	WebDriver  driver;
	
	public ExecutionClass() {
		reporter = new ReporterClass();
		
	}
	
	@BeforeClass
	private void beforeClass() {
		driver = new ChromeDriver();
		FunctionalUtilities.driver=driver;
		driver.switchTo().newWindow(WindowType.TAB);

	}
	
	@Test
	private void logintest() throws InterruptedException, IOException {
		reporter.generateReport(" Login Validation Using Valid Credentials");
		driver.get("https://www.facebook.com/login/");
		reporter.addScreenshot("pass", "URL Launched Succesfully");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("maha");
		reporter.addScreenshot("pass", "UserName Entered Succesfully");
		Thread.sleep(1000);
		driver.findElement(By.id("pass")).sendKeys("sri");
		reporter.addScreenshot("pass", "Password Entered  Succesfully");
		Thread.sleep(1000);
		driver.findElement(By.id("loginbutton")).click();
		reporter.addScreenshot("pass", "Login Button Clicked Succesfully");
		Thread.sleep(5000);
		reporter.flushReport();
		

	}

	

}
