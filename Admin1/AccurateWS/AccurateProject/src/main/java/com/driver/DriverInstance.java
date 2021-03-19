package com.driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class DriverInstance {

	private static DriverInstance instance;
	private WebDriver driver;

	private DriverInstance(String browser) throws MalformedURLException {
		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			Map<String, Object> prefsMap = new HashMap<String, Object>();
			prefsMap.put("profile.default_content_settings.popups", 0);
			prefsMap.put("download.default_directory", System.getProperty("user.dir")+"\\downloads");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefsMap);
			options.addArguments("--test-type");
			options.addArguments("--disable-extensions");
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			driver = new ChromeDriver(options);
		}
		driver.manage().window().maximize();

	}

	public static void setInstance(String browser) throws MalformedURLException {
		instance = new DriverInstance(browser);
	}

	public static DriverInstance getInstance() {
		return instance;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}