package TestRunners;

import com.github.javafaker.Faker;
import configue.Setup;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddiItemPage;
import pages.Loginpage;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;

public class AddItemTestRunner extends Setup{

    @BeforeMethod
    public void userLogin() throws IOException, ParseException {
        Loginpage loginpage= new Loginpage(driver);
        JSONObject userData= Utils.readJsonData("./src/test/resources/users.json");
        String email= userData.get("email").toString();
        String password=userData.get("password").toString();

        loginpage.doLogin(email,password);
    }

    @Test(description = "items can be added properly")
    public void addItemsAndVerify() throws InterruptedException {

      AddiItemPage addiItemPage= new AddiItemPage(driver);
        addiItemPage.btnAddCost.click();
        Faker faker= new Faker();

        String item1 = "ItemFull_" + faker.name().firstName();
        String item2 = "ItemMandatory_" +faker.name().lastName();

        addiItemPage.addItemAllFields(driver, item1, "500", "10/19/2025", "October", "Office Supplies");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        alert.accept();
        Thread.sleep(2000);
        Assert.assertTrue(addiItemPage.isItemVisible(item1), "Item '" + item1 + "' is  visible in the table!");

    }


}
