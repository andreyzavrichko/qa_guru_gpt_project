package com.saucedemo.tests;

import com.saucedemo.TestBase;
import com.saucedemo.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LoginTest extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test
    @DisplayName("Успешная авторизация")
    void loginSuccessTest() {
        step("Открыть сайт", () -> open(baseUrl));
        step("Заполнить логин и пароль", () -> loginPage.login("standard_user", "secret_sauce"));
        step("Проверить переход на главную страницу", () -> loginPage.checkProductsTitle("Products"));
    }

    @Test
    @DisplayName("Ошибка обязательности полей")
    void loginWithoutTests() {
        step("Открыть сайт", () -> open(baseUrl));
        step("Кликнуть на кнопку Login", () -> loginPage.clickLoginBtn());
        step("Проверить ошибку обязательности полей", () -> loginPage.checkErrorLogin("Epic sadface: Username is required"));
    }

    @Test
    @DisplayName("Ошибка обязательности полей")
    void loginWithoutPasswordTests() {
        step("Открыть сайт", () -> open(baseUrl));
        step("Заполнить логин", () -> loginPage.passType("123456"));
        step("Кликнуть на кнопку Login", () -> loginPage.clickLoginBtn());
        step("Проверить ошибку обязательности полей", () -> loginPage.checkErrorLogin("Epic sadface: Username is required"));
    }

    @Test
    @DisplayName("Ошибка обязательности полей")
    void loginWithoutUsernameTests() {
        step("Открыть сайт", () -> open(baseUrl));
        step("Заполнить логин", () -> loginPage.loginType("standard_user"));
        step("Кликнуть на кнопку Login", () -> loginPage.clickLoginBtn());
        step("Проверить ошибку обязательности полей", () -> loginPage.checkErrorLogin("Epic sadface: Password is required"));
    }

    @Test
    @DisplayName("Ошибка обязательности полей")
    void loginBlockedUserTests() {
        step("Открыть сайт", () -> open(baseUrl));
        step("Заполнить логин и пароль", () -> loginPage.login("locked_out_user", "secret_sauce"));
        step("Проверить ошибку обязательности полей", () -> loginPage.checkErrorLogin("Epic sadface: Sorry, this user has been locked out."));
    }

    @Test
    @DisplayName("Ошибка обязательности полей")
    void userNotFoundTests() {
        step("Открыть сайт", () -> open(baseUrl));
        step("Заполнить логин и пароль", () -> loginPage.login("11111111111", "11111111111"));
        step("Проверить ошибку обязательности полей", () -> loginPage.checkErrorLogin("Epic sadface: Username and password do not match any user in this service"));
    }
}
