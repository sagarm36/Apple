package com.test.driver;

import com.test.constants.FrameWorkConstants;
import com.test.utils.ReadProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public final class Driver {

    private Driver() {
    }

    public static WebDriver driver;

    public static void initializeDriver() {
        driver = new ChromeDriver();
        DriverManger.setDriver(driver);
        driver.get(ReadProperty.getValue("url" ));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameWorkConstants.implicit_wait));
    }

    public static void quitBrowser() {
        driver.quit();
    }

}
