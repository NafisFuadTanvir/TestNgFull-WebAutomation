package TestRunners;

import configue.Setup;
import configue.UserModel;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Loginpage;
import pages.NewPasswordPage;
import pages.ResetPasswordPage;
import services.Gmailservice;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;

public class ResetPasswordTestRunner extends Setup {

   // @Test(priority = 1, description = "Unregistered email should show:-Your email is not registered ")
    public void unregisteredEmail(){
        ResetPasswordPage resetPasswordPage=new ResetPasswordPage(driver);
        resetPasswordPage.linkReset.click();
        UserModel userModel=new UserModel();

       userModel.setEmail("notregistered123@gmail.com");
       resetPasswordPage.resetPassword(userModel);

       String expectedMsg = "Your email is not registered";
       Assert.assertTrue(resetPasswordPage.getErrorMessage().contains(expectedMsg),
               "Your email is not registered");
    }


    @Test(priority = 2, description = "Reset password with registered Gmail and login with new password")
    public void sendResetLinkWithRegisteredEmail() throws IOException, InterruptedException {
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);


        resetPasswordPage.linkReset.click();

        UserModel userModel = new UserModel();
        userModel.setEmail("nafisf026+5037855@gmail.com");
        resetPasswordPage.resetPassword(userModel);


        String expectedMsg = "Password reset link sent to your email"; // check actual message
        Assert.assertTrue(resetPasswordPage.getSuccessMessage().contains(expectedMsg),
                "Password reset link sent to your email");

        Gmailservice gmailService = new Gmailservice();
        String latestEmailSnippet = gmailService.getLatestEmail();

        String resetUrl = gmailService.extractResetLink(latestEmailSnippet);
        System.out.println("🔗 Extracted Reset URL: " + resetUrl);

        // Step 4️⃣ — Open reset link and set new password
        driver.get(resetUrl);

      NewPasswordPage newPasswordPage = new NewPasswordPage(driver);
        String newPassword = "NewSecurePass123";
        newPasswordPage.setNewPassword(newPassword);
        Thread.sleep(1000);
        Assert.assertTrue(driver.getPageSource().contains("Password reset successfully"),
                "Password reset successfully");

        Loginpage loginPage = new Loginpage(driver);
        loginPage.doLogin(userModel.getEmail(), newPassword);

        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard") ||
                        driver.getPageSource().contains("Dashboard"),
                "Login failed with the new password!");




    }




    }


