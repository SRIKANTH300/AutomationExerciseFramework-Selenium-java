package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

    WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "name")
    WebElement nameTextbox;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement emailTextbox;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signupButton;

    public void signup(String name, String email) {

        nameTextbox.sendKeys(name);
        emailTextbox.sendKeys(email);
        signupButton.click();
    }
}