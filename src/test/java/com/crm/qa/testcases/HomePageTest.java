package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends Testbase{
	
	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtil;
	ContactsPage contactsPage;
  
	public HomePageTest() throws IOException {
		super();
	}
	
	//Test case must be separated -- independent with each other
	//before each test cases - launch the browser and login
	//@etest -- execute test case
	//after each test case -- close the browser
	
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		loginPage.takeMeToLoginPage();
		homePage = loginPage.login(props.getProperty("username"), props.getProperty("password"));
	}

	@Test(priority = 1 )
	  public void verifyHomePageTitleTest() {
		String expectedHomePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(expectedHomePageTitle, "Cogmento CRM", "Home Page title not Matched");
	  }
	
	@Test(priority = 2)
	public void verifyUserLoggedInTest() {
		Assert.assertTrue(homePage.verifyUserName());
	}
	
	@Test(priority = 3)
	public void verfiyContactsLinkTest() throws IOException {
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}