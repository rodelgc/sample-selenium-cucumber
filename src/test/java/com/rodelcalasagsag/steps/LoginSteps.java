package com.rodelcalasagsag.steps;

import com.rodelcalasagsag.config.Config;
import com.rodelcalasagsag.pages.LoginPage;
import com.rodelcalasagsag.pages.SecureYourAccountModal;
import cucumber.api.java.en.Given;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginSteps {
  private World world;

  public LoginSteps(World world) {
    this.world = world;
  }

  @Given("I am logged in")
  public void iAmLoggedIn() {
    world.userMenu = LoginPage.get(world.driver).login(Config.USERNAME, Config.PASSWORD);
    SecureYourAccountModal.get(world.driver).skip();
    assertThat(world.userMenu.getHeaderUsername(), equalTo(Config.USERNAME));
  }
}
