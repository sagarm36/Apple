package com.test.utils;

import com.aventstack.extentreports.Status;
import com.test.driver.Driver;
import com.test.driver.DriverManger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionHelper {

    public static void click(By elem){
        DriverManger.getDriver().findElement(elem).click();
        ExtentReport.extentTest.log(Status.PASS, "Clicked on element");
    }

    public static void sendKeys(By ele, String value){
        DriverManger.getDriver().findElement(ele).sendKeys(value);
        ExtentReport.extentTest.log(Status.PASS, "Entered - " + value);
    }

    public void waitForElementClickable(By ele){
        WebDriverWait wait = new WebDriverWait(Driver.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }
}
