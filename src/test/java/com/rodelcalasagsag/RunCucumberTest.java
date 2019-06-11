package com.rodelcalasagsag;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"})
public class RunCucumberTest {
  @BeforeClass
  public static void waitGridToBeReady() {
    DriverManager.waitGridToBeReady();
  }

  @AfterClass
  public static void tearDownGrid() {
    DriverManager.tearDownGrid();
  }
}
