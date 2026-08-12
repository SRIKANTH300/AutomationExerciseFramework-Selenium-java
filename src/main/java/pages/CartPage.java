package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//tr")
    List<WebElement> cartProducts;

    public int getCartProductCount() {

        return cartProducts.size();

    }
    
    
    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    WebElement proceedToCheckoutButton;

    public void clickProceedToCheckout() {

        proceedToCheckoutButton.click();
    }

}