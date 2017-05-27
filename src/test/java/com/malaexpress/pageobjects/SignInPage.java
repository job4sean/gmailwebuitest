package com.malaexpress.pageobjects;

import com.malaexpress.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Administrator on 2017/5/26 0026.
 */
public class SignInPage {

    public void fillInUsername(WebDriver driver, String username) {
        WebUtil.clearandsendkeys(driver, By.cssSelector("#identifierId"), username);
        WebUtil.click(driver, By.cssSelector("#identifierNext > content > span"));
    }

    public void fillInPassword(WebDriver driver, String password) {
        WebUtil.waitforvisibility(driver, By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        WebUtil.clearandsendkeys(driver, By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"), password);
    }

    public EmailHomePage clickSignIn(WebDriver driver) {
        WebUtil.waitandclick(driver, By.cssSelector("#passwordNext > content > span"));
        WebUtil.waitforvisibility(driver, By.id("gbqfb"));
        return PageFactory.initElements(driver, EmailHomePage.class);
    }

    public boolean isSignInButtonExist(WebDriver driver) {
        return driver.findElements(By.cssSelector("#passwordNext > content > span")).size() > 0;
    }
}
