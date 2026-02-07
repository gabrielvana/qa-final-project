package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import testdata.pages.HeaderText;
import testdata.pages.TitleText;


public class AddRemoveTests extends BaseTestsProject {
	
	@Before
	public void before() {
		super.before();
		loginPage.authenticate(standardUser);
		Assert.assertEquals(HeaderText.HEADER, header.getHeaderText());
		Assert.assertEquals(TitleText.TITLE_PRODUCT_LIST_PAGE,title.getTitleText());
		Assert.assertTrue(header.isCartDisplayed());
	}
	
	@Test @Ignore
	public void AddRemoveProduct() throws InterruptedException {
		
		Thread.sleep(1000);
		productsListPage.clickAddToCart(backpack.getTitle());
		Assert.assertTrue(productsListPage.isRemoveDisplayed(backpack.getTitle()));
		
		header.clickShoppingCart();
		Assert.assertTrue(shoppingCartPage.getCartItemText().contains(backpack.getTitle()));
		
		shoppingCartPage.clickRemoveButton(backpack.getTitle());
		Assert.assertTrue(!shoppingCartPage.getCartItemText().contains(backpack.getTitle()));

	}
	

}
