package com.saucedemo.tests;

import com.saucedemo.TestBase;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@DisplayName("Checkout Tests")
public class CheckoutTest extends TestBase {
    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @BeforeEach
    void auth() {
        step("Открыть сайт", () ->
                open(baseUrl));
        step("Авторизоваться", () ->
                loginPage.auth());
        step("Перейти на страницу оформления заказа", () ->
                productsPage.clickCartBtn().clickCheckoutBtn());
    }

    @Test
    @DisplayName("Проверка обязательности полей")
    void emptyCheckoutFormTest() {
        step("Нажать кнопку продолжить", () ->
                checkoutPage.clickContinueBtn());
        step("Проверить ошибку обязательности поля", () ->
                checkoutPage.checkErrorCheckout("Error: First Name is required"));
    }

    @Test
    @DisplayName("Проверка обязательности поля Last Name")
    void lastNameRequiredTest() {
        step("Заполнить поле First Name", () ->
                checkoutPage.firstNameType("First Name"));
        step("Нажать кнопку продолжить", () ->
                checkoutPage.clickContinueBtn());
        step("Проверить ошибку обязательности поля", () ->
                checkoutPage.checkErrorCheckout("Error: Last Name is required"));
    }

    @Test
    @DisplayName("Проверка обязательности поля Postal Code")
    void postalCodeRequiredTest() {
        step("Заполнить поле First Name", () ->
                checkoutPage.firstNameType("First Name"));
        step("Заполнить поле Last Name", () ->
                checkoutPage.lastNameType("Last Name"));
        step("Нажать кнопку продолжить", () ->
                checkoutPage.clickContinueBtn());
        step("Проверить ошибку обязательности поля", () ->
                checkoutPage.checkErrorCheckout("Error: Postal Code is required"));
    }

    @Test
    @DisplayName("Успешное оформление заказа")
    void successCheckoutTest() {
        step("Заполнить поле First Name", () ->
                checkoutPage.firstNameType("First Name"));
        step("Заполнить поле Last Name", () ->
                checkoutPage.lastNameType("Last Name"));
        step("Заполнить поле Postal Code", () ->
                checkoutPage.postalType("LS-2122"));
        step("Нажать кнопку продолжить", () ->
                checkoutPage.clickContinueBtn());
        step("Проверить переход на страницу успешного оформления заказа", () ->
                checkoutPage.checkShippingInfo("Free Pony Express Delivery!"));
    }


}
