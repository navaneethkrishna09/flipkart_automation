package com.sample.flipkartautomation.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

//Class for dismissing the initial login pop up.
public class PopUpDismiss {
	WebDriver driver;

	public PopUpDismiss(WebDriver driver) {
		this.driver = driver;
	}

	public void initialPopUpClose() {
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
