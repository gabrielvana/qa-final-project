package tests;

import java.time.Duration;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.CheckoutOverviewPage;
import pages.LoginPage;
import pages.CheckoutCompletePage;
import pages.CheckoutInformationPage;
import pages.ProductPage;
import pages.ProductsListPage;
import pages.ShoppingCartPage;
import pages.Header;
import pages.Title;
import pages.Footer;
import testdata.URL;
import testdata.classes.Buyer;
import testdata.classes.Product;
import testdata.classes.User;
import testdata.pages.HeaderText;


public class BaseTestsProject {

static WebDriver driver;

	static CheckoutOverviewPage checkoutOverviewPage;
	static LoginPage loginPage;
	static CheckoutCompletePage checkoutCompletePage;
	static CheckoutInformationPage checkoutInformationPage;
	static ProductsListPage productsListPage;
	static ShoppingCartPage shoppingCartPage;
	static ProductPage productPage;
	static Header header;
	static Title title;
	static Footer footer;
	
	public Product backpack = new Product("backpack");
	public User wrongUser = new User("wronguser");
	public User standardUser = new User("standarduser");
	public User lockedOutUser = new User("lockedoutuser");
	public Buyer standardBuyer = new Buyer("standardbuyer");
	
	
	//aici trebuie sa definesc obiectele (pagini, useri, produs)
	
	@BeforeClass
	public static void beforeAll() {
		ChromeOptions chromeOption = new ChromeOptions();
		
		chromeOption.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
		chromeOption.addArguments("disable-infobars"); // Disable infobars
		chromeOption.addArguments("disable-popup-blocking"); // Disable popup blocking
		chromeOption.addArguments("disable-default-apps"); // Disable default apps
		chromeOption.addArguments("no-first-run"); // Skip first run wizards
		chromeOption.addArguments("no-default-browser-check"); // Skip default browser check
		chromeOption.addArguments("--disable-search-engine-choice-screen");
		
		chromeOption.addArguments("start-maximized"); // Open browser in maximized mode
		chromeOption.addArguments("disable-notifications"); // Disable notifications
		chromeOption.addArguments("disable-extensions"); // Disable extensions
		chromeOption.addArguments("guest"); // Disable change password popup
	
		//setam proprietati de aici in jos
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Gabriel/eclipse-workspace/proiectFinalVanaLaurentiuGabriel/src/source/chromedriver.exe");
		driver = new ChromeDriver(chromeOption);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //wait implicit - asteapta un timp pana cand se intampla ceva/apare un buton
		
		checkoutOverviewPage = new CheckoutOverviewPage(driver);
		loginPage = new LoginPage(driver);
		checkoutCompletePage = new CheckoutCompletePage(driver);
		checkoutInformationPage = new CheckoutInformationPage(driver);
		productsListPage = new ProductsListPage(driver);
		shoppingCartPage = new ShoppingCartPage(driver);
		productPage = new ProductPage(driver);
		header = new Header(driver);
		title = new Title(driver);
		footer = new Footer(driver);
		
	}
	
	@Before
	public void before() {
	driver.get(URL.MAIN);
	Assert.assertEquals(HeaderText.HEADER, loginPage.getHeaderText());
	}
	
	@AfterClass
	public static void afterAll() {
		driver.close(); //inchide sesiunea curenta 
		driver.quit(); //inchide toate sesiunile
	}
	
	
}
