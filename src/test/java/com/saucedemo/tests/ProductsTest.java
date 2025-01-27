package com.saucedemo.tests;

import com.saucedemo.TestBase;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

public class ProductsTest extends TestBase {
    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();

    @BeforeEach
    void auth() {
        step("Открыть сайт", () -> open(baseUrl));
        loginPage.auth();
    }

    @Test
    @DisplayName("Успешная авторизация")
    void addToCardTest() {
        step("Заполнить логин и пароль", () -> productsPage.clickAddBtn());
        step("Проверить переход на главную страницу", () -> productsPage.checkCounter("1"));
    }


    @AfterEach
    void deleteGoods() {
        productsPage.clickRemoveBtn();
    }

}
