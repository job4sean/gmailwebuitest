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
    private WebDriverWait wait= new WebDriverWait(driver,300);

  @Test
    public void gmailLoginShouldBeSuccessful(){


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
      WebElement signout = driver.findElement(By.cssSelector(".gb_8a.gbii"));
      signout.click();
      WebElement signoutbutton = driver.findElement(By.cssSelector("#gb_71"));
      signoutbutton.click();
      //verifyed user did sign out
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#passwordNext > content > span")));
      Assert.assertTrue("Sign out does not work",driver.findElements(By.cssSelector("#passwordNext > content > span")).size()>0);
    }
    @Test
    public void gmailSendAndReceiveEmailTest(){

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
       // 2. click compose
        WebElement compose= driver.findElement(By.cssSelector("div[role='button'][gh='cm']"));
        compose.click();
        //3. Fill in recipient
        WebElement recipient =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[name='to']")));
        recipient.clear();
        recipient.sendKeys("vcamera4u@gmail.com");
        //4. fill in subject
        WebElement subjecttextarea =driver.findElement(By.cssSelector("[placeholder='Subject']"));
        final String subject="This is trail email";
        subjecttextarea.clear();
        subjecttextarea.sendKeys(subject);
        //5. fill in email body
        WebElement bodytextarea =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector ("[aria-label='Message Body'][role='textbox']")));
        //WebElement bodytextarea =driver.findElement(By.cssSelector("#\\3a nj"));
        final String body ="nice to meet you ";
        bodytextarea.clear();
        bodytextarea.sendKeys(body);

        //6. click send
       WebElement send =driver.findElement(By.cssSelector("div[aria-label *='Send'][class='T-I J-J5-Ji aoO T-I-atl L3']"));
        send.click();
        //7. click inbox again
       WebElement inboxlink =wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
        inboxlink.click();
        //8. click email
        WebElement titilebutton =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='bog']")));
        titilebutton.click();
        //9. verify the email subject and email body is correct
        WebElement subjectarea = driver.findElement(By.cssSelector("[class='hP']"));
        Assert.assertEquals("Email Subject text should be the same",subject,subjectarea.getText());
        WebElement bodyArea = driver.findElement(By.xpath("//div[contains(@class,'a3s')]/div[1]"));
        Assert.assertEquals("Email Body text should be the same",body,bodyArea.getText());
        //10. sign out
        WebElement signout = driver.findElement(By.cssSelector(".gb_8a.gbii"));
        signout.click();
        WebElement signoutbutton = driver.findElement(By.cssSelector("#gb_71"));
        signoutbutton.click();



    }
      @After
      public void tearDown () throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
      }
}
