package com.saucedemo.tests;

import com.saucedemo.TestBase;
import com.saucedemo.pages.LoginPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@DisplayName("Login Tests")
public class LoginTest extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test
    @Story("Auth")
    @Feature("Login")
    @Tags({@Tag("auth"), @Tag("smoke")})
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка успешной авторизации")
    void loginSuccessTest() {
        step("Открыть сайт", () ->
                open(baseUrl));
        step("Заполнить логин и пароль", () ->
                loginPage.login("standard_user", "secret_sauce"));
        step("Проверить переход на главную страницу", () ->
                loginPage.checkProductsTitle("Products"));
    }

    @Test
    @Story("Auth")
    @Feature("Login")
    @Tags({@Tag("auth"), @Tag("regress")})
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка ошибки обязательности полей")
    void loginWithoutUsernameAndPasswordTests() {
        step("Открыть сайт", () ->
                open(baseUrl));
        step("Кликнуть на кнопку Login", () ->
                loginPage.clickLoginBtn());
        step("Проверить ошибку обязательности полей", () ->
                loginPage.checkErrorLogin("Epic sadface: Username is required"));
    }

    @Test
    @Story("Auth")
    @Feature("Login")
    @Tags({@Tag("auth"), @Tag("regress")})
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка ошибки обязательности поля Username")
    void loginWithoutUsernameTests() {
        step("Открыть сайт", () ->
                open(baseUrl));
        step("Заполнить логин", () ->
                loginPage.passType("123456"));
        step("Кликнуть на кнопку Login", () ->
                loginPage.clickLoginBtn());
        step("Проверить ошибку обязательности полей", () ->
                loginPage.checkErrorLogin("Epic sadface: Username is required"));
    }

    @Test
    @Story("Auth")
    @Feature("Login")
    @Tags({@Tag("auth"), @Tag("regress")})
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка ошибки обязательности поля Password")
    void loginWithoutPasswordTests() {
        step("Открыть сайт", () ->
                open(baseUrl));
        step("Заполнить логин", () ->
                loginPage.loginType("standard_user"));
        step("Кликнуть на кнопку Login", () ->
                loginPage.clickLoginBtn());
        step("Проверить ошибку обязательности полей", () ->
                loginPage.checkErrorLogin("Epic sadface: Password is required"));
    }

    @Test
    @Story("Auth")
    @Feature("Login")
    @Tags({@Tag("auth"), @Tag("smoke")})
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка ошибки заблокированного пользователя")
    void loginBlockedUserTests() {
        step("Открыть сайт", () ->
                open(baseUrl));
        step("Заполнить логин и пароль", () ->
                loginPage.login("locked_out_user", "secret_sauce"));
        step("Проверить ошибку обязательности полей", () ->
                loginPage.checkErrorLogin("Epic sadface: Sorry, this user has been locked out."));
    }

    @Test
    @Story("Auth")
    @Feature("Login")
    @Tags({@Tag("auth"), @Tag("regress")})
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Проверка ошибки несуществующего пользователя")
    void userNotFoundTests() {
        step("Открыть сайт", () ->
                open(baseUrl));
        step("Заполнить логин и пароль", () ->
                loginPage.login("11111111111", "11111111111"));
        step("Проверить ошибку обязательности полей", () ->
                loginPage.checkErrorLogin("Epic sadface: Username and password do not match any " +
                        "user in this service"));
    }
}
