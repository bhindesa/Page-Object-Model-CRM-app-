package com.crm.qa.util;

/*************************************** PURPOSE **********************************

 - This class implements the WebDriverEventListener, which is included under events.
 The purpose of implementing this interface is to override all the methods and define certain useful  Log statements 
 which would be displayed/logged as the application under test is being run.

 Do not call any of these methods, instead these methods will be invoked automatically
 as an when the action done (click, findBy etc). 

 */

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import com.crm.qa.base.Testbase;

public class WebEventListener extends Testbase implements WebDriverListener {

	public WebEventListener() throws IOException {
		super();
	}

	public void beforeFindElement(WebDriver driver, By locator) {
		System.out.println("Started Looking for " + locator);
	}
	
	public void afterFindElement(WebDriver driver, By locator, WebElement result) {
		System.out.println("Found element "+ locator + " looking for " + result);
	}

	public void beforeClose(WebDriver driver) {
		System.out.println("Closing browser");
	}
	
	public void afterClose(WebDriver driver) {
		System.out.println("Browser closed");
	}
	
	public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
		
		System.out.println("Target " + target + "method" + method + "args" + args +  "exception is " + e);
		
		try {
			TestUtil.takeScreenshotAtEndOfTest();
			
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}

	
	
}