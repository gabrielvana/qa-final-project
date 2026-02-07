package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ShoppingCartPage {
	
	WebDriver driver;

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	// locators/elements

	private By cartList = By.xpath("//div[@class=\"cart_list\"]");
	private By continueShoppingButton = By.id("continue-shopping");
	private By checkoutButton = By.id("checkout");

	private By removeButton(String title) { 
		return By.xpath("//button[@id=\"remove-"+title.replace(' ','-').toLowerCase()+"\"]");
	}
	
	private By addedProductTitle(String title) {
	//	return By.xpath("//div[@class=\"inventory_details_name large_size\"][contains(text(),\""+title+"\")]");
		return By.xpath("//div[@class=\"inventory_item_name\"][contains(text(),\""+title+"\")]");
	}
	
	private By addedProductDescription(String title) {
	//	return By.xpath("//div[@class=\"inventory_details_name large_size\"][contains(text(),\""+title+"\")]/following-sibling::div[1]");
		return By.xpath("//div[@class=\"inventory_item_name\"][contains(text(),\""+title+"\")]/following::div[1]");
	}
	
	private By addedProductPrice(String title) {
	// return By.xpath("//div[@class=\"inventory_details_name large_size\"][contains(text(),\""+title+"\")]/following-sibling::div[2]");
		return By.xpath("//div[@class=\"inventory_item_name\"][contains(text(),\""+title+"\")]/following::div[2]/div[@class=\"inventory_item_price\"]");
	}

	private By addedProductQuantity(String title) {
		return By.xpath("//div[contains(text(),\""+title+"\")]/preceding::div[@class=\"cart_quantity\"]");
		// varianta secundara de xpath:
		// return By.xpath("//div[@class=\"cart_item\"][contains(.,\""+title+"\")]/./div[@data-test=\"item-quantity\"][contains(.,*)]");
	}

	//methods
	
	public int toInt(String text) {
		text = text.replaceAll("[^0-9]", "");
		return Integer.parseInt(text);
	}
	
	// get
	
	public String getCartItemText() {
		return driver.findElement(cartList).getText();
	}
	
	public String getAddedProductTitle(String title) {
		return driver.findElement(addedProductTitle(title)).getText();
	}
	
	public String getAddedProductDescription(String title) {
		return driver.findElement(addedProductDescription(title)).getText();
	}
	
	public String getAddedProductPrice(String title) {
		return driver.findElement(addedProductPrice(title)).getText();
	}

	public int getAddedProductQuantity(String title) {
		String quantity = driver.findElement(addedProductQuantity(title)).getText();
		return toInt(quantity);
	}
	

	// click
	
	public void clickContinueShopping() {
		driver.findElement(continueShoppingButton).click();
	}
	
	public void clickCheckout() {
		driver.findElement(checkoutButton).click();
	}
	
	public void clickRemoveButton(String title) {
		driver.findElement(removeButton(title)).click();
	}
	
	
}
