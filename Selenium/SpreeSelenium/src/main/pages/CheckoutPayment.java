package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPayment {

    @FindBy(id = "order_payments_attributes__payment_method_id_3")
    private WebElement payment;

    @FindBy(css = "input[name='commit']")
    private WebElement saveAndContinue;

    public  CheckoutPayment(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void completePayment() {
        payment.click();
        saveAndContinue.click();
    }
}
