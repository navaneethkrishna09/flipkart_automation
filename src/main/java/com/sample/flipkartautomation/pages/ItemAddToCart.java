package com.sample.flipkartautomation.pages;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Class for adding the product to cart 
public class ItemAddToCart {

	WebDriver driver;
	public String productAmount;
	public String productName;

	public ItemAddToCart(WebDriver driver) {
		this.driver = driver;
	}
	
	

	public ItemAddToCart switchWindow() throws Exception {
		ArrayList<String> handles = new ArrayList<String>(driver.getWindowHandles());
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		if (handles.size() > 0) {
			driver.switchTo().window(handles.get(1));
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		return this;
	}

	public ItemAddToCart getProductAmount() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='_1vC4OE _3qQ9m1']")));
		productAmount = driver.findElement(By.xpath("//*[@class='_1vC4OE _3qQ9m1']")).getText();
		return this;
	}

	public ItemAddToCart getProductName() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='_35KyD6']")));
		productName = driver.findElement(By.xpath("//*[@class='_35KyD6']")).getText();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		return this;
	}

	public ItemAddToCart scrollAction() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		return this;
	}

	// For handling the autopopulated pincode.
	public ItemAddToCart pincodeHandler(int pincodeLength) {
		boolean bool = driver.findElement(By.xpath(("//*[@class='_2AkmmA _2Npkh4 _2MWPVK _18WSRq']"))).isEnabled();
		if (!bool) {
			driver.findElement(By.xpath("//*[@class='_3X4tVa']")).click();
			while (pincodeLength > 0) {
				driver.findElement(By.xpath("//*[@class='_3X4tVa']")).sendKeys(Keys.BACK_SPACE);
				pincodeLength--;
			}
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@class='_3X4tVa']")).sendKeys("400004");
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@class='_2aK_gu']")).click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		}
		return this;
	}

	public ItemAddToCart addToCartClick() throws Exception {
		driver.findElement(By.xpath(("//*[@class='_2AkmmA _2Npkh4 _2MWPVK']"))).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Thread.sleep(3000);
		return this;
	}

}
