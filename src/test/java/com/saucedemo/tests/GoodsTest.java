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
    @Story("Store")
    @Feature("Goods")
    @Tags({@Tag("goods"), @Tag("smoke")})
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка успешного открытия карточки товара")
    void openCardGoodTest() {
        step("Открыть карточку товара", () ->
                productsPage.openGood());
        step("Проверить переход на карточку товара", () ->
                productsPage.checkDescriptionGood("carry.allTheThings() with the sleek, streamlined Sly Pack " +
                        "that melds uncompromising style with unequaled laptop and tablet protection."));
    }



}
