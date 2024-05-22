package com.test.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshoots {

    public static String takeScreenshot(WebDriver driver, String testCaseName){
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        File destinationFile = new File(System.getProperty("user.dir")+"screenshoots/"+testCaseName+".png");
        File scr = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scr,destinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return System.getProperty("user.dir")+"/screenshoots/"+testCaseName+".png";

    }
}
