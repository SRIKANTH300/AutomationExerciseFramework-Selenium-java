package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

   
   
    @FindBy(linkText = "Signup / Login")
    WebElement signupLoginLink;
    public void clickSignupLogin() {

        signupLoginLink.click();
    }
    
    
    @FindBy(xpath = "//a[@href='/products']")
    WebElement productsLink;
    public void clickProducts() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.elementToBeClickable(productsLink)
        );

        productsLink.click();
    }

    
    @FindBy(linkText = "Cart")
    WebElement cartLink;
    public void clickCart() {

        cartLink.click();
    }

    @FindBy(xpath = "//a[@href='/contact_us']")
    WebElement contactUsLink;

    public void clickContactUs() {

        contactUsLink.click();
    }
    
    
    @FindBy(linkText = "Logout")
    WebElement logoutLink;
    public void clickLogout() {

        logoutLink.click();
    }
    
    
    @FindBy(xpath = "//a[@href='/delete_account']")
    WebElement deleteAccountLink;
    public void clickDeleteAccount() {

        deleteAccountLink.click();
    }
}