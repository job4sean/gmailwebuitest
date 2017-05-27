package com.malaexpress.util;

import com.malaexpress.pageobjects.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.PageFactory.*;

/**
 * Created by Administrator on 2017/5/26 0026.
 */
public class WebUtil {
   final static int WAIT_TIME_OUT=30;
    public static SignInPage goToSignInPage(WebDriver driver) {
        driver.get("http://gmail.com");
        return PageFactory.initElements(driver,SignInPage.class);
    }

    public static void click(WebDriver driver, By by) {
        WebElement button = driver.findElement(by);
        button.click();
    }

    public static void waitandclick(WebDriver driver, By inbox) {
        WebDriverWait wait= new WebDriverWait(driver,WAIT_TIME_OUT);
        WebElement inboxlink =wait.until(ExpectedConditions.visibilityOfElementLocated(inbox));
        inboxlink.click();
    }

    public static void waitforvisibility(WebDriver driver, By by) {

        WebDriverWait wait= new WebDriverWait(driver,WAIT_TIME_OUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static boolean isElementExist(WebDriver driver, By by) {
        return driver.findElements(by).size()>0;
    }

    public static void clearandsendkeys(WebDriver driver, By by,String emailaddress) {
        WebDriverWait wait= new WebDriverWait(driver,WAIT_TIME_OUT);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.clear();
        element.sendKeys(emailaddress);

    }

    public static String getText(WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        return element.getText();
    }
}
