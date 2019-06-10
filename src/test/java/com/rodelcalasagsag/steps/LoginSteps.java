package com.rodelcalasagsag.steps;

import com.rodelcalasagsag.pages.LoginPage;
import com.rodelcalasagsag.pages.SecureYourAccountModal;
import cucumber.api.java.en.Given;

import java.net.MalformedURLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginSteps {
    private World world;

    public LoginSteps(World world) {
        this.world = world;
    }

    @Given("I am logged in")
    public void iAmLoggedIn() throws MalformedURLException {
        world.userMenu = LoginPage.get(world.driver).login("rc-assessment", "E3P5#n6t");
        SecureYourAccountModal.get(world.driver).skip();
        assertThat(world.userMenu.getHeaderUsername(), equalTo("rc-assessment"));
    }
}
