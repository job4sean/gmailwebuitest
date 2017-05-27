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
public class EmailHomePage {

    public SignInPage signOut(WebDriver driver) {
        WebElement signout = driver.findElement(By.cssSelector(".gb_8a.gbii"));
        signout.click();
        WebElement signoutbutton = driver.findElement(By.cssSelector("#gb_71"));
        signoutbutton.click();
        WebDriverWait wait= new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#passwordNext > content > span")));
        return PageFactory.initElements(driver,SignInPage.class);
    }

    public boolean isElementExist(WebDriver driver) {
        return driver.findElements(By.id("gbqfb")).size()>0;
    }

    public void clickComposeButton(WebDriver driver) {
        WebElement compose= driver.findElement(By.cssSelector("div[role='button'][gh='cm']"));
        compose.click();
    }

    public void fillInRecipient(WebDriver driver, String emailaddress) {
        WebDriverWait wait= new WebDriverWait(driver,30);
        WebElement recipient =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[name='to']")));
        recipient.clear();
        recipient.sendKeys(emailaddress);
    }

    public void fillInSubject(WebDriver driver, String subject) {
        WebElement subjecttextarea =driver.findElement(By.cssSelector("[placeholder='Subject']"));
        subjecttextarea.clear();
        subjecttextarea.sendKeys(subject);
    }

    public void fillInEmailBody(WebDriver driver, String bodyMessage) {
        WebDriverWait wait= new WebDriverWait(driver,30);
        WebElement bodytextarea =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector ("[aria-label='Message Body'][role='textbox']")));
         bodytextarea.clear();
        bodytextarea.sendKeys(bodyMessage);
    }

    public void clickSendEmail(WebDriver driver) {
        WebElement send =driver.findElement(By.cssSelector("div[aria-label *='Send'][class='T-I J-J5-Ji aoO T-I-atl L3']"));
        send.click();
    }

    public void clickInboxWithNewEmail(WebDriver driver) {
        WebDriverWait wait= new WebDriverWait(driver,30);
        WebElement inboxlink =wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
        inboxlink.click();
    }

    public EmailViewPage clickNewEmal(WebDriver driver) {
        WebDriverWait wait= new WebDriverWait(driver,30);
        WebElement titilebutton =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='bog']")));
        titilebutton.click();
        return PageFactory.initElements(driver,EmailViewPage.class);
    }
}
