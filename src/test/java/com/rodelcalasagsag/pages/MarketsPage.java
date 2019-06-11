package com.rodelcalasagsag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MarketsPage extends PageObject {

  private static final String URL = "https://trade.kraken.com/markets";
  private static final By BY_ASSET = By.cssSelector("div.rankings-list-asset");
  private static final By BY_PAIR = By.cssSelector("div.rankings-list-pair");

  @FindBy(xpath = "//div[@id='filter-bar']//button[.='Assets']")
  private WebElement assetsButton;

  @FindBy(xpath = "//div[@id='filter-bar']//button[.='Quotes']")
  private WebElement quotesButton;

  @FindBy(id = "menuContentQueryInput")
  private WebElement searchField;

  @FindBy(className = "search-menu-asset-slug")
  private List<WebElement> assetMenuSlugs;

  @FindBy(css = "div.search-menu")
  private WebElement searchMenu;

  @FindBy(css = "a[href^='/markets/kraken/'][title^='Kraken']")
  private List<WebElement> rows;

  public MarketsPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
    super.waitElement(assetsButton);
  }

  public static MarketsPage get(WebDriver driver) {
    driver.get(URL);
    return new MarketsPage(driver);
  }

  public MarketsPage selectAssets(List<String> assetCodes) {
    selectFromMenu(assetsButton, assetCodes);
    return this;
  }

  private void selectFromMenu(WebElement dropDownButton, List<String> searchKeywords) {
    openMenu(dropDownButton);
    for (String input : searchKeywords) {
      super.type(searchField, input);
      boolean itemFound = false;
      for (WebElement item : assetMenuSlugs) {
        if (item.getText().equals(input)) {
          item.click();
          itemFound = true;
          break;
        }
      }
      if (!itemFound) {
        throw new Error("Menu item not found: \"" + input + "\"");
      }
    }
    dropDownButton.click(); // close menu
  }

  private void openMenu(WebElement dropDownButton) {
    boolean menuIsOpen = false;
    int maxTries = 10;

    for (int i = 0; i < maxTries && !menuIsOpen; i++) {
      dropDownButton.click();
      try {
        menuIsOpen = super.waitElement(searchMenu, 2).isDisplayed();
      } catch (Exception e) {
        if (i == maxTries - 1) {
          throw new Error("Menu didn't open after " + maxTries + " maximum tries");
        } else {
          System.out.println("Menu didn't open. Retrying...");
        }
      }
    }
  }

  public MarketsPage selectQuotes(List<String> quoteCodes) {
    selectFromMenu(quotesButton, quoteCodes);
    return this;
  }

  public int getNumberOfRows() {
    return rows.size();
  }

  public boolean rowHasCorrectAssetAndPair(
      int rowIndex, List<String> assetNames, List<String> assetCodes, List<String> quoteCodes) {
    WebElement row = rows.get(rowIndex);
    String actualAssetName = row.findElement(BY_ASSET).getText().trim();
    int assetIndex = assetNames.indexOf(actualAssetName);
    boolean assetNamesMatch = assetIndex >= 0;

    String actualPair = row.findElement(BY_PAIR).getText().trim();
    String actualAssetCode = actualPair.substring(0, 3).toUpperCase();
    String actualQuoteCode = actualPair.substring(actualPair.length() - 3).toUpperCase();
    boolean assetNameMatchesWithCode = assetCodes.indexOf(actualAssetCode) == assetIndex;

    return assetNamesMatch && assetNameMatchesWithCode && quoteCodes.contains(actualQuoteCode);
  }
}
