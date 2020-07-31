package com.sample.flipkartautomation.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

//Class used for remote execution of Chrome using Selenium Grid
public class ChromeGrid {
	private static String huburl = "http://192.168.18.13:4444/wd/hub";
	WebDriver driver;

	public WebDriver setup(String url, String chromeDriverDir) throws Exception {
		System.setProperty("webdriver.chrome.driver", chromeDriverDir);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.merge(cap);
		driver = new RemoteWebDriver(new URL(huburl), chromeOptions);
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}

}
