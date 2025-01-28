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
import static io.qameta.allure.Allure.step;

@DisplayName("Products Tests")
public class ProductsTest extends TestBase {
    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();

    @BeforeEach
    void auth() {
        step("Открыть сайт", () ->
                open(baseUrl));
        step("Открыть сайт", () ->
                loginPage.auth());
    }

    @Test
    @DisplayName("Проверка успешного добавления товара в корзину")
    void addToCardTest() {
        step("Добавить товар в корзину", () ->
                productsPage.clickAddBtn());
        step("Проверить счётчик в корзине", () ->
                productsPage.checkCounter("1"));
    }


    @AfterEach
    void deleteGoods() {
        step("Удалить добавленный товар из корзины", () ->
                productsPage.clickRemoveBtn());
    }

}
