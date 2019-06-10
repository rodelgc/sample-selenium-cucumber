package com.rodelcalasagsag.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageObject {

    private static final String URL = "https://www.kraken.com/sign-in";

    @FindBy(css = "input[name='username']")
    private WebElement usernameField;

    @FindBy(css = "input[type='password']")
    private WebElement passwordField;

    @FindBy(css = "form[action$='sign-in']")
    private WebElement loginForm;

    private LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        super.findElement(loginForm);
    }

    public static LoginPage get(WebDriver driver) {
        driver.get(URL);
        return new LoginPage(driver);
    }

    public UserMenu login(String username, String password) {
        return typeUsername(username)
                .typePassword(password)
                .submit();
    }

    private UserMenu submit() {
        loginForm.submit();
        return new UserMenu(driver);
    }

    private LoginPage typePassword(String password) {
        super.type(passwordField, password);
        return this;
    }

    private LoginPage typeUsername(String username) {
        super.type(usernameField, username);
        return this;
    }
}
