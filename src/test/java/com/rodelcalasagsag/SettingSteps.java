package com.rodelcalasagsag;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

public class SettingSteps {
    @Given("I am logged in")
    public void iAmLoggedIn() {
        WebDriver driver = DriverManager.createDriver();
    }
}
