package pages;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductsListPage {
	
	WebDriver driver;

	public ProductsListPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//elements/locators
	
	private By titlesList = By.xpath("//div[@class=\"inventory_item_name \"]");
	private By pricesList = By.xpath("//div[@class=\"inventory_item_price\"]");
	
	
	private By addToCartButton(String title) {
		return By.xpath("//button[@id=\"add-to-cart-"+title.replace(' ','-').toLowerCase()+"\"]");
	}

	private By removeButton(String title) { 
		return By.xpath("//button[@id=\"remove-"+title.replace(' ','-').toLowerCase()+"\"]");
	}
	
	private By anyProduct(String title) {
		return By.xpath("//div[@class=\"inventory_item_name \"][contains(text(),\""+title+"\")]");
	}
	
	private By productsTitle(String title) {
		return By.xpath("//div[@class=\"inventory_item_name \"][contains(text(),\""+title+"\")]");
	}
	
	private By productsDescription(String title) {
		return By.xpath("//div[@class=\"inventory_item_label\"][contains(text(),\""+title+"\")]/div[@class=\"inventory_item_desc\"]"); 
	}
	
	private By productsPrice(String title) {
		return By.xpath("//div[@class=\"inventory_item_label\"][contains(text(),\""+title+"\")]/following-sibling::div[1]"); 
	}
	

	//methods
	
	// is displayed

	public boolean isRemoveDisplayed(String title) {
		return driver.findElement(removeButton(title)).isDisplayed();
	}
	
	
	
	// metoda prin care extragem elementele si le punem intr-o lista de stringuri
	public List<String> getAllTitles(){ //getAllTitles
		List<WebElement> allTitles = driver.findElements(titlesList); //allTitles
		List<String> titles = new ArrayList<String>(); //titles
		for (WebElement title:allTitles) { //title:allTitles
			titles.add(title.getText()); // titles.add(title.getText)
		}
		return titles; //titles
	}
	
	// sort
	public List<String> sortAz(){ //getAllTitles
		List<WebElement> allTitles = driver.findElements(titlesList); //allTitles
		List<String> titles = new ArrayList<String>(); //titles
		for (WebElement title:allTitles) { //title:allTitles
			titles.add(title.getText()); // titles.add(title.getText)
		}
		Collections.sort(titles); 
		return titles;//titles
	}
	
	public List<String> sortZa(){ //getAllTitles
		List<WebElement> allTitles = driver.findElements(titlesList); //allTitles
		List<String> titles = new ArrayList<String>(); //titles
		for (WebElement title:allTitles) { //title:allTitles
			titles.add(title.getText()); // titles.add(title.getText)
		}
		titles.sort(Collections.reverseOrder()); 
		return titles;//titles
	}
	
	// metoda prin care extragem elementele si le punem intr-o lista de doubles
	public List<Double> getAllPrices(){ //getAllT
		List<WebElement> allPrices = driver.findElements(pricesList); //all
		List<Double> prices = new ArrayList<Double>(); //prices
		for (WebElement price:allPrices) { //
			prices.add(Double.parseDouble(price.getText().replace('$', ' ').trim())); 
		}
		return prices;
	}
	
	// sort
	public List<Double> sortLoHi(){ //getAll
		List<WebElement> allPrices = driver.findElements(pricesList); //all
		List<Double> prices = new ArrayList<Double>(); //prices
		for (WebElement price:allPrices) { //
			prices.add(Double.parseDouble(price.getText().replace('$', ' ').trim())); 
		}
		
		Collections.sort(prices);
		return prices;
	}
	
	public List<Double> sortHiLo(){ //getAll
		List<WebElement> allPrices = driver.findElements(pricesList); //all
		List<Double> prices = new ArrayList<Double>(); //prices
		for (WebElement price:allPrices) { //
			prices.add(Double.parseDouble(price.getText().replace('$', ' ').trim())); 
		}
		
		prices.sort(Collections.reverseOrder()); 
		return prices;
	}
	
	//gets
	public String getProductsTitle(String title) {
		return driver.findElement(productsTitle(title)).getText();
	}
	
	public String getProductsDescription(String title) {
		return driver.findElement(productsDescription(title)).getText();
	}
	
	public String getProductPrice(String title) {
		return driver.findElement(productsPrice(title)).getText();
	}
	

	//click
	
	public void clickAddToCart(String title) {
		driver.findElement(addToCartButton(title)).click();
	}

	public void clickRemoveButton(String title) {
		driver.findElement(removeButton(title)).click();
	}
	
	public void clickAnyProduct(String product) {
		driver.findElement(anyProduct(product)).click();
	}
	
}

