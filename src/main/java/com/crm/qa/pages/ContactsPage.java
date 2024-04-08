package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class ContactsPage extends Testbase {

	
	@FindBy(xpath = "//span[contains(@class,'selectable')]")
	WebElement contactLabel;
	
	@FindBy(xpath = "//input[@name = 'first_name']")
	WebElement firstNameField;

	@FindBy(xpath = "//input[@name = 'last_name']")
	WebElement lastNameField;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement saveContactButton;

	
	public ContactsPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactLabel.isDisplayed();
	}
	
	public void moveCursorAwayFromSideBar() {
		Actions action = new Actions(driver);
		action.moveByOffset(300, 200).build().perform();
	}
	
	public void selectContactsByName(String name) {
		WebElement checkbox = driver.findElement(By.xpath("//a[text() = '"+ name +"']//parent::td//preceding-sibling::td//div"));
		checkbox.click();
//		return checkbox.isSelected();
	}
	
	public void createNewContact(String firstName, String lastName) {
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		saveContactButton.click();
	}
	
}
