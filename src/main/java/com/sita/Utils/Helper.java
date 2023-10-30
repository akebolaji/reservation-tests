package com.sita.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Helper {
    WebDriver driver;

    public Helper(WebDriver driver) {
        this.driver = driver;
    }
    public void scrollTo(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)this.driver;
        js.executeScript("arguments[0].scrollIntoView();", new Object[]{element});
    }

    public void clickAction(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)this.driver;
        js.executeScript("arguments[0].click();", new Object[]{element});
    }

    public static String getFutureDate(int days) {
        LocalDate futureDate = LocalDate.now().plusDays(days);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return futureDate.format(formatter);
    }
}
