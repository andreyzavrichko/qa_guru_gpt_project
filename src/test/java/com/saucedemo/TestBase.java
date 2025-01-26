package com.saucedemo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.saucedemo.config.Project;
import com.saucedemo.helpers.AllureAttachments;
import com.saucedemo.helpers.DriverSettings;
import com.saucedemo.helpers.DriverUtils;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({AllureJunit5.class})
public class TestBase {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
        Configuration.baseUrl = "https://www.saucedemo.com";
    }

    @AfterEach
    public void addAttachments() {
//        String sessionId = DriverUtils.getSessionId();
//
//        AllureAttachments.addScreenshotAs("Last screenshot");
//        AllureAttachments.addPageSource();
//        Selenide.closeWebDriver();
//
//        if (Project.isVideoOn()) {
//            AllureAttachments.addVideo(sessionId);
//        }
    }
}