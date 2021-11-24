package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    @FindBy(css = "td[class='lead']")
    private WebElement total;

    @FindBy(id = "checkout-link")
    private WebElement checkout;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getCartTotal() {
        String value = total.getText();
        return  value;
    }

    public void clickCheckout() {
        checkout.click();
    }
}
