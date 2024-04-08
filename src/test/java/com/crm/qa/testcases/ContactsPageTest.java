package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends Testbase {
	
	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	

	public ContactsPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		loginPage.takeMeToLoginPage();
		homePage = loginPage.login(props.getProperty("username"), props.getProperty("password"));
		Thread.sleep(3000);
		contactsPage = homePage.clickOnContactsLink();
		Thread.sleep(1000);
		contactsPage.moveCursorAwayFromSideBar();
		Thread.sleep(3000);
	}
	
	@Test(priority = 1)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contact Page not displayed");
	}
	
	@Test(priority =2 )
	public void selectContactsByNameTest() throws InterruptedException {
		contactsPage.selectContactsByName("sam dhillon");
//		boolean checkboxSelected = contactsPage.selectContactsByName("sam dhillon");
//		Assert.assertTrue(checkboxSelected, "sam dhillon is not selected");
		Thread.sleep(3000);
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object [][] data = TestUtil.getTestData("contacts");
		return data;
	}
	
	@Test(priority = 3, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String firstname, String lastname) {
		homePage.clickOnNewContactLink();
//		contactsPage.createNewContact("balraj", "singh");
		contactsPage.createNewContact(firstname, lastname);
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
