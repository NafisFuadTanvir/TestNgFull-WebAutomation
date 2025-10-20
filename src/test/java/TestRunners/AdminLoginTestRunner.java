package TestRunners;

import configue.Setup;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Dashboardpage;
import pages.Loginpage;

public class AdminLoginTestRunner extends Setup {

    @Test(description = "admin can login successfully from the cli")
    public  void adminLogin(){
        Loginpage loginpage= new Loginpage(driver);
        String adminEmail= System.getProperty("email");
        String adminPassword= System.getProperty("password");
        loginpage.doLogin(adminEmail,adminPassword);

        Dashboardpage dashboardpage= new Dashboardpage(driver);
        Assert.assertEquals(dashboardpage.btnUserprofileIcon.get(0).isDisplayed(),true);
        String headerActual=driver.findElement(By.tagName("h2")).getText();
        String headerExpected="Admin Dashboard";
        Assert.assertEquals(headerActual,headerExpected);


    }
    }

