package Repo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utilities {

	private String driverBrowser = "webdriver.chrome.driver";
	private String driverPath = "C:\\Selenium_drivers\\chromedriver.exe";
	private String urlApp = "https://mercadolibre.com.uy/";
	
	public static WebDriver driver;
	
	public WebDriver initialize() {
		
		System.setProperty(driverBrowser, driverPath);
		driver = new ChromeDriver();
		driver.get(urlApp);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		return driver;
		
	}
	
	
}
