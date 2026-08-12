package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductPage;

public class ProductTest extends BaseTest {
	
	
	@Test(groups = {"smoke", "regression"})
	public void verifySearchProduct() {

	    HomePage homePage = new HomePage(driver);

	    homePage.clickProducts();

	    ProductPage productPage = new ProductPage(driver);

	    productPage.searchProduct("Blue Top");

	    Assert.assertTrue(productPage.getProductCount() > 0);
	}

	@Test(groups = {"smoke", "regression"})
	public void verifyAddProductToCart() {

	    HomePage homePage = new HomePage(driver);

	    homePage.clickProducts();

	    ProductPage productPage = new ProductPage(driver);

	    productPage.clickViewProduct();

	    ProductDetailsPage detailsPage =
	            new ProductDetailsPage(driver);

	    detailsPage.clickAddToCart();

	    detailsPage.clickViewCart();

	    CartPage cartPage = new CartPage(driver);

	    Assert.assertTrue(cartPage.getCartProductCount() > 0);

	}

}