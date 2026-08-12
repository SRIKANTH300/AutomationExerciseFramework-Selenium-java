package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    WebDriver driver;

    public PaymentPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "name_on_card")
    WebElement nameOnCard;

    @FindBy(name = "card_number")
    WebElement cardNumber;

    @FindBy(name = "cvc")
    WebElement cvc;

    @FindBy(name = "expiry_month")
    WebElement expiryMonth;

    @FindBy(name = "expiry_year")
    WebElement expiryYear;

    @FindBy(id = "submit")
    WebElement payAndConfirmButton;


    public void enterPaymentDetails(
            String name,
            String card,
            String cvv,
            String month,
            String year) {

        nameOnCard.sendKeys(name);
        cardNumber.sendKeys(card);
        cvc.sendKeys(cvv);
        expiryMonth.sendKeys(month);
        expiryYear.sendKeys(year);
    }


    public void clickPayAndConfirm() {

        payAndConfirmButton.click();
    }
}