package com.sample.flipkartautomation.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//CLass for doing the driver setup.
public class DriverSetup {
	WebDriver driver;

	public WebDriver setup(String browser, String url, String chromeDriverDir, String mozillaDriverDir,String edgeDriverDir) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromeDriverDir);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
		} else if (browser.equalsIgnoreCase("mozilla")) {
			System.setProperty("webdriver.gecko.driver", mozillaDriverDir);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(url);

		}
		else
		{
			System.setProperty("webdriver.edge.driver",edgeDriverDir);
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			
		}
		return driver;
	}

}
