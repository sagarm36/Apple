package com.test.utils;

import com.aventstack.extentreports.Status;
import com.test.driver.Driver;
import com.test.driver.DriverManger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnersClass implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReport.extentTest.log(Status.INFO,result.getMethod().getMethodName() +" is pass.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String screenshotPath = Screenshoots.takeScreenshot(DriverManger.getDriver(),result.getMethod().getMethodName());
        ExtentReport.extentTest.addScreenCaptureFromPath(screenshotPath,result.getMethod().getMethodName());
        ExtentReport.extentTest.log(Status.INFO,result.getMethod().getMethodName() +" is FAIL.");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        ExtentReport.initialiseReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReport.flushReport();
    }
}
