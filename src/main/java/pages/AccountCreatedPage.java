package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {

    WebDriver driver;

    public AccountCreatedPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//b[text()='Account Created!']")
    WebElement accountCreatedMessage;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement continueButton;

    public String getAccountCreatedMessage() {

        return accountCreatedMessage.getText();

    }

    public void clickContinue() {

        continueButton.click();

    }

}