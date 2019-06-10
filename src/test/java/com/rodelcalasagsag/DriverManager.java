package com.rodelcalasagsag;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {
    public static RemoteWebDriver createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.getCurrent());
        capabilities.setBrowserName("chrome");
    }

}
