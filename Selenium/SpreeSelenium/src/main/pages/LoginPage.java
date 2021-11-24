package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(linkText = "Login")
    private WebElement login;

    @FindBy(css = "a[href='/login']")
    private WebElement loginLink;

    @FindBy(xpath = "//input[@name='spree_user[email]']")
    private WebElement username;

    @FindBy(css = "input[name='spree_user[password]']")
    private WebElement password;

    @FindBy(css = "input[value='Login']")
    private WebElement loginBtn;

    @FindBy(css = "div[class='alert alert-success']")
    private WebElement loggedInMessage;


    public LoginPage (WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    // Login
    public String loginUser(String uname, String pwd) throws InterruptedException {
        loginLink.click();
        username.sendKeys(uname);
        password.sendKeys(pwd);
        loginBtn.click();
        return(loggedInMessage.getText());
    }
}
