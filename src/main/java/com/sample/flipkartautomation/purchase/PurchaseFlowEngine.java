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

	public String[] test(WebDriver driver, String userNumber, String password, String productSearchName, int pincodeLength,String pincode)
			throws Exception {
		String productAmount;
		String cartAmount;
		String productName;
		String cartName;

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
		itemsearch.searchBarEntry(productSearchName);
		itemselect.randomItemFinder().scrollAction().itemClick();
		itemaddtocart.switchWindow().getProductAmount().getProductName().scrollAction().pincodeHandler(pincodeLength,pincode)
				.addToCartClick();
		cart.getCartProductAmount().getCartProductName();
		// Getting the Amount and Name of the product
		cartAmount = cart.cartAmount;
		cartName = cart.cartName;
		productAmount = itemaddtocart.productAmount;
		productName = itemaddtocart.productName;
		String[] productValues = { productAmount, cartAmount, productName, cartName };
		logout.logoutClick();
		return productValues;

	}

}
