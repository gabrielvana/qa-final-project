package tests;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import testdata.pages.Login;
import testdata.pages.TitleText;
import testdata.pages.HeaderText;

public class LoginTests extends BaseTestsProject{
	
	
	@Test @Ignore
	public void LoginLogoutStandardUser() throws InterruptedException{
		loginPage.authenticate(standardUser);
		
		Assert.assertEquals(HeaderText.HEADER, header.getHeaderText());
		Assert.assertEquals(TitleText.TITLE_PRODUCT_LIST_PAGE,title.getTitleText());
		Assert.assertTrue(header.isCartDisplayed());
		
		header.clickMenu();
		Thread.sleep(1000);
		header.clickLogout();
		
		Assert.assertEquals(HeaderText.HEADER, loginPage.getHeaderText());
		Assert.assertTrue(loginPage.isLoginDisplayed());
	}
	
	@Test @Ignore
	public void LoginInvalidData() throws InterruptedException{
		loginPage.authenticate(wrongUser);
		
		Assert.assertEquals(HeaderText.HEADER,loginPage.getHeaderText());
		Assert.assertTrue(loginPage.isLoginDisplayed());
		Thread.sleep(1000);
		Assert.assertEquals(Login.INVALID_USERNAME_PASSWORD,loginPage.getErrorMessage());
	}
	
	@Test @Ignore
	public void LoginMissingPassword() throws InterruptedException{
		loginPage.authenticate(wrongUser.getUsername(),"");
		
		Assert.assertEquals(HeaderText.HEADER,loginPage.getHeaderText());
		Assert.assertTrue(loginPage.isLoginDisplayed());
		Thread.sleep(1000);
		Assert.assertEquals(Login.MISSING_PASSWORD,loginPage.getErrorMessage());
	}
	
	@Test @Ignore
	public void LoginMissingUsername() throws InterruptedException{

		loginPage.authenticate("", wrongUser.getPassword());
		
		Assert.assertEquals(HeaderText.HEADER,loginPage.getHeaderText());
		Assert.assertTrue(loginPage.isLoginDisplayed());
		Thread.sleep(1000);
		Assert.assertEquals(Login.MISSING_USERNAME,loginPage.getErrorMessage());	
	}
	
	@Test @Ignore
	public void LoginLockedOutUser() throws InterruptedException{
		loginPage.authenticate(lockedOutUser);
		
		Assert.assertEquals(HeaderText.HEADER,loginPage.getHeaderText());
		Assert.assertTrue(loginPage.isLoginDisplayed());
		Thread.sleep(1000);
		Assert.assertEquals(Login.LOCKED_OUT_USER,loginPage.getErrorMessage());
	}

}
