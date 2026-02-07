package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import testdata.pages.CheckoutComplete;
import testdata.pages.HeaderText;
import testdata.pages.TitleText;

public class CreateBooking extends BaseTestsProject {
	
	@Before
	public void before() {
		super.before();
		loginPage.authenticate(standardUser);
		Assert.assertEquals(HeaderText.HEADER, header.getHeaderText());
		Assert.assertEquals(TitleText.TITLE_PRODUCT_LIST_PAGE,title.getTitleText());
		Assert.assertTrue(header.isCartDisplayed());
	}
	
	@Test @Ignore
	public void CreateBookingTest() throws InterruptedException{
		
		productsListPage.clickAnyProduct(backpack.getTitle());
		
		Assert.assertTrue(title.isBackDisplayed());
		Assert.assertEquals(backpack.getTitle(), productPage.getProductTitle(backpack.getTitle()));
		Assert.assertEquals(backpack.getDescription(), productPage.getProductDescription(backpack.getTitle()));
		Assert.assertEquals(backpack.getPrice(), productPage.getProductPrice(backpack.getTitle()));
	
		productPage.clickAddToCart(backpack.getTitle());
		header.clickShoppingCart();
		
		Thread.sleep(1000);

		Assert.assertEquals(backpack.getTitle(), shoppingCartPage.getAddedProductTitle(backpack.getTitle()));
		Assert.assertEquals(backpack.getDescription(), shoppingCartPage.getAddedProductDescription(backpack.getTitle()));
		Assert.assertEquals(backpack.getPrice(), shoppingCartPage.getAddedProductPrice(backpack.getTitle()));
		Assert.assertEquals(shoppingCartPage.toInt(backpack.getQuantity()), shoppingCartPage.getAddedProductQuantity(backpack.getTitle()));
		
		shoppingCartPage.clickCheckout();
		checkoutInformationPage.completeInfo(standardBuyer.getFirstname(), standardBuyer.getLastname(), standardBuyer.getPostalcode());
		checkoutInformationPage.clickContinue();

		
		Assert.assertEquals(HeaderText.HEADER, header.getHeaderText());
		Assert.assertEquals(TitleText.TITLE_CHECKOUT_OVERVIEW, title.getTitleText());
		
		Assert.assertEquals(backpack.getTitle(), checkoutOverviewPage.getProductTitle(backpack.getTitle()));
		Assert.assertEquals(backpack.getDescription(), checkoutOverviewPage.getProductDescription(backpack.getTitle()));
		Assert.assertEquals(backpack.getPrice(), checkoutOverviewPage.getProductPrice(backpack.getTitle()));
		Assert.assertEquals(checkoutOverviewPage.toInt(backpack.getQuantity()), checkoutOverviewPage.getProductQuantity(backpack.getTitle()));
		Assert.assertEquals(standardBuyer.getPayment(), checkoutOverviewPage.getPaymentInfo());
		Assert.assertEquals(standardBuyer.getShipping(), checkoutOverviewPage.getShippingInfo());
		Assert.assertEquals(checkoutOverviewPage.toInt(backpack.getPrice()), checkoutOverviewPage.toInt(checkoutOverviewPage.getItemTotal()));
		Assert.assertEquals(checkoutOverviewPage.calculateTaxValue(backpack.getPrice()), checkoutOverviewPage.toDouble(checkoutOverviewPage.getTaxValue()), 0.3f);
		Assert.assertEquals(checkoutOverviewPage.calculateTotalCost(backpack.getPrice()), checkoutOverviewPage.toInt(checkoutOverviewPage.getTotalCost()), 0.3f);
		
		checkoutOverviewPage.clickFinish();
		
		Assert.assertEquals(HeaderText.HEADER, header.getHeaderText());
		Assert.assertEquals(TitleText.TITLE_CHECKOUT_COMPLETE, title.getTitleText());
		Assert.assertEquals(CheckoutComplete.THANKS_MESSAGE, checkoutCompletePage.getThanksHeaderText());
		Assert.assertEquals(CheckoutComplete.ORDER_READY, checkoutCompletePage.getFinishedOrderText());
		Assert.assertTrue(checkoutCompletePage.isBackhomeDisplayed());

	}
	
}
