package com.rodelcalasagsag.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureYourAccountModal extends PageObject {

  @FindBy(css = "div.card.dib.TFAcard.authenticator")
  private WebElement authenticatorCard;

  @FindBy(css = "button.skip-button")
  private WebElement skipButton;

  public SecureYourAccountModal(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
    super.waitElement(authenticatorCard);
  }

  public static SecureYourAccountModal get(WebDriver driver) {
    return new SecureYourAccountModal(driver);
  }

  public void skip() {
    try {
      skipButton.click();
    } catch (Exception e) { // if screen size is too small to show the Skip Button
      new Actions(driver).sendKeys(Keys.ESCAPE).build().perform();
    }
  }
}
