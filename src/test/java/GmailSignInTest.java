import com.malaexpress.pageobjects.EmailHomePage;
import com.malaexpress.pageobjects.EmailViewPage;
import com.malaexpress.pageobjects.SignInPage;
import com.malaexpress.util.WebUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 2017/5/24 0024.
 */
public class GmailSignInTest {
    private WebDriver driver= new FirefoxDriver();
    private WebDriverWait wait= new WebDriverWait(driver,300);

  @Test
    public void gmailLoginShouldBeSuccessful(){


      //go to Gmail website
        SignInPage signInPage = WebUtil.goToSignInPage(driver);

        //fill in username
      signInPage.fillInUsername(driver,"vcamera4u");

       //  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
       // WebElement next = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#passwd")));

      // Fill in password
      //driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
      signInPage.fillInPassword(driver,"Lx9800128");

      //click sign in
      EmailHomePage emailHomePage = signInPage.clickSignIn(driver);

      // verify user did sign in
      //driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
      Assert.assertTrue("Sign in does not work",emailHomePage.isElementExist(driver));

      //sign out
      signInPage=emailHomePage.signOut(driver);

      //verifyed user did sign out


      Assert.assertTrue("Sign out does not work",signInPage.isSignInButtonExist(driver));
    }
    @Test
    public void gmailSendAndReceiveEmailTest(){

        //go to Gmail website
        final String bodyMessage ="nice to meet you ";
         final String subject="This is trail email";
        SignInPage signInPage = WebUtil.goToSignInPage(driver);
        //fill in username
        signInPage.fillInUsername(driver,"vcamera4u");
        //  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        // WebElement next = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#passwd")));

        // Fill in password
        //driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        signInPage.fillInPassword(driver,"Lx9800128");
        //click sign in
        EmailHomePage emailHomePage = signInPage.clickSignIn(driver);
        // verify user did sign in
        //driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

       // 2. click compose
        emailHomePage.clickComposeButton(driver);

        //3. Fill in recipient
        emailHomePage.fillInRecipient(driver,"vcamera4u@gmail.com");

        //4. fill in subject
        emailHomePage.fillInSubject(driver,subject);

        //5. fill in email body
        emailHomePage.fillInEmailBody(driver,bodyMessage);


        //6. click send
        emailHomePage.clickSendEmail(driver);

        //7. click inbox again
        emailHomePage.clickInboxWithNewEmail(driver);

        //8. click email
        EmailViewPage emailViewPage = emailHomePage.clickNewEmal(driver);

        //9. verify the email subject and email body is correct
        String actualSubject = emailViewPage.getEmailSubjectText(driver);

        Assert.assertEquals("Email Subject text should be the same",subject,actualSubject);
        String actualEmailBody= emailViewPage.getEmailBodyText(driver);

        Assert.assertEquals("Email Body text should be the same",bodyMessage,actualEmailBody);
        //10. sign out
        signInPage=emailHomePage.signOut(driver);


    }
      @After
      public void tearDown () throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
      }
}
