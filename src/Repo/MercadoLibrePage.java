package Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MercadoLibrePage {

	WebDriver driver;
	public MercadoLibrePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By searchInput = By.xpath("//input[@class='nav-search-input']");
	public By searchButton = By.cssSelector(".nav-search-btn");
	public By nameFound = By.xpath("//h2[@class='ui-search-item__title']");
	public By priceFound = By.cssSelector(".price-tag-fraction");
	public By linkFound = By.xpath("//a[@class='ui-search-item__group__element ui-search-link']");
	public By nextPage = By.xpath("//a[@title='Siguiente']");
	
}
