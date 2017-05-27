package com.malaexpress.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Administrator on 2017/5/26 0026.
 */
public class EmailViewPage {
    public String getEmailSubjectText(WebDriver driver) {
        WebElement subjectarea = driver.findElement(By.cssSelector("[class='hP']"));
        return subjectarea.getText();
    }

    public String getEmailBodyText(WebDriver driver) {

        WebElement bodyArea = driver.findElement(By.xpath("//div[contains(@class,'a3s')]/div[1]"));
        return bodyArea.getText();
    }
}
