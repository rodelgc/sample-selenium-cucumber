package com.rodelcalasagsag;

import io.restassured.RestAssured;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.greaterThan;

public class DriverManager {
  public static RemoteWebDriver createDriver() throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setPlatform(Platform.valueOf(Config.PLATFORM));
    capabilities.setBrowserName(Config.BROWSER_NAME);
    RemoteWebDriver driver = new RemoteWebDriver(new URL(Config.HUB_URL), capabilities);
    driver.setFileDetector(new LocalFileDetector());
    driver.manage().window().maximize();

    return driver;
  }

  public static void quitDriver(WebDriver driver) {
    driver.quit();
  }

  public static void tearDownGrid() {
    Runtime runtime = Runtime.getRuntime();
    try {
      // shutdown node
      runtime.exec("curl -s http://localhost:4555/extra/LifecycleServlet?action=shutdown");

      // shutdown hub
      runtime.exec("curl -s http://localhost:4444/lifecycle-manager?action=shutdown");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void waitGridToBeReady() {
    boolean isReady = false;
    final int maxTries = 10;

    System.out.println("Waiting for Selenium Grid to be ready...");
    for (int i = 0; i < maxTries && !isReady; i++) {
      try {
        RestAssured.get("http://localhost:4444/grid/api/hub")
            .then()
            .statusCode(200)
            .body("slotCounts.free", greaterThan(0))
            .body("slotCounts.total", greaterThan(0));
        isReady = true;
        System.out.println("Selenium Grid is now ready!");
      } catch (AssertionError | Exception e) {
        if (i == maxTries - 1) {
          e.printStackTrace();
          throw new Error("Selenium Grid was not ready after " + maxTries + " maximum tries");
        } else {
          System.out.println(
              "Selenium Grid was not ready. Retrying [" + (i + 1) + "/" + maxTries + "]");
          pause(2);
        }
      }
    }
  }

  private static void pause(int seconds) {
    try {
      TimeUnit.SECONDS.sleep(seconds);
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
  }
}
