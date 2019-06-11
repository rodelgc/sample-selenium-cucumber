package com.rodelcalasagsag.pages;

import com.rodelcalasagsag.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class PageObject {
  protected WebDriver driver;
  private WebDriverWait wait;

  public PageObject(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, Config.DEFAULT_EXPLICIT_WAIT_TIME);
  }

  protected void type(WebElement e, String s) {
    e.clear();
    e.sendKeys(s);
  }

  protected WebElement waitElement(WebElement e) {
    return wait.until(visibilityOf(e));
  }

  public boolean showsMessage(String msg) {
    By byXPath = By.xpath("//*[contains(text(),'" + msg + "')]");
    return wait.until(visibilityOfElementLocated(byXPath)).isDisplayed();
  }

  protected WebElement waitElement(WebElement e, int customTimeout) {
    wait.withTimeout(Duration.ofSeconds(customTimeout));
    WebElement visibleElement = waitElement(e);

    // reset explicit wait time to default
    wait.withTimeout(Duration.ofSeconds(Config.DEFAULT_EXPLICIT_WAIT_TIME));

    return visibleElement;
  }
}
