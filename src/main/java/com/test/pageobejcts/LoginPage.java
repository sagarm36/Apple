package com.test.pageobejcts;

import com.aventstack.extentreports.Status;
import com.test.driver.Driver;
import com.test.utils.ActionHelper;
import com.test.utils.ExtentReport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class LoginPage {

    By loginIcon = By.xpath("//span[@title='Login']");
    By userNameTextField = By.id("login-email");
    By passwordTextField = By.id("login-password");
    By loginButton = By.xpath("//button[text()='LOGIN']");
    By linksInHomePage = By.tagName("a");

    public void findBrokenLinks() {
        List<WebElement> links = Driver.driver.findElements(linksInHomePage);
        System.out.println("Size of links is - "+links.size());
        for (int i = 0; i < links.size(); i++) {
            String url = links.get(i).getAttribute("href");
            System.out.println(url);
            try {
                URL u = new URL(url);
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) u.openConnection();
                httpsURLConnection.connect();
                if (httpsURLConnection.getResponseCode() < 400) {
                    System.out.println(httpsURLConnection.getResponseMessage());
                } else {
                    System.out.println("Broken link - "+httpsURLConnection.getResponseMessage());
                }
            }catch (Exception e){

            }
        }
    }

    public void clickOnLoginIcon() {
        WebDriverWait wait = new WebDriverWait(Driver.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginIcon));
        ActionHelper.click(loginIcon);
    }

    public void enterUserName(String userName) {
        ActionHelper.sendKeys(userNameTextField,userName);
        //ExtentReport.extentTest.log(Status.PASS, "Entered username as - " + userName);
    }

    public void enterPassword(String password) {
       ActionHelper.sendKeys(passwordTextField,password);
       // ActionHelper.sendKeys(passwordTextField,password);
        //Driver.driver.findElement(passwordTextField).sendKeys(password);
        //ExtentReport.extentTest.log(Status.PASS, "Entered password as - " + password);
    }

    public void clickOnLoginButton() {
       ActionHelper.click(loginButton);
    }

}
