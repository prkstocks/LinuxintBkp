package com.pages;

import com.controls.ObjectsControl;
import com.utils.UtilityClass;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;


import java.util.Iterator;
import java.util.Set;

public class AccurateCommonPage extends ObjectsControl{
	WebDriver driver;
	WebDriverWait wait;
	Scenario scenario;
	
	public AccurateCommonPage(WebDriver driver, Scenario sc) {
		super(driver, sc);
		this.driver = driver;
		this.scenario = sc;
		
	}


	public void navigateToAccurateHotfixScreen(){
		navigateTo(accurateProperties.getProperty("accurate.client.url"));
	}

	public void navigateToAccurateKiosk() throws InterruptedException {
		openNewTabWithURL(accurateProperties.getProperty("accurate.kiosk.url"));
	}
	public void switchToTabWithUrl(String url) throws InterruptedException {
		super.switchToTabWithUrl(url);
	}

	public void navigateToYopmail(){
		navigateTo("http://www.yopmail.com/en/");
	}

	public void embedScreenshot(String name) {
		scenario.attach(UtilityClass.takeByteScreenshot(driver), "image/png", name);
	}

//	public void switchToNewTab(String expectedURL){
//		//String parentWindow = driver.getWindowHandle();
//		Set<String> allWindows = driver.getWindowHandles();
//		Iterator<String> ite = allWindows.iterator();
//		while(ite.hasNext()){
//			String handle = ite.next();
//			switchWindow(handle);
//			if(driver.getCurrentUrl().contains(expectedURL)){
//				break;
//			}
//		}
//	}





}
