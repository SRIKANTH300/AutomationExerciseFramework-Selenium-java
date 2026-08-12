package pages;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import java.time.Duration;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "search_product")
    WebElement searchTextBox;

    @FindBy(id = "submit_search")
    WebElement searchButton;

    @FindBy(xpath = "//div[@class='productinfo text-center']/p")
    List<WebElement> productList;

    

    public void searchProduct(String productName) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOf(searchTextBox)
        );

        searchTextBox.clear();
        searchTextBox.sendKeys(productName);

        wait.until(
                ExpectedConditions.elementToBeClickable(searchButton)
        );

        searchButton.click();
    }

    public int getProductCount() {

        return productList.size();

    }

    @FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    WebElement viewProduct;

    public void clickViewProduct() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(viewProduct));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                viewProduct
        );

        wait.until(ExpectedConditions.elementToBeClickable(viewProduct));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                viewProduct
        );
    }

}