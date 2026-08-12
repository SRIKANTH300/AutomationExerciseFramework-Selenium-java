package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountInformationPage {

    WebDriver driver;

    public AccountInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id_gender1")
    WebElement mrRadioButton;

    @FindBy(id = "password")
    WebElement passwordTextBox;

    @FindBy(id = "days")
    WebElement dayDropdown;

    @FindBy(id = "months")
    WebElement monthDropdown;

    @FindBy(id = "years")
    WebElement yearDropdown;

    @FindBy(id = "newsletter")
    WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    WebElement offersCheckbox;

    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "last_name")
    WebElement lastName;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "address1")
    WebElement address;

    @FindBy(id = "country")
    WebElement countryDropdown;

    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "zipcode")
    WebElement zipcode;

    @FindBy(id = "mobile_number")
    WebElement mobileNumber;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    WebElement createAccountButton;
    
    public void fillAccountInformation() {

        mrRadioButton.click();

        passwordTextBox.sendKeys("Test@123");

        new Select(dayDropdown).selectByVisibleText("10");
        new Select(monthDropdown).selectByVisibleText("May");
        new Select(yearDropdown).selectByVisibleText("1998");

        newsletterCheckbox.click();
        offersCheckbox.click();

        firstName.sendKeys("Srikanth");
        lastName.sendKeys("Ch");
        company.sendKeys("ABC Pvt Ltd");
        address.sendKeys("Hyderabad");
        new Select(countryDropdown).selectByVisibleText("India");
        state.sendKeys("Telangana");
        city.sendKeys("Hyderabad");
        zipcode.sendKeys("500001");
        mobileNumber.sendKeys("9876543210");

        createAccountButton.click();
    }

}