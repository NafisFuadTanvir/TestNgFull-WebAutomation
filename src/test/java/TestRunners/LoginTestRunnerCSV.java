package TestRunners;

import configue.LoginDataSet;
import configue.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Loginpage;

import java.time.Duration;

public class LoginTestRunnerCSV extends Setup {

    @Test(dataProvider = "loginDataset",dataProviderClass = LoginDataSet.class,description = "user can login from the csv files")
    public void csvLogin(String email,String password) throws InterruptedException {
        Loginpage loginpage=new Loginpage(driver);
        loginpage.doLogin(email,password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click the profile icon or menu button first (update selector if needed)
        WebElement profileMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".MuiButtonBase-root.MuiIconButton-root")));
        profileMenu.click();

        // Wait and click Logout
        WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[normalize-space()='Logout']")));
        Thread.sleep(500);
        logoutBtn.click();


    }
}
