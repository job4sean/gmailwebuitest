package com.malaexpress.pageobjects;

import com.malaexpress.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.malaexpress.util.WebUtil.*;

/**
 * Created by Administrator on 2017/5/26 0026.
 */
public class EmailViewPage {
    public String getEmailSubjectText(WebDriver driver) {
        return WebUtil.getText(driver,By.cssSelector("[class='hP']"));

    }

    public String getEmailBodyText(WebDriver driver) {
        return WebUtil.getText(driver,By.xpath("//div[contains(@class,'a3s')]/div[1]"));

    }
}
