package com.sample.flipkartautomation.pages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Class for selecting the product from the list
public class ItemSelect {
	WebDriver driver;
	List<WebElement> webElementList;
	int randomIndex;

	public ItemSelect(WebDriver driver) {
		this.driver = driver;
	}

	public ItemSelect randomItemFinder() throws Exception {
		Thread.sleep(5000);
		Random rand = new Random();
		webElementList = driver.findElements(By.xpath("//div[@class='bhgxx2 col-12-12']"));
		int rowCount = webElementList.size();
		do {
			randomIndex = rand.nextInt(rowCount + 1);
		} while (randomIndex == 0 || randomIndex == rowCount - 1);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		return this;
	}

	public ItemSelect scrollAction() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", webElementList.get(randomIndex));
		Thread.sleep(3000);
		return this;
	}

	public ItemSelect itemClick() {
		webElementList.get(randomIndex).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return this;
	}

}
