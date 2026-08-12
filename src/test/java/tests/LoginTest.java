package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
            {"testuser@gmail.com", "Test@123"},
            {"testuser@gmail.com", "Test@123"},
            {"testuser@gmail.com", "Test@123"}
        };
    }

    @Test(
        groups = {"smoke", "regression"},
        dataProvider = "loginData"
    )
    public void verifyValidLogin(String username, String password) {

        HomePage homePage = new HomePage(driver);

        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(username, password);

    }

}