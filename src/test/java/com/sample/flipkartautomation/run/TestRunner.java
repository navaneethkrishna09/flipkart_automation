package com.sample.flipkartautomation.run;

import java.awt.Desktop.Action;
import java.awt.Window;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;
import com.sample.flipkartautomation.constants.FilePaths;
import com.sample.flipkartautomation.constants.ProductDetails;
import com.sample.flipkartautomation.constants.UserCredentials;
import com.sample.flipkartautomation.grid.ChromeGrid;
import com.sample.flipkartautomation.pages.Cart;
import com.sample.flipkartautomation.pages.ItemAddToCart;
import com.sample.flipkartautomation.pages.Login;
import com.sample.flipkartautomation.pages.PopUpDismiss;
import com.sample.flipkartautomation.purchase.PurchaseFlowEngine;
import com.sample.flipkartautomation.setup.DriverSetup;

// Runner class for the execution
public class TestRunner implements FilePaths, UserCredentials, ProductDetails {
	DriverSetup dr = new DriverSetup();
	WebDriver driver;
	ChromeGrid grid = new ChromeGrid();
	private String browser = "chrome";
	private String url = "https://www.flipkart.com/";

	@Test(testName = "Normal Launch", priority = 1)
	public void launch() throws Exception {
		PurchaseFlowEngine engine = new PurchaseFlowEngine();
		driver = dr.setup(browser, url, chromeDriverDir, mozillaDriverDir);
		engine.test(driver, mobileNumber, password, productSearchName, pincodeLength);
		System.out.println(driver);

	}

	// Command to execute for hub :- java -jar
	// selenium-server-standalone-3.141.59.jar -role hub (From the jar file
	// directory)
	// Command to execute for node :- java
	// -Dwebdriver.chrome.driver="C:/Users/CY0092/Downloads/lib/chromedriver.exe"
	// -jar selenium-server-standalone-3.141.59.jar -role node -hub
	// http://192.168.18.13:4444/grid/register
	@Test(testName = "Grid Launch")
	public void gridLaunch() throws Exception {
		PurchaseFlowEngine engine = new PurchaseFlowEngine();
		driver = grid.setup(url, chromeDriverDir);
		engine.test(driver, mobileNumber, password, productSearchName, pincodeLength);
	}

	@Test(priority = 2)
	public void verifyProductDetails() {
		Cart cart = new Cart(driver);
		ItemAddToCart itemaddtocart = new ItemAddToCart(driver);
		Assert.assertEquals(itemaddtocart.productAmount, cart.cartAmount, "Amount does not match");
		Assert.assertEquals(itemaddtocart.productName, cart.cartName, "Description does not match");
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}

}
