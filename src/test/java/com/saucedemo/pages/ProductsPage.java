package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {
    SelenideElement
            addButton = $("#add-to-cart-sauce-labs-backpack"),
            goodsTitle = $("#item_4_title_link"),
            removeButton = $("#remove-sauce-labs-backpack"),
            descriptionGood = $(".inventory_details_desc"),
            cartButton = $(".shopping_cart_container"),
            checkoutButton = $("#checkout"),
            counter = $(".shopping_cart_badge");


    public ProductsPage clickAddBtn() {
        addButton.click();
        return this;
    }

    public void clickRemoveBtn() {
        removeButton.click();
    }

    public ProductsPage clickCartBtn() {
        cartButton.click();
        return this;
    }

    public void clickCheckoutBtn() {
        checkoutButton.click();
    }

    public ProductsPage openGood() {
        goodsTitle.click();
        return this;
    }

    public ProductsPage checkCounter(String value) {
        counter.shouldHave(text(value));
        return this;
    }

    public ProductsPage checkDescriptionGood(String value) {
        descriptionGood.shouldHave(text(value));
        return this;
    }


}
