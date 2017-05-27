package com.malaexpress.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 2017/5/26 0026.
 */
public class SignInPage {

    public void fillInUsername(WebDriver driver, String username) {
        WebElement usernameTextbox=driver.findElement(By.cssSelector("#identifierId"));
        usernameTextbox.clear();
        usernameTextbox.sendKeys(username);
        WebElement next = driver.findElement(By.cssSelector("#identifierNext > content > span"));
        next.click();
    }

    public void fillInPassword(WebDriver driver, String password) {
        WebDriverWait wait= new WebDriverWait(driver,30);
        WebElement passwordTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")));
        passwordTextbox.clear();
        passwordTextbox.sendKeys(password);
    }

    public EmailHomePage clickSignIn(WebDriver driver) {
        WebDriverWait wait= new WebDriverWait(driver,30);
        WebElement signInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#passwordNext > content > span")));
        signInButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gbqfb")));
        return  PageFactory.initElements(driver,EmailHomePage.class);
    }

    public boolean isSignInButtonExist(WebDriver driver) {
        return driver.findElements(By.cssSelector("#passwordNext > content > span")).size()>0;
    }
}
