package com.saucedemo.tests;

import com.saucedemo.TestBase;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class CheckoutTest extends TestBase {
    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @BeforeEach
    void auth() {
        step("Открыть сайт", () -> open(baseUrl));
        loginPage.auth();
        productsPage.clickCartBtn().clickCheckoutBtn();
    }

    @Test
    @DisplayName("Успешная авторизация")
    void emptyTest() {
        step("Заполнить логин и пароль", () -> checkoutPage.clickContinueBtn());
        step("Проверить переход на главную страницу", () -> checkoutPage.checkErrorCheckout("Error: First Name is required"));
    }

    @Test
    @DisplayName("Успешная авторизация")
    void empty1Test() {
        step("Заполнить логин и пароль", () -> checkoutPage.firstNameType("First Name"));
        step("Заполнить логин и пароль", () -> checkoutPage.clickContinueBtn());
        step("Проверить переход на главную страницу", () -> checkoutPage.checkErrorCheckout("Error: Last Name is required"));
    }

    @Test
    @DisplayName("Успешная авторизация")
    void empty2Test() {
        step("Заполнить логин и пароль", () -> checkoutPage.firstNameType("First Name"));
        step("Заполнить логин и пароль", () -> checkoutPage.lastNameType("Last Name"));
        step("Заполнить логин и пароль", () -> checkoutPage.clickContinueBtn());
        step("Проверить переход на главную страницу", () -> checkoutPage.checkErrorCheckout("Error: Postal Code is required"));
    }

    @Test
    @DisplayName("Успешная авторизация")
    void empty3Test() {
        step("Заполнить логин и пароль", () -> checkoutPage.firstNameType("First Name"));
        step("Заполнить логин и пароль", () -> checkoutPage.lastNameType("Last Name"));
        step("Заполнить логин и пароль", () -> checkoutPage.postalType("LS-2122"));
        step("Заполнить логин и пароль", () -> checkoutPage.clickContinueBtn());
        step("Проверить переход на главную страницу", () -> checkoutPage.checkShippingInfo("Free Pony Express Delivery!"));
    }




}
