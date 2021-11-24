package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutComplete {

    @FindBy(css = "div[class='alert alert-notice']")
    private WebElement total;

    public CheckoutComplete(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public boolean verifyOrderSuccess() {
        if (total.getText().equals("Your order has been processed successfully"))
            return true;
        else
            return false;
    }
}
