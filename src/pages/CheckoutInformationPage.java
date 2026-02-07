package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import utils.RandomGenerator;

public class CheckoutInformationPage {
	
	WebDriver driver;
	
	public CheckoutInformationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//elements/locators
	
	
	private By firstNameInput = By.id("first-name");
	private By lastNameInput = By.id("last-name");
	private By postalCodeInput = By.id("postal-code");
	
	private By cancelButton = By.id("cancel");
	private By continueButton = By.id("continue");
	private By errorMessage = By.xpath("//div[@class=\"error-message-container error\"]");	
	public String randomValue = RandomGenerator.stringValue(30); // valoare random stocata initial intr-o variabila

	
	//methods


	// enter data
	
	public void clearCredentials() {
		driver.findElement(firstNameInput).clear();
		driver.findElement(lastNameInput).clear();
		driver.findElement(postalCodeInput).clear();
	}
	
	public void enterFirstName(String firstname) {
		driver.findElement(firstNameInput).sendKeys(firstname);
	}
	
	public void enterLastName(String lastname) {
		driver.findElement(lastNameInput).sendKeys(lastname);
	}
	
	public void enterPostalCode(String postalcode) {
		driver.findElement(postalCodeInput).sendKeys(postalcode);
	}
	
	public void completeInfo(String firstname, String lastname, String postalcode) {
		enterFirstName(firstname);
		enterLastName(lastname);
		enterPostalCode(postalcode);
	}
	
	// click
	
	
	public void clickCancel() {
		driver.findElement(cancelButton).click();
	}
	
	public void clickContinue() {
		driver.findElement(continueButton).click();
	}
	
	// get
	
	public String getErrorMessage() {
		return driver.findElement(errorMessage).getText();
	}

	
}
