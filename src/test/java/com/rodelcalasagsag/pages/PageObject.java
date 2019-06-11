package com.rodelcalasagsag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
  protected WebDriver driver;
  private WebDriverWait wait;

  public PageObject(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 10);
  }

  protected void type(WebElement e, String s) {
    e.clear();
    e.sendKeys(s);
  }

  protected WebElement waitElement(WebElement e) {
    return wait.until(ExpectedConditions.visibilityOf(e));
  }

  public boolean showsMessage(String msg) {
    By byXPath = By.xpath("//*[contains(text(),'" + msg + "')]");
    return driver.findElement(byXPath).isDisplayed();
  }
}
