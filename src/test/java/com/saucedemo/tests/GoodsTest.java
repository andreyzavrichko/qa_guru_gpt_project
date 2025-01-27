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

public class GoodsTest extends TestBase {
    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();

    @BeforeEach
    void auth() {
        step("Открыть сайт", () -> open(baseUrl));
        loginPage.auth();
    }

    @Test
    @DisplayName("Успешная авторизация")
    void add111ToCardTest() {
        step("Заполнить логин и пароль", () -> productsPage.openGood());
        step("Проверить переход на главную страницу", () -> productsPage.checkDescriptionGood("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."));
    }



}
