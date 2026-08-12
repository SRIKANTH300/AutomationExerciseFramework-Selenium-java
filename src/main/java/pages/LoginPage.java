package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(name = "email")
    WebElement emailTextBox;

    @FindBy(name = "password")
    WebElement passwordTextBox;

    @FindBy(xpath = "//button[text()='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    WebElement errorMessage;

    public void enterEmail(String email) {

        emailTextBox.sendKeys(email);

    }

    public void enterPassword(String password) {

        passwordTextBox.sendKeys(password);

    }

    public void clickLogin() {

        loginButton.click();

    }

    public void login(String email, String password) {

        emailTextBox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        loginButton.click();

    }

    public String getErrorMessage() {

        return errorMessage.getText();

    }

}