package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {

    WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@type='button']")
    WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='modal-content']//a[@href='/view_cart']")
    WebElement viewCartLink;

    // Locator for modal container to ensure modal is visible
    private By modalContainer = By.xpath("//div[@class='modal-content']");


    public void clickAddToCart() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.elementToBeClickable(addToCartButton)
        );

        addToCartButton.click();

        // Wait for modal to appear after clicking Add to Cart
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(modalContainer)
        );
    }


    public void clickViewCart() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        // Ensure modal is visible before attempting to interact with elements inside it
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(modalContainer)
        );

        wait.until(
                ExpectedConditions.visibilityOf(viewCartLink)
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(viewCartLink)
        );

        viewCartLink.click();
    }
}