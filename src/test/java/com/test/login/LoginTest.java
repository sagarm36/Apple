package com.test.login;

import com.test.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke,regression"},enabled = true)
    public void Login_01() throws InterruptedException {
        Thread.sleep(3000);
        loginPage.findBrokenLinks();
        loginPage.clickOnLoginIcon();
    }

    @Test
    public void Login_02() {
        loginPage.clickOnLoginIcon();
        loginPage.enterUserName("sagar.muttappanavar@gmail.com");
        loginPage.enterPassword("8618228856");
        loginPage.clickOnLoginButton();
    }

}
