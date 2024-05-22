package com.test;

import com.test.driver.Driver;
import com.test.pageobejcts.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public static LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod(){
        Driver.initializeDriver();
         loginPage = new LoginPage();
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitBrowser();
    }
}
