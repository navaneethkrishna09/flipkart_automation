package com.sample.flipkartautomation.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Class for user login
public class Login {

	WebDriver driver;

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	public Login homepageLoginClick() throws InterruptedException {
		driver.findElement(By.className("_3Ep39l")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return this;

	}

	public Login enterNumber(String mobileNumber) {
		driver.findElement(By.xpath("//input[@type='text' and @class='_2zrpKA _1dBPDZ']")).sendKeys(mobileNumber);
		return this;
	}

	public Login enterPassword(String password) throws Exception {
		driver.findElement(By.xpath("//input[@type='password' and @class='_2zrpKA _3v41xv _1dBPDZ']"))
				.sendKeys(password);
		driver.findElement(By.cssSelector("._26prer")).click();
		Thread.sleep(3000);
		return this;
	}

	public Login loginButtonClick() throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='_2AkmmA _1LctnI _7UHT_c']")).click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		Thread.sleep(3000);
		return this;
	}
}
