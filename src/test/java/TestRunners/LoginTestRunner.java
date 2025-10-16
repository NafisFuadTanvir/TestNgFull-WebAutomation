package testrunner;

import configue.Setup;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Dashboardpage;
import pages.Loginpage;
import utils.Utils;

import java.io.IOException;

public class LoginTestRunner extends Setup {
    @Test(priority = 1,description = "check if admin can loginSuccessfully")
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

    @Test(priority = 2,description = "check if user can loginSuccessfully")
    public void userLogin() throws IOException, ParseException {
        Loginpage loginpage= new Loginpage(driver);
        JSONObject userData= Utils.readJsonData("./src/test/resources/users.json");
        String email= userData.get("email").toString();
        String password=userData.get("password").toString();

        loginpage.doLogin(email,password);
    }
}