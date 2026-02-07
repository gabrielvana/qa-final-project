package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Title {
	
	WebDriver driver;
	
	public Title(WebDriver driver) {
		this.driver = driver;
	}
	
	
	// elements/locators
	
	private By titleText = By.xpath("//span[@class=\"title\"]");
	//cel de jos apare pe Title
	private By backButton = By.id("back-to-products");
	
	private By sortAz = By.xpath("//select[@class=\"product_sort_container\"]/option[1]");
	private By sortZa = By.xpath("//select[@class=\"product_sort_container\"]/option[2]");
	private By sortLoHi = By.xpath("//select[@class=\"product_sort_container\"]/option[3]");
	private By sortHiLo = By.xpath("//select[@class=\"product_sort_container\"]/option[4]");
    		
	
	// methods
	
	public boolean isBackDisplayed() {
		return driver.findElement(backButton).isDisplayed();
	}
	
	public String getTitleText() {
		return driver.findElement(titleText).getText();
	}
	
	public void clickBack() {
		driver.findElement(backButton).click();
	}
	
	public void clickAz() {
		driver.findElement(sortAz).click();
	}

	public void clickZa() {
		driver.findElement(sortZa).click();
	}
	
	public void clickLoHi() {
		driver.findElement(sortLoHi).click();
	}
	
	public void clickHiLo() {
		driver.findElement(sortHiLo).click();
	}
	

}
