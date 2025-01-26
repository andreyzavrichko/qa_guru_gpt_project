package com.saucedemo.tests;

import com.saucedemo.TestBase;
import com.saucedemo.pages.LoginPage;
import io.qameta.allure.Description;
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
    @DisplayName("Успешная авторизация")
    void searchVisibleTests() {
        step("Открыть сайт", () -> open(baseUrl));
        step("Кликнуть на кнопку Login", () -> loginPage.clickLoginBtn());
        step("Проверить ошибку обязательности полей", () -> loginPage.checkErrorLogin("Epic sadface: Username is required"));
    }
}
