package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
	
	WebDriver driver;
	
	public CheckoutOverviewPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	// locators/elements

	
	private By finishButton = By.id("finish");
	private By cancelButton = By.id("cancel");
	

	private By paymentInfo = By.xpath("//div[@class=\"summary_info_label\"][contains(.,\"Payment Information:\")]/following::div[1]");
	private By shippingInfo = By.xpath("//div[@class=\"summary_info_label\"][contains(.,\"Shipping Information\")]/following-sibling::div[1]");
	private By itemTotal = By.xpath("//div[@class=\"summary_subtotal_label\"]");
	private By taxValue = By.xpath("//div[@class=\"summary_tax_label\"]");
	private By totalCost = By.xpath("//div[@class=\"summary_total_label\"]"); 

	
	

	private By productTitle(String title) {
		return By.xpath("//div[@class=\"inventory_item_name\"][contains(text(),\""+title+"\")]");
	}
	
	private By productDescription(String title) {
		return By.xpath("//div[@class=\"inventory_item_name\"][contains(text(),\""+title+"\")]/following::div[1]");
	}
	
	private By productPrice(String title) {
		return By.xpath("//div[@class=\"inventory_item_name\"][contains(text(),\""+title+"\")]/following::div[2]");
	}
	
	private By productQuantity(String title) {
		return By.xpath("//div[contains(.,\""+title+"\")]/preceding::div[@class=\"cart_quantity\"]");
	}

	
	// get
	
	public int getProductQuantity(String title) {
		String quantity = driver.findElement(productQuantity(title)).getText();
		return toInt(quantity);
	}
	
	public String getProductTitle(String title) {
		return driver.findElement(productTitle(title)).getText();
	}
	
	public String getProductDescription(String title) {
		return driver.findElement(productDescription(title)).getText();
	}
	
	public String getProductPrice(String title) {
		return driver.findElement(productPrice(title)).getText();
	}
	
	public String getPaymentInfo() {
		return driver.findElement(paymentInfo).getText();	
	}
	
	public String getShippingInfo() {
		return driver.findElement(shippingInfo).getText();
	}
	
	public String getItemTotal() {
		return driver.findElement(itemTotal).getText();
	}
	
	public String getTaxValue() {
		return driver.findElement(taxValue).getText();
	}
	
	public String getTotalCost() {
		return driver.findElement(totalCost).getText();
	}
	
	
	// Text to int
	public int toInt(String text) {
		text = text.replaceAll("[^0-9]", "");
		return Integer.parseInt(text);
	}
	
	public double calculateTaxValue(String productPrice) {
		double taxGross = toInt(productPrice)* 0.08002;
		double tax = Math.round(taxGross);
		return tax;
	}
	
	public double toDouble(String text) {
		text = text.replaceAll("[^0-9]", "");
		return Double.parseDouble(text);
	}


	public double calculateTotalCost(String productPrice) {
		double taxGross = toInt(productPrice)* 0.08002; 
		double tax = Math.round(taxGross);
		double price = toInt(productPrice);
		double total = tax + price;
		return total;
	}
	
	
	// click
	
	public void clickFinish() {
		driver.findElement(finishButton).click();
	}
	
	public void clickCancel() {
		driver.findElement(cancelButton).click();
	}
	
}
