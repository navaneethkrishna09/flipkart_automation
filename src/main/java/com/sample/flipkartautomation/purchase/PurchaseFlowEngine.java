package com.sample.flipkartautomation.purchase;

import org.openqa.selenium.WebDriver;

import com.sample.flipkartautomation.pages.Cart;
import com.sample.flipkartautomation.pages.ItemAddToCart;
import com.sample.flipkartautomation.pages.ItemSearch;
import com.sample.flipkartautomation.pages.ItemSelect;
import com.sample.flipkartautomation.pages.Login;
import com.sample.flipkartautomation.pages.Logout;
import com.sample.flipkartautomation.pages.PopUpDismiss;

// Class used for driving the purchase testcases.
public class PurchaseFlowEngine {

	public void test(WebDriver driver, String userNumber, String password, String productName, int pincodeLength)
			throws Exception {

		PopUpDismiss popupdismiss = new PopUpDismiss(driver);
		Login loginobj = new Login(driver);
		ItemSelect itemselect = new ItemSelect(driver);
		ItemSearch itemsearch = new ItemSearch(driver);
		ItemAddToCart itemaddtocart = new ItemAddToCart(driver);
		Cart cart = new Cart(driver);
		Logout logout = new Logout(driver);

		// Linking the classes for driving the execution
		popupdismiss.initialPopUpClose();
		loginobj.homepageLoginClick().enterNumber(userNumber).enterPassword(password).loginButtonClick();
		itemsearch.searchBarEntry(productName);
		itemselect.randomItemFinder().scrollAction().itemClick();
		itemaddtocart.switchWindow().getProductAmount().getProductName().scrollAction().pincodeHandler(pincodeLength)
				.addToCartClick();
		cart.getCartProductAmount().getCartProductName();
		logout.logoutClick();

	}

}
