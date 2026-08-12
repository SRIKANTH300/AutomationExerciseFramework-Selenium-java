package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountCreatedPage;
import pages.AccountInformationPage;
import pages.HomePage;
import pages.SignupPage;

public class SignupTest extends BaseTest {

    @Test(groups = {"regression"})
    public void verifySignup() {

        HomePage homePage = new HomePage(driver);
        homePage.clickSignupLogin();

        SignupPage signupPage = new SignupPage(driver);
        signupPage.signup("Srikanth", "srikanth123@gmail.com");

        AccountInformationPage accountInfo =
                new AccountInformationPage(driver);

        accountInfo.fillAccountInformation();

        AccountCreatedPage accountCreated =
                new AccountCreatedPage(driver);

        Assert.assertEquals(
                accountCreated.getAccountCreatedMessage(),
                "ACCOUNT CREATED!");

        accountCreated.clickContinue();
    }
}