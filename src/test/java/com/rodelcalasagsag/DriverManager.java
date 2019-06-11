package com.rodelcalasagsag;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {
  public static RemoteWebDriver createDriver() throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setPlatform(Platform.WINDOWS);
    capabilities.setBrowserName("firefox");
    RemoteWebDriver driver =
        new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.setFileDetector(new LocalFileDetector());
    driver.manage().window().maximize();

    return driver;
  }

  public static void quitDriver(WebDriver driver) {
    driver.quit();
  }
}
