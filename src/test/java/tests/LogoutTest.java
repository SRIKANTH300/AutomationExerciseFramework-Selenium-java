package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class LogoutTest extends BaseTest {

    @Test(groups = {"regression"})
    public void verifyLogout() {

        HomePage homePage = new HomePage(driver);

        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "srikanth123@gmail.com",
                "Test@123"
        );

        homePage.clickLogout();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("login"),
                "User was not logged out successfully"
        );
    }
}