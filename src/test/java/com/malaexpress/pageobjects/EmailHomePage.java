package com.malaexpress.pageobjects;

import com.malaexpress.util.WebUtil;
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
        WebUtil.click(driver,By.cssSelector(".gb_8a.gbii"));
         WebUtil.click(driver,By.cssSelector("#gb_71"));
        WebUtil.waitforvisibility(driver,By.cssSelector("#passwordNext > content > span"));

        return PageFactory.initElements(driver,SignInPage.class);
    }

    public boolean isElementExist(WebDriver driver) {
        return WebUtil.isElementExist (driver,By.id("gbqfb"));

    }

    public void clickComposeButton(WebDriver driver) {
        WebUtil.click(driver,By.cssSelector("div[role='button'][gh='cm']"));
    }

    public void fillInRecipient(WebDriver driver, String emailaddress) {
        WebUtil.waitforvisibility(driver,By.cssSelector("textarea[name='to']"));
        WebUtil.clearandsendkeys(driver,By.cssSelector("textarea[name='to']"),emailaddress);

    }

    public void fillInSubject(WebDriver driver, String subject) {
        WebUtil.clearandsendkeys(driver,By.cssSelector("[placeholder='Subject']"),subject);
    }

    public void fillInEmailBody(WebDriver driver, String bodyMessage) {
        WebUtil.waitforvisibility(driver,By.cssSelector ("[aria-label='Message Body'][role='textbox']"));
        WebUtil.clearandsendkeys(driver,By.cssSelector ("[aria-label='Message Body'][role='textbox']"),bodyMessage);
    }

    public void clickSendEmail(WebDriver driver) {
        WebUtil.click(driver,By.cssSelector("div[aria-label *='Send'][class='T-I J-J5-Ji aoO T-I-atl L3']"));
    }

    public void clickInboxWithNewEmail(WebDriver driver) {
       WebUtil.waitandclick(driver,By.partialLinkText("Inbox"));
    }

    public EmailViewPage clickNewEmal(WebDriver driver) {
        WebUtil.waitandclick(driver,By.cssSelector("span[class='bog']"));
        return PageFactory.initElements(driver,EmailViewPage.class);
    }
}
