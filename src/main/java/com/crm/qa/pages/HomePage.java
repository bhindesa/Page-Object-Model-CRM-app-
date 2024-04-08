package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class HomePage extends Testbase {

	
	
	
	@FindBy(xpath = "//span[@class='user-display']")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//span[contains(text(), 'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath = "//span[text() = 'Contacts']//parent::a//following-sibling::button")
	WebElement newContactLink;
	
	//Initializing a Page Object
	public HomePage() throws IOException {
		
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() throws IOException {
		contactsLink.click();
		return new  ContactsPage();
		
	}
	
	public DealsPage clickOnDealsLink() throws IOException {
		dealsLink.click();
		return new  DealsPage();
		
	}
	
	public TasksPage clickOnTasksLink() throws IOException {
		tasksLink.click();
		return new  TasksPage();
		
	}

	public void clickOnNewContactLink() {
		Actions action =  new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
	
}
