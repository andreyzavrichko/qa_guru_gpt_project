package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    SelenideElement
            loginInput = $("#user-name"),
            passwordInput = $("#password"),
            loginButton = $("#login-button"),
            titleProducts = $(".title"),

            errorLogin = $("h3[data-test='error']");

    public LoginPage login(String login, String password) {
        loginInput.type(login);
        passwordInput.type(password);
        loginButton.click();
        return this;
    }

    public LoginPage checkProductsTitle(String value) {
        titleProducts.shouldHave(text(value));

        return this;
    }

    public LoginPage checkErrorLogin(String value) {
        errorLogin.shouldHave(text(value));

        return this;
    }

    public void clickLoginBtn() {
        loginButton.click();

    }




}
