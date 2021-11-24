package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutAddress {

    @FindBy(id = "order_bill_address_id_0")
    private WebElement otherAddress;

    @FindBy(id = "order_bill_address_attributes_firstname")
    private WebElement firstName;

    @FindBy(id = "order_bill_address_attributes_lastname")
    private WebElement lastName;

    @FindBy(id = "order_bill_address_attributes_address1")
    private WebElement address;

    @FindBy(id = "order_bill_address_attributes_country_id")
    private WebElement country;

    @FindBy(id = "order_bill_address_attributes_city")
    private WebElement city;

    @FindBy(id = "order_bill_address_attributes_state_id")
    private WebElement state;

    @FindBy(id = "order_bill_address_attributes_zipcode")
    private WebElement zipcode;

    @FindBy(id = "order_bill_address_attributes_phone")
    private WebElement phone;

    @FindBy(id = "save_user_address")
    private WebElement saveAddress;

    @FindBy(css = "input[name='commit']")
    private WebElement saveAndContinue;

    public CheckoutAddress(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public  void fillBillingAddress() {

        otherAddress.click();

        firstName.clear();
        firstName.sendKeys("ABC");

        lastName.clear();
        lastName.sendKeys("XYZ");

        address.clear();
        address.sendKeys("123 Cambridge lane");

        Select c = new Select(country);
        c.selectByVisibleText("Germany");

        city.clear();
        city.sendKeys("Frankfurt");

        Select s = new Select(state);
        s.selectByVisibleText("Hessen");

        zipcode.clear();
        zipcode.sendKeys("60306");

        phone.clear();
        phone.sendKeys("74637829223");

        saveAddress.click();
        saveAndContinue.click();


    }
}
