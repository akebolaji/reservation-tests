package com.sita;

import com.sita.Pages.SitaAboutPage;
import com.sita.Pages.SitaHomePage;
import com.sita.Pages.SitaReservationPage;
import com.sita.Utils.Helper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;


public class TestReservation {
    @Test
    public void testReservation() {
        SitaHomePage sth = new SitaHomePage();
        SitaAboutPage sta = sth.getAboutPage();
        SitaReservationPage srv = sta.getReservationPage();
        srv.customerDetailsAndReservation("Femi Ake", "+353899828080", Helper.getFutureDate(2));
        assertSoftly(softly -> {
            softly.assertThat(srv.verifyFormPresent().isDisplayed());
            softly.assertThat(srv.verifyRefreshedPage()).isNullOrEmpty();
            srv.customerDetailsAndReservation("", "+353899828080", Helper.getFutureDate(2));
            softly.assertThat(srv.verifyRequiredField()).isEqualTo("true");
        });
    }

    @AfterClass
    static void tearDown() {
        SitaHomePage.closeBrowser();
    }

}