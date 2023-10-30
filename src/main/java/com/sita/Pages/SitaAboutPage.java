package com.sita.Pages;

import com.sita.Utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SitaAboutPage extends Helper {
    WebDriver driver;
    By weeklyOffers = By.cssSelector(".owl-weekly-offers.owl-carousel.owl-loaded.owl-drag");
    By makeReservation = By.cssSelector(".owl-weekly-offers.owl-carousel.owl-loaded.owl-drag>.owl-stage-outer>.owl-stage>div:nth-of-type(8)>.item>.thumb>.text>div:nth-of-type(2)>a");

    public SitaAboutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public SitaReservationPage getReservationPage() {
        SitaAboutPage sta = new SitaAboutPage(driver);
        sta.scrollTo(driver.findElement(weeklyOffers));
        sta.clickAction(driver.findElement(makeReservation));
        return new SitaReservationPage(driver);
    }
}
