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

@DisplayName("Goods Tests")
public class GoodsTest extends TestBase {
    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();

    @BeforeEach
    void auth() {
        step("Открыть сайт", () ->
                open(baseUrl));
        step("Авторизоваться", () ->
                loginPage.auth());
    }

    @Test
    @DisplayName("Проверка успешного открытия карточки товара")
    void openCardGoodTest() {
        step("Открыть карточку товара", () ->
                productsPage.openGood());
        step("Проверить переход на карточку товара", () ->
                productsPage.checkDescriptionGood("carry.allTheThings() with the sleek, streamlined Sly Pack " +
                        "that melds uncompromising style with unequaled laptop and tablet protection."));
    }



}
