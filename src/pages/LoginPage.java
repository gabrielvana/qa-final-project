package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import testdata.classes.User;



public class LoginPage { 
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//elements/locators
	
	private By header = By.xpath("//div[@class=\"login_logo\"]");
	private By showedCredentials = By.xpath("//div[@id=\"login_credentials\"]/h4");
	private By errorMessage = By.xpath("//h3[@data-test=\"error\"]");
	
	// pentru cele de mai sus trebuie sa fac si CONSTANTE (text)
	
	private By usernameInput = By.id("user-name");
	private By passwordInput = By.id("password");
	private By loginButton = By.id("login-button");
	

	//methods
	
	
	public void clearCredentials() {
		driver.findElement(usernameInput).clear();
		driver.findElement(passwordInput).clear();
	}
	
	public boolean isLoginDisplayed() {
		return driver.findElement(loginButton).isDisplayed();
	}
	
	//gets
	public String getHeaderText() {
		return driver.findElement(header).getText();
	}
	
	public String getCredentialsText() {
		return driver.findElement(showedCredentials).getText();
	}
	
	public String getErrorMessage() {
		return driver.findElement(errorMessage).getText();
	}
	
	//enter data
	public void enterUsername(String username) {
		driver.findElement(usernameInput).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordInput).sendKeys(password);
	}
	
	//click
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
	
	//metode complexe
	
	public void authenticate(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}
	

	public void authenticate(User user) {
		enterUsername(user.getUsername());
		enterPassword(user.getPassword());
		clickLogin();
	}

}
