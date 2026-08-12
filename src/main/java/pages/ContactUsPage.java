package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "name")
    WebElement nameTextBox;

    @FindBy(name = "email")
    WebElement emailTextBox;

    @FindBy(name = "subject")
    WebElement subjectTextBox;

    @FindBy(id = "message")
    WebElement messageTextBox;

    @FindBy(name = "upload_file")
    WebElement uploadFile;

    @FindBy(name = "submit")
    WebElement submitButton;

    @FindBy(xpath = "//*[contains(text(),'Success! Your details have been submitted successfully.')]")
    WebElement successMessage;

    @FindBy(xpath = "//h2[text()='Get In Touch']")
    WebElement getInTouchText;

    public boolean isGetInTouchDisplayed() {

        return getInTouchText.isDisplayed();
    }

    public void enterName(String name) {

        nameTextBox.sendKeys(name);
    }

    public void enterEmail(String email) {

        emailTextBox.sendKeys(email);
    }

    public void enterSubject(String subject) {

        subjectTextBox.sendKeys(subject);
    }

    public void enterMessage(String message) {

        messageTextBox.sendKeys(message);
    }

    public void uploadFile(String filePath) {

        uploadFile.sendKeys(filePath);
    }

    public void clickSubmit() {

        submitButton.click();
    }

    public String getSuccessMessage() {

        return successMessage.getText();
    }
}