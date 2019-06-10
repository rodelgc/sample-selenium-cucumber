package com.rodelcalasagsag.steps;

import cucumber.api.java.en.When;

public class UserMenuSteps {

    private World world;

    public UserMenuSteps(World world) {
        this.world = world;
    }

    @When("I navigate to the settings page")
    public void iNavigateToTheSettingsPage() {
        world.settingsPage = world.userMenu.navigateToSettingsPage();
    }
}
