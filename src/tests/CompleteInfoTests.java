package tests;

import org.junit.Ignore;
import org.junit.Test;

import org.junit.Assert;
import org.junit.Before;

import testdata.pages.CheckoutInformation;
import testdata.pages.HeaderText;
import testdata.pages.TitleText;


public class CompleteInfoTests extends BaseTestsProject {
	
	@Before
	public void before() {
		super.before();
		loginPage.authenticate(standardUser);
		Assert.assertEquals(HeaderText.HEADER, header.getHeaderText());
		Assert.assertEquals(TitleText.TITLE_PRODUCT_LIST_PAGE,title.getTitleText());
		Assert.assertTrue(header.isCartDisplayed());
	}
	
	
	@Test @Ignore  // Teoretic aici este BUG - site-ul nu are limite de caractere conform requirements (first/last name (max 30 chars) si postalcode (max 6 chars).
	public void InfoDataAllInvalid() throws InterruptedException	{
		
		Thread.sleep(1000);
		productsListPage.clickAddToCart(backpack.getTitle());
		header.clickShoppingCart();
		
		Thread.sleep(1000);
		shoppingCartPage.clickCheckout();
		
		Thread.sleep(1000);
		Assert.assertEquals(HeaderText.HEADER, header.getHeaderText());
		Assert.assertEquals(TitleText.TITLE_CHECKOUT_INFO, title.getTitleText());
		
		Thread.sleep(3000);
		checkoutInformationPage.clearCredentials();
		checkoutInformationPage.completeInfo(standardBuyer.getFirstname()+checkoutInformationPage.randomValue, standardBuyer.getLastname()+checkoutInformationPage.randomValue, standardBuyer.getPostalcode()+checkoutInformationPage.randomValue);
		checkoutInformationPage.clickContinue();
		
		Assert.assertTrue(checkoutInformationPage.getErrorMessage().contains("Error"));
	}


	@Test @Ignore
	public void InfoDataInvalidFirstName() throws InterruptedException	{
	
		productsListPage.clickAddToCart(backpack.getTitle());
		header.clickShoppingCart();
		shoppingCartPage.clickCheckout();
		
		Assert.assertEquals(HeaderText.HEADER, header.getHeaderText());
		Assert.assertEquals(TitleText.TITLE_CHECKOUT_INFO, title.getTitleText());
		
		checkoutInformationPage.clearCredentials();
		checkoutInformationPage.completeInfo(standardBuyer.getFirstname()+checkoutInformationPage.randomValue, standardBuyer.getLastname(), standardBuyer.getPostalcode());
		Thread.sleep(2000);
		checkoutInformationPage.clickContinue();
		
		Assert.assertTrue(checkoutInformationPage.getErrorMessage().contains("Error"));
	}
	
	
			
	@Test @Ignore
	public void InfoInvalidDataLastName() throws InterruptedException {
		
		productsListPage.clickAddToCart(backpack.getTitle());
		header.clickShoppingCart();
		shoppingCartPage.clickCheckout();
		
		Assert.assertEquals(HeaderText.HEADER, header.getHeaderText());
		Assert.assertEquals(TitleText.TITLE_CHECKOUT_INFO, title.getTitleText());
		
		checkoutInformationPage.clearCredentials();
		checkoutInformationPage.completeInfo(standardBuyer.getFirstname(), standardBuyer.getLastname()+checkoutInformationPage.randomValue, standardBuyer.getPostalcode());
		Thread.sleep(2000);
		checkoutInformationPage.clickContinue();
		
		Assert.assertTrue(checkoutInformationPage.getErrorMessage().contains("Error"));
	}
	
		
	@Test @Ignore
	public void InfoInvalidDataPostalCode()	throws InterruptedException {
		
		productsListPage.clickAddToCart(backpack.getTitle());
		header.clickShoppingCart();
		shoppingCartPage.clickCheckout();
		
		Assert.assertEquals(HeaderText.HEADER, header.getHeaderText());
		Assert.assertEquals(TitleText.TITLE_CHECKOUT_INFO, title.getTitleText());
		
		checkoutInformationPage.clearCredentials();
		checkoutInformationPage.completeInfo(standardBuyer.getFirstname(), standardBuyer.getLastname(), standardBuyer.getPostalcode()+checkoutInformationPage.randomValue);
		Thread.sleep(2000);
		checkoutInformationPage.clickContinue();
		
		Assert.assertTrue(checkoutInformationPage.getErrorMessage().contains("Error"));
		
	}
	
	

	@Test @Ignore
	public void InfoDataAllMissing() throws InterruptedException {
		
		productsListPage.clickAddToCart(backpack.getTitle());
		header.clickShoppingCart();
		shoppingCartPage.clickCheckout();
		
		Assert.assertEquals(HeaderText.HEADER, header.getHeaderText());
		Assert.assertEquals(TitleText.TITLE_CHECKOUT_INFO, title.getTitleText());
		
		checkoutInformationPage.clearCredentials();
		checkoutInformationPage.completeInfo("", "", "");
		checkoutInformationPage.clickContinue();
		Thread.sleep(2000);
		
		Assert.assertTrue(checkoutInformationPage.getErrorMessage().contains("Error"));
		
	}

	@Test @Ignore // Consider ca este BUG - Se validea cu "Spatii" in loc de caractere. Teoretic primeste caractere (spatiu) dar rezultatul final/practic este similar cu lipsa informatii.
	public void InfoDataAllSpaces() throws InterruptedException {
		
		productsListPage.clickAddToCart(backpack.getTitle());
		header.clickShoppingCart();
		shoppingCartPage.clickCheckout();
		
		Assert.assertEquals(HeaderText.HEADER, header.getHeaderText());
		Assert.assertEquals(TitleText.TITLE_CHECKOUT_INFO, title.getTitleText());
		
		checkoutInformationPage.clearCredentials();
		checkoutInformationPage.completeInfo(" ", " ", " ");
		checkoutInformationPage.clickContinue();
		Thread.sleep(2000);
		
		Assert.assertTrue(checkoutInformationPage.getErrorMessage().contains("Error"));
	}
	
	@Test @Ignore
	public void InfoDataMissingFirstname() throws InterruptedException {
		
		productsListPage.clickAddToCart(backpack.getTitle());
		header.clickShoppingCart();
		shoppingCartPage.clickCheckout();
		
		Assert.assertEquals(HeaderText.HEADER, header.getHeaderText());
		Assert.assertEquals(TitleText.TITLE_CHECKOUT_INFO, title.getTitleText());
		
		checkoutInformationPage.clearCredentials();
		checkoutInformationPage.completeInfo("", standardBuyer.getLastname(), standardBuyer.getPostalcode());
		checkoutInformationPage.clickContinue();
		Thread.sleep(2000);
		
		Assert.assertEquals(CheckoutInformation.FIRSTNAME_MISSING, checkoutInformationPage.getErrorMessage());
	}
	
	@Test @Ignore
	public void InfoDataMissingLastname() throws InterruptedException {
		
		productsListPage.clickAddToCart(backpack.getTitle());
		header.clickShoppingCart();
		shoppingCartPage.clickCheckout();
		
		Assert.assertEquals(HeaderText.HEADER, header.getHeaderText());
		Assert.assertEquals(TitleText.TITLE_CHECKOUT_INFO, title.getTitleText());
		
		checkoutInformationPage.clearCredentials();
		checkoutInformationPage.completeInfo(standardBuyer.getFirstname(), "", standardBuyer.getPostalcode());
		checkoutInformationPage.clickContinue();
		Thread.sleep(2000);
		
		Assert.assertEquals(CheckoutInformation.LASTNAME_MISSING, checkoutInformationPage.getErrorMessage());
	}
	
	@Test @Ignore
	public void InfoDataMissingPostalcode() throws InterruptedException {
		
		productsListPage.clickAddToCart(backpack.getTitle());
		header.clickShoppingCart();
		shoppingCartPage.clickCheckout();
		
		Assert.assertEquals(HeaderText.HEADER, header.getHeaderText());
		Assert.assertEquals(TitleText.TITLE_CHECKOUT_INFO, title.getTitleText());
		
		checkoutInformationPage.clearCredentials();
		checkoutInformationPage.completeInfo(standardBuyer.getFirstname(), standardBuyer.getLastname(), "");
		checkoutInformationPage.clickContinue();
		Thread.sleep(2000);
		
		Assert.assertEquals(CheckoutInformation.POSTAL_CODE_MISSING, checkoutInformationPage.getErrorMessage());
		
	}


}
