package com.thoughtworks;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseTest {
    @Test
    public void checkoutWorkflow() throws InterruptedException {
        boolean orderStatus;
        String loginStatus;
        LoginPage l = new LoginPage(driver);
        HomePage h = new HomePage(driver);
        ProductPage p = new ProductPage(driver);
        CartPage c = new CartPage(driver);
        CheckoutAddress co = new CheckoutAddress(driver);
        CheckoutDelivery d = new CheckoutDelivery(driver);
        CheckoutPayment cp = new CheckoutPayment(driver);
        CheckoutComplete cc = new CheckoutComplete(driver);

        loginStatus = l.loginUser("abcxyz@gmail.com", "123456");
        Assert.assertEquals(loginStatus, "Logged in successfully");
        h.selectElementInDropDown("1");
        h.selectProductFromHomePage();
        p.addProductToCart();
        c.clickCheckout();
        co.fillBillingAddress();
        d.selectBillingAndContinue();
        cp.completePayment();
        orderStatus = cc.verifyOrderSuccess();
        Assert.assertEquals(orderStatus, true);
    }
}
