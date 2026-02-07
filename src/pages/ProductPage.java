package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	
	WebDriver driver;
	
	public ProductPage (WebDriver driver) {
		this.driver = driver;
	}
	
	
	// locators
	
	private By productTitle(String title) {
		return By.xpath("//div[@class=\"inventory_details_name large_size\"][contains(text(),\""+title+"\")]");
	}
	
	private By productDescription(String title) {
		return By.xpath("//div[@class=\"inventory_details_name large_size\"][contains(text(),\""+title+"\")]/following-sibling::div[1]");
	}
	
	private By productPrice(String title) {
		return By.xpath("//div[@class=\"inventory_details_name large_size\"][contains(.,\""+title+"\")]/following-sibling::div[2]");
	}
	
	private By addToCartButton(String title) {
		return By.xpath("//div[@class=\"inventory_details_name large_size\"][contains(.,\""+title+"\")]/following-sibling::button[@id=\"add-to-cart\"]");
	}

	
	// methods
	
	
	// click
	
	public void clickAddToCart(String title) {
		driver.findElement(addToCartButton(title)).click();
	}
	
	
	// get
	
	public String getProductTitle(String title) {
		return driver.findElement(productTitle(title)).getText();
	}
	
	public String getProductDescription(String title) {
		return driver.findElement(productDescription(title)).getText();
	}
	
	public String getProductPrice(String title) {
		return driver.findElement(productPrice(title)).getText();
	}
	

}
