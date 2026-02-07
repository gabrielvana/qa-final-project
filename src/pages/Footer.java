package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Footer {
	
	WebDriver driver;
	
	public Footer(WebDriver driver) {
		this.driver = driver;
	}
	
	// elements
	private By footerText = By.xpath("//div[@class=\"footer_copy\"]");
	
	// methods
	
	public String getFooterText() {
		return driver.findElement(footerText).getText();
	}

}
