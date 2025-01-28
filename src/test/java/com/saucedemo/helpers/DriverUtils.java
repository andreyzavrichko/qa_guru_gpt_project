package com.saucedemo.helpers;


import com.codeborne.selenide.Selenide;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;


public class DriverUtils {
    public static final Logger LOGGER = LoggerFactory.getLogger(DriverUtils.class);


    public static byte[] getScreenshotAsBytes() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public static byte[] getPageSourceAsBytes() {
        return Objects.requireNonNull(getWebDriver().getPageSource()).getBytes(StandardCharsets.UTF_8);
    }

    public static String getConsoleLogs() {
        return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
    }


}
