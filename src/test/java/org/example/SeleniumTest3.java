package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumTest3 {
    WebDriver driver;

    @Parameters({"browser", "url"})
    @BeforeTest
    public void beofreTest(String browser, String url)
    {
        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                driver = new ChromeDriver();
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
                driver = new FirefoxDriver();
            default:
                System.out.println("can't supply such browser.");
        }

        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void searchSelenium()
    {
        driver.findElement(By.id("kw")).clear();
        driver.findElement(By.id("kw")).sendKeys("selenium");
        driver.findElement(By.id("su")).click();
    }

    @AfterTest
    public void afterTest()
    {
        driver.quit();
    }
}
