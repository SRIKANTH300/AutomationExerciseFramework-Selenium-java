package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountDeletedPage;
import pages.HomePage;
import pages.LoginPage;

public class DeleteAccountTest extends BaseTest {

    @Test(groups = {"regression"})
    public void verifyDeleteAccount() {

        HomePage homePage = new HomePage(driver);

        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "srikanth123@gmail.com",
                "Test@123"
        );

        homePage.clickDeleteAccount();

        AccountDeletedPage deletedPage =
                new AccountDeletedPage(driver);

        Assert.assertEquals(
                deletedPage.getAccountDeletedMessage(),
                "ACCOUNT DELETED!"
        );

        deletedPage.clickContinue();
    }
}