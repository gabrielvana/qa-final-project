package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
	
	WebDriver driver;
	
	public Header(WebDriver driver) {
		this.driver = driver;
	}

	// elements/locators
	
	private By header = By.xpath("//div[@class=\"app_logo\"]");
	private By shoppingCartButton = By.id("shopping_cart_container");
	private By cartBadge = By.id("shopping_cart_badge");
	private By menuButton = By.id("react-burger-menu-btn");
	private By allItemsButton = By.id("inventory_sidebar_link");
	private By logoutButton = By.id("logout_sidebar_link");
	private By closeButton = By.id("react-burger-cross-btn");
	
	// methods
	
	public boolean isCartDisplayed() {
		return driver.findElement(shoppingCartButton).isDisplayed();
	}
	
	public boolean isCartBadgeDisplayed() {
		return driver.findElement(cartBadge).isDisplayed();
	}
	
	public String getHeaderText() {
		return driver.findElement(header).getText();
	}
	
	public void clickShoppingCart() {
		driver.findElement(shoppingCartButton).click();
	}
	
	public void clickMenu() {
		driver.findElement(menuButton).click();
	}
	
	public void clickAllItems() {
		driver.findElement(allItemsButton).click();
	}
	
	public void clickLogout() {
		driver.findElement(logoutButton).click();
	}
	
	public void clickClose() {
		driver.findElement(closeButton).click();
	}
	
}
