package com.rodelcalasagsag.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SettingsSteps {
    private World world;

    public SettingsSteps(World world) {
        this.world = world;
    }

    @And("I select the language {string}")
    public void iSelectTheLanguage(String language) {
        world.settingsPage = world.settingsPage.selectLanguage(language);
    }

    @And("I submit the settings form")
    public void iSubmitTheSettingsForm() {
        world.settingsPage = world.settingsPage.submit();
    }

    @Then("I should see the message {string}")
    public void iShouldSeeTheMessage(String msg) {
        assertThat(world.settingsPage.showsMessage(msg), is(true));
    }
}
