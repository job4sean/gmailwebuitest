import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.ExtensionConnection;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/5/24 0024.
 */
public class GmailSignInTest {
    private WebDriver driver= new FirefoxDriver();


  @Test
    public void gmailLoginShouldBeSuccessful(){

      WebDriverWait wait= new WebDriverWait(driver,3);
      //go to Gmail website

        driver.get("http://gmail.com");
        //fill in username
         WebElement usernameTextbox=driver.findElement(By.cssSelector("#identifierId"));
         usernameTextbox.clear();
         usernameTextbox.sendKeys("vcamera4u");
       //  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
       // WebElement next = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#passwd")));
         WebElement next = driver.findElement(By.cssSelector("#identifierNext > content > span"));
      next.click();
      // Fill in password
      //driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
      WebElement passwordTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")));
      passwordTextbox.clear();
      passwordTextbox.sendKeys("Lx9800128");
      //click sign in
      WebElement signInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#passwordNext > content > span")));
      signInButton.click();
      // verify user did sign in
      //driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gbqfb")));
     Assert.assertTrue("Signed in",driver.findElements(By.id("gbqfb")).size()>0);
      //sign out
      WebElement signout = driver.findElement(By.cssSelector("#gb > div.gb_ff.gb_dg > div.gb_ib.gb_dg.gb_R.gb_cg.gb_T > div.gb_rc.gb_dg.gb_R > div.gb_fb.gb_Vc.gb_dg.gb_R > div.gb_Cc.gb_hb.gb_dg.gb_R > a > span"));
      signout.click();
      WebElement signoutbutton = driver.findElement(By.cssSelector("#gb_71"));
      signoutbutton.click();
      //verifyed user did sign out
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#passwordNext > content > span")));
      Assert.assertTrue("Sign out does not work",driver.findElements(By.cssSelector("#passwordNext > content > span")).size()>0);
    }
      @After
      public void tearDown (){
        driver.quit();
      }
}
