package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class LoginPage extends Testbase {

	
	// Page Factory / OR (Object Repository)
	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath="//div[contains(text(), 'Login')]")
	WebElement loginBttn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBttn;
	
	//Initializing the Page Objects:
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	//Actions: 
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void takeMeToLoginPage() {
		driver.findElement(By.xpath("//a[@href='https://ui.freecrm.com']")).click();
	}

	public HomePage login(String eml, String pwd) throws IOException {
		email.sendKeys(eml);
		password.sendKeys(pwd);
		loginBttn.click();
		return new HomePage();
	}
}
