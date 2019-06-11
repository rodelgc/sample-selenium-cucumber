package com.rodelcalasagsag.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    skipButton.click();
  }
}
