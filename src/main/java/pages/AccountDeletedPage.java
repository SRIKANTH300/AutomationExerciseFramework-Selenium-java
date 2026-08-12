package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDeletedPage {

    WebDriver driver;

    public AccountDeletedPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[text()='Account Deleted!']")
    WebElement accountDeletedMessage;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement continueButton;

    public String getAccountDeletedMessage() {

        return accountDeletedMessage.getText();
    }

    public void clickContinue() {

        continueButton.click();
    }
}