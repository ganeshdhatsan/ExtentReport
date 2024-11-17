package DontUseDummy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Reporting extends Utilities{

	static int a;

	
	private static void abc() {

	}
	static WebDriver driver = new ChromeDriver();

	public static void report() {
		System.out.println("report");
		report1();
	}
	
	public static void report1() {
		driver.get("");
	
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		Reporting r = new Reporting();
		Utilities.utility();
		 r.report();
		driver.get("");
		System.out.println(Reporting.a);
		Reporting.abc();
	}

}
