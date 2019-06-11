package com.rodelcalasagsag;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
  public static RemoteWebDriver createDriver() throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setPlatform(Platform.ANY);
    capabilities.setBrowserName(Config.BROWSER_NAME);
    RemoteWebDriver driver = new RemoteWebDriver(new URL(Config.HUB_URL), capabilities);
    driver.setFileDetector(new LocalFileDetector());
    driver.manage().window().maximize();

    return driver;
  }

  public static void quitDriver(WebDriver driver) {
    driver.quit();
  }
}
