package tests;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import testdata.pages.HeaderText;
import testdata.pages.TitleText;


public class ProductFiltering extends BaseTestsProject{
	
	@Before
	public void before() {
		super.before();
		loginPage.authenticate(standardUser);
		Assert.assertEquals(HeaderText.HEADER, header.getHeaderText());
		Assert.assertEquals(TitleText.TITLE_PRODUCT_LIST_PAGE,title.getTitleText());
		Assert.assertTrue(header.isCartDisplayed());
	}
	
	
	@Test @Ignore
	public void sortAz() {

	title.clickAz();
	Assert.assertEquals(productsListPage.sortAz(),productsListPage.getAllTitles());
		
	}
	
	@Test @Ignore
	public void sortZa() {
		
	title.clickZa();
	Assert.assertEquals(productsListPage.sortZa(), productsListPage.getAllTitles());
		
	}
	
	@Test @Ignore
	public void sortLoHi() {
		
	title.clickLoHi();;
	Assert.assertEquals(productsListPage.sortLoHi(), productsListPage.getAllPrices());
		
	}
	
	@Test @Ignore
	public void sortHiLo() {
		
	title.clickHiLo();;
	Assert.assertEquals(productsListPage.sortHiLo(), productsListPage.getAllPrices());
		
	}

}
