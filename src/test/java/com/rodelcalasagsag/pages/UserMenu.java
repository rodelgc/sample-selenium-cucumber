package com.rodelcalasagsag.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserMenu extends PageObject {
  public static final String URL = "https://www.kraken.com/u/trade";
  public static final String TITLE = "Trade";

  @FindBy(id = "user-menu")
  private WebElement userMenuDropDown;

  @FindBy(id = "header-username")
  private WebElement headerUsername;

  @FindBy(css = "#user-menu ul.dropdown-menu a[href$='settings']")
  private WebElement itemSettings;

  public UserMenu(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
    waitElement(userMenuDropDown);
  }

  public String getHeaderUsername() {
    return headerUsername.getText();
  }

  public SettingsPage navigateToSettingsPage() {
    userMenuDropDown.click();
    itemSettings.click();
    return new SettingsPage(driver);
  }
}
