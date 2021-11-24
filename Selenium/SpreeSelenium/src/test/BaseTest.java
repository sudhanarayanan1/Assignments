package com.thoughtworks;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    static String webPage = "https://spree-vapasi-prod.herokuapp.com";

    @BeforeMethod
    public static void initialize()
    {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.get(webPage);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void screenShot(ITestResult result)  {
        if(ITestResult.FAILURE==result.getStatus()) {
            try {
                    TakesScreenshot screenshot=(TakesScreenshot)driver;
                    File src=screenshot.getScreenshotAs(OutputType.FILE);
                    FileUtils.copyFile(src, new File("output.png"));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
        driver.quit();
    }
}
