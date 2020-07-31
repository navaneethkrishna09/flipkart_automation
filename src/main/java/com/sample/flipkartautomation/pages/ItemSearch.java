package com.sample.flipkartautomation.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Class for searching the product
public class ItemSearch {

	WebDriver driver;

	public ItemSearch(WebDriver driver) {
		this.driver = driver;
	}

	public ItemSearch searchBarEntry(String productName) throws Exception {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement element = driver
				.findElement(By.cssSelector("input[placeholder='Search for products, brands and more']"));
		element.sendKeys(productName);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		element.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(3000);
		return this;
	}

}
