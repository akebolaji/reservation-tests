package com.sita.Pages;

import com.sita.Utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SitaHomePage extends Helper {
    private static final String SITA_SITE = "https://sitatesting.github.io/AutomationTest/index.html";
    static WebDriver driver;

    By exploreButton = By.cssSelector(".items>.row>div:nth-of-type(2) .main-button>a");
    By caribbean = By.xpath("//h4[text()='CARIBBEAN']");

    public SitaHomePage() {
        super(driver);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://sitatesting.github.io/AutomationTest/index.html");
    }

    public SitaAboutPage getAboutPage() {
        Helper helper = new Helper(driver);
        helper.scrollTo(driver.findElement(caribbean));
        helper.clickAction(driver.findElement(exploreButton));
        return new SitaAboutPage(driver);
    }

    public static void closeBrowser() {
        driver.quit();
    }
}
