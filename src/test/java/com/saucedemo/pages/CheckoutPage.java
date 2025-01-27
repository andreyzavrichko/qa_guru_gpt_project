package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {
    SelenideElement
            firstNameInput = $("#first-name"),
            lastNameInput = $("#last-name"),
            postalInput = $("#postal-code"),
            continueButton = $("#continue"),
            errorCheckout = $("h3[data-test='error']"),
            shippingInfo = $("[data-test=shipping-info-value]");


    public CheckoutPage firstNameType(String firstName) {
        firstNameInput.type(firstName);
        return this;
    }

    public CheckoutPage lastNameType(String lastName) {
        lastNameInput.type(lastName);
        return this;
    }

    public CheckoutPage postalType(String postal) {
        postalInput.type(postal);
        return this;
    }

    public CheckoutPage clickContinueBtn() {
        continueButton.click();
        return this;
    }

    public CheckoutPage checkErrorCheckout(String value) {
        errorCheckout.shouldHave(text(value));

        return this;
    }

    public CheckoutPage checkShippingInfo(String value) {
        shippingInfo.shouldHave(text(value));

        return this;
    }


}
