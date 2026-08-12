package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[text()='Address Details']")
    WebElement addressDetails;

    @FindBy(xpath = "//h2[text()='Review Your Order']")
    WebElement reviewOrder;

    @FindBy(name = "message")
    WebElement orderComment;

    @FindBy(xpath = "//a[text()='Place Order']")
    WebElement placeOrderButton;


    public boolean isAddressDetailsDisplayed() {

        return addressDetails.isDisplayed();
    }


    public boolean isReviewOrderDisplayed() {

        return reviewOrder.isDisplayed();
    }


    public void enterOrderComment(String comment) {

        orderComment.sendKeys(comment);
    }


    public void clickPlaceOrder() {

        placeOrderButton.click();
    }
}