package TestRunners;

import configue.Setup;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Loginpage;
import pages.UserprofilePage;
import utils.Utils;

import java.io.IOException;

public class UserprofilePageRunner extends Setup {

    @BeforeMethod
    public void userLogin() throws IOException, ParseException {
        Loginpage loginpage= new Loginpage(driver);
        JSONObject userData= Utils.readJsonData("./src/test/resources/users.json");
        String email= userData.get("email").toString();
        String password=userData.get("password").toString();

        loginpage.doLogin(email,password);
    }

    @Test(description = "user can update email properly")
    public void updateEmail() throws InterruptedException {
        Thread.sleep(5000);
        driver.navigate().to("https://dailyfinance.roadtocareer.net/user/5b54edbf-dee3-469e-97e3-29a291e4fd1d");
        UserprofilePage userprofilePage=new UserprofilePage(driver);
        String email="nafisf026+9548537@gmail.com";
        userprofilePage.updateprofile(email,driver);

    }
}
