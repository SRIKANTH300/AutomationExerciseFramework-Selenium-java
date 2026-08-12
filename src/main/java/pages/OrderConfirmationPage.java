package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {

    WebDriver driver;

    public OrderConfirmationPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@data-qa='order-placed']")
    WebElement orderPlacedMessage;

    @FindBy(xpath = "//p[contains(text(),'Your order has been confirmed!')]")
    WebElement orderConfirmationMessage;

    public String getOrderPlacedMessage() {

        return orderPlacedMessage.getText();
    }

    public String getOrderConfirmationMessage() {

        return orderConfirmationMessage.getText();
    }
}