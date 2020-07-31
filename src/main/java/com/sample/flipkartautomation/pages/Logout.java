package com.sample.flipkartautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
// Class for logging the user out.
public class Logout {
	WebDriver driver;

	public Logout(WebDriver driver) {
		this.driver = driver;
	}

	public Logout logoutClick() throws Exception {
		Actions action = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("//*[@class='_2aUbKa']"));
		action.moveToElement(mainMenu).perform();
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(3000);
		return this;
	}

}
