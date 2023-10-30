package com.sita.Pages;

import com.sita.Utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SitaReservationPage extends Helper {
    WebDriver driver;
    public By form = By.cssSelector(".reservation-form");
    By name = By.cssSelector(".Name");
    By phoneNumber = By.cssSelector(".Number");
    By reservation = By.xpath("//button[text()='Make Your Reservation Now']");
    By numberOfGuests = By.cssSelector("select[name='Guests']");
    By date = By.cssSelector(".date");
    By destination = By.xpath("//select[@name='Destination']");

    public SitaReservationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void customerDetailsAndReservation(String fullName, String number, String futureDate) {
        scrollTo(driver.findElement(form));
        driver.findElement(name).sendKeys(fullName);
        driver.findElement(phoneNumber).sendKeys(number);
        driver.findElement(date).sendKeys(futureDate);
        destinationAndGuestNumber();
        clickAction(driver.findElement(reservation));

    }

    public void destinationAndGuestNumber() {
        Select guestNumber = new Select(driver.findElement(numberOfGuests));
        guestNumber.selectByIndex(1);
        Select myDestination = new Select(driver.findElement(destination));
        myDestination.selectByIndex(2);
    }

    public WebElement verifyFormPresent() {
        return driver.findElement(form);
    }

    public String verifyRefreshedPage() {
        String fullName = driver.findElement(name).getText();
        String customerNumber = driver.findElement(phoneNumber).getText();
        String dateInFuture = driver.findElement(date).getText();
        return fullName + customerNumber + dateInFuture;
    }

    public String verifyRequiredField() {
        WebElement fullName = driver.findElement(name);
        String pleaseFillOut = fullName.getAttribute("required");
        return pleaseFillOut;
    }

}
