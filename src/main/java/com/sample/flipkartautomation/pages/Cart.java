package com.sample.flipkartautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// For obtaining the cart data
public class Cart {
	public String cartAmount;
	public String cartName;
	WebDriver driver;

	public Cart(WebDriver driver) {
		this.driver = driver;
	}

	public Cart getCartProductAmount() {
		cartAmount = driver.findElement(By.xpath("//*[@class='pMSy0p XU9vZa']")).getText();
		return this;
	}

	public Cart getCartProductName() throws Exception {
		cartName = driver.findElement(By.xpath("//*[@class='_325-ji _3ROAwx']")).getText();
		return this;
	}

}
