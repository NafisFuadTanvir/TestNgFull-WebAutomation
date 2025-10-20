package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UserprofilePage {

    @FindBy(xpath = "//li[text()='Profile']")
    WebElement txtProfilebtn1;
    @FindBy(css = "[type=button]")
    List<WebElement> editbtn1;

    @FindBy(name = "email")
    WebElement txtEmail;

    @FindBy(xpath = "//button[normalize-space()='Update']")
    WebElement updatebtn;



    public UserprofilePage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    public void updateprofile(String email, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(txtEmail));
        txtEmail.clear();
        txtEmail.sendKeys(email);

        wait.until(ExpectedConditions.elementToBeClickable(updatebtn));
        updatebtn.click(); // or use JS click if still not interactable
    }
}


