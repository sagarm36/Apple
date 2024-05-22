package com.test.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    public static void initialiseReport(){
        extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("index.html");
        extentReports.attachReporter(sparkReporter);
        sparkReporter.config().setDocumentTitle("Sagar Automation");
        sparkReporter.config().setReportName("Sarogar");
        sparkReporter.config().setTheme(Theme.STANDARD);
    }

    public static void flushReport(){
        extentReports.flush();
    }

    public static void createTest(String testCaseName){
        extentTest = extentReports.createTest(testCaseName);
    }
}
