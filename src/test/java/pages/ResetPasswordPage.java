package pages;

import configue.UserModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

import static org.openqa.selenium.By.xpath;

public class ResetPasswordPage {
    @FindBy(partialLinkText = "Reset it here")
    public WebElement linkReset;
    @FindBy(css="[type=email]")
    WebElement txtEmail;
    @FindBy(css = "[type=submit]")
    WebElement resetBtn;
    @FindBy(xpath = "//p[contains(@style,'color: green')]")
    WebElement successMessage;
    @FindBy(xpath = "//p[contains(@style,'color: red')]")
    WebElement errorMessage;


    public ResetPasswordPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

  public void resetPassword(UserModel userModel){
        txtEmail.clear();
        txtEmail.sendKeys(userModel.getEmail());
        resetBtn.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }


}
