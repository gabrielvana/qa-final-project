package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
	
	WebDriver driver;
	
	public CheckoutCompletePage(WebDriver driver) {
		this.driver= driver;
	}

	
	// locators/elements

	private By finishedOrder = By.xpath("//div[@class=\"complete-text\"]");
	private By thanksHeader = By.xpath("//div[@id=\"checkout_complete_container\"]/h2[1]"); 
	
	private By backHomeButton = By.id("back-to-products");
	
	
	// methods
	
	public boolean isBackhomeDisplayed() {
		return driver.findElement(backHomeButton).isDisplayed();
	}
	
	

	public void clickBackHome() {
		driver.findElement(backHomeButton).click();
	}
	
	public String getFinishedOrderText() {
		return driver.findElement(finishedOrder).getText();
	}
	
	public String getThanksHeaderText() {
		return driver.findElement(thanksHeader).getText();
	}
	
}
