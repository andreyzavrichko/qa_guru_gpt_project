package com.saucedemo.tests;

import com.saucedemo.TestBase;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

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
    @Story("Products")
    @Feature("Card")
    @Tags({@Tag("products"), @Tag("smoke")})
    @Severity(SeverityLevel.BLOCKER)
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
