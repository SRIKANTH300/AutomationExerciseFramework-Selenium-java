package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderConfirmationPage;
import pages.PaymentPage;
import pages.ProductDetailsPage;
import pages.ProductPage;

public class CheckoutTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void verifyCompleteOrderPlacement() {

        // 1. Home Page
        HomePage homePage = new HomePage(driver);

        // 2. Login
        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "srikanth123@gmail.com",
                "Test@123"
        );

        // 3. Products Page
        homePage.clickProducts();

        ProductPage productPage = new ProductPage(driver);

        // 4. Open Product Details
        productPage.clickViewProduct();

        // 5. Product Details
        ProductDetailsPage productDetailsPage =
                new ProductDetailsPage(driver);

        // 6. Add Product to Cart
        productDetailsPage.clickAddToCart();

        // 7. View Cart
        productDetailsPage.clickViewCart();

        // 8. Cart Page
        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(
                cartPage.getCartProductCount() > 0,
                "Product was not added to cart"
        );

        // 9. Proceed to Checkout
        cartPage.clickProceedToCheckout();

        // 10. Checkout Page
        CheckoutPage checkoutPage =
                new CheckoutPage(driver);

        // Verify Address Details
        Assert.assertTrue(
                checkoutPage.isAddressDetailsDisplayed(),
                "Address Details are not displayed"
        );

        // Verify Review Your Order
        Assert.assertTrue(
                checkoutPage.isReviewOrderDisplayed(),
                "Review Your Order is not displayed"
        );

        // 11. Enter Order Comment
        checkoutPage.enterOrderComment(
                "Please deliver the order safely."
        );

        // 12. Place Order
        checkoutPage.clickPlaceOrder();

        // 13. Payment Page
        PaymentPage paymentPage =
                new PaymentPage(driver);

        paymentPage.enterPaymentDetails(
                "Srikanth",
                "4111111111111111",
                "123",
                "12",
                "2030"
        );

        // 14. Pay and Confirm Order
        paymentPage.clickPayAndConfirm();

        // 15. Order Confirmation Page
        OrderConfirmationPage confirmationPage =
                new OrderConfirmationPage(driver);

        // Verify ORDER PLACED!
        Assert.assertEquals(
                confirmationPage.getOrderPlacedMessage(),
                "ORDER PLACED!",
                "Order was not placed successfully"
        );

        // Verify confirmation message
        Assert.assertTrue(
                confirmationPage
                        .getOrderConfirmationMessage()
                        .contains("Your order has been confirmed!"),
                "Order confirmation message is not displayed"
        );
    }
}