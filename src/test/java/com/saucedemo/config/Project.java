package com.saucedemo.config;

import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    public static boolean isWebMobile() {
        return !config.browserMobileView().isEmpty();
    }

    public static boolean isRemoteWebDriver() {
        return !config.remoteDriverUrl().isEmpty();
    }

    public static boolean isVideoOn() {
        return !config.videoStorage().isEmpty();
    }
}
