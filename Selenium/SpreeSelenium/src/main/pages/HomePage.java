package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    @FindBy(id = "taxon")
    private WebElement dropDown;

    @FindBy(css = "input[value='Search']")
    private WebElement search;

    @FindBy(css = "span[title='Ruby on Rails Jr. Spaghetti']")
    private WebElement product;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectElementInDropDown(String element) throws InterruptedException {
        Select s = new Select(dropDown);
        s.selectByValue(element);

        search.click();
    }

    public void selectProductFromHomePage() throws InterruptedException {
        // Click on Rail Tote bag product
        //driver.findElement(By.cssSelector("span[title=‘"+prodName+"’]")).click();
        product.click();
    }
}
