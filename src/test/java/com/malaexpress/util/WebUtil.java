package com.malaexpress.util;

import com.malaexpress.pageobjects.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.PageFactory.*;

/**
 * Created by Administrator on 2017/5/26 0026.
 */
public class WebUtil {
    public static SignInPage goToSignInPage(WebDriver driver) {
        driver.get("http://gmail.com");
        return PageFactory.initElements(driver,SignInPage.class);
    }
}
