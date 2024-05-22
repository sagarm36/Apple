package com.test.driver;

import org.openqa.selenium.WebDriver;

public class DriverManger {

    private DriverManger(){

    }

    private static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void setDriver(WebDriver driverref) {
        dr.set(driverref);
    }
}
