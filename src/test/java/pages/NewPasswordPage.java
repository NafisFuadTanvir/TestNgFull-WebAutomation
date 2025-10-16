package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewPasswordPage {
    @FindBy(css = "[type=password]")
    List <WebElement> txtNewPassword;
    @FindBy(css = "[type=password]")
    List <WebElement> txtConfirmPassword;

    @FindBy(css="[type=submit]")
    WebElement rstBtn;

    public NewPasswordPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void setNewPassword(String newPassword) {
        txtNewPassword.get(0).sendKeys(newPassword);
        txtConfirmPassword.get(1).sendKeys(newPassword);
        rstBtn.click();
    }
    
}
