package com.rodelcalasagsag.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SettingsPage extends PageObject {

    @FindBy(id = "form-settings")
    private WebElement formSettings;

    @FindBy(css = "select[name='langcode']")
    private WebElement langDropDown;

    public SettingsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        super.findElement(formSettings);
    }

    public SettingsPage selectLanguage(String language) {
        Select langSelect = new Select(langDropDown);
        langSelect.selectByVisibleText(language);
        return this;
    }

    public SettingsPage submit() {
        formSettings.submit();
        return new SettingsPage(driver);
    }
}
