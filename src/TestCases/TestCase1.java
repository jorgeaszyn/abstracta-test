package TestCases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Repo.MercadoLibrePage;
import Repo.Utilities;


public class TestCase1 extends Utilities{
	
	public WebDriver driver;
	private String wordToSearch = "camisetas";
	
	@BeforeTest
	public void LaunchApp() {
		driver = initialize();
	}

	@Test
	public void CreateListSearch() {

		MercadoLibrePage ml= new MercadoLibrePage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.findElement(ml.searchInput).sendKeys(wordToSearch);
		driver.findElement(ml.searchButton).click();
		
		FileWriter flwriter = null;
		try {
			
			flwriter = new FileWriter("data.txt");
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			int w = 1;
			while(w <= 3 ) {
				
				List<WebElement> names = driver.findElements(ml.nameFound);
				List<WebElement> prices = driver.findElements(ml.priceFound);
				List<WebElement> links = driver.findElements(ml.linkFound);
				
				for (int i=0; i<names.size(); i++) {
				bfwriter.write(names.get(i).getText() + "\n$ " + prices.get(i).getText() + "\n" + links.get(i).getAttribute("href") + "\n\n");
				}
				
				if(w<3) {
					js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
					driver.findElement(ml.nextPage).click();
				}
				w++;
			}
			
			
			bfwriter.close();
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	@AfterTest
	public void teardown() {
		
		driver.close();
	}
}