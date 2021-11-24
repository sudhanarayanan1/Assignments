package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutDelivery {
    @FindBy(css = "input[name='commit']")
    private WebElement saveAndContinue;

    public CheckoutDelivery(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectBillingAndContinue() {
        saveAndContinue.click();
    }
}
