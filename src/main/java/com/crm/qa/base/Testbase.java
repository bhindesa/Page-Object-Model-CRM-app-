package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class Testbase {
	
	public static WebDriver driver;
	public static Properties props;
	public static WebEventListener eventListener;
	
	
	public Testbase() throws IOException{
		
		try {
			
			FileInputStream PropFile = new FileInputStream("/Users/sarbbhinder/Desktop/QA/Selenium_WorkSpace/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
			props = new Properties();
			props.load(PropFile);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
	public static void initialization() throws IOException {
		String browser = props.getProperty("browser");
		
		if(browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		} 
		else if(browser.equals("Chrome")) {
			driver = new FirefoxDriver();
		}
		
		// registering the webeventlistner class object with the eventfiringdecorator
		eventListener = new WebEventListener();
		EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(eventListener);
		
		//Decorated webdriver
		driver = decorator.decorate(driver);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		driver.navigate().to(props.getProperty("url"));

	}
	
}
