package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends BaseTest {

    @Test(groups = {"regression"})
    public void verifyContactUsForm() {

        HomePage homePage = new HomePage(driver);

        homePage.clickContactUs();

        ContactUsPage contactUsPage =
                new ContactUsPage(driver);

        Assert.assertTrue(
                contactUsPage.isGetInTouchDisplayed(),
                "GET IN TOUCH is not displayed"
        );

        contactUsPage.enterName("Srikanth");

        contactUsPage.enterEmail("srikanth123@gmail.com");

        contactUsPage.enterSubject("Automation Testing");

        contactUsPage.enterMessage(
                "This is a test message."
        );

        contactUsPage.clickSubmit();

        driver.switchTo().alert().accept();

        Assert.assertTrue(
                contactUsPage.getSuccessMessage()
                        .contains("Success! Your details have been submitted successfully."),
                "Contact form submission was not successful"
        );
    }
}