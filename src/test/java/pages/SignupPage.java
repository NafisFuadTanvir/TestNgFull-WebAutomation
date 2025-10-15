package pages;
import configue.UserModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

 public class SignupPage {
    @FindBy(partialLinkText = "Register")
    public WebElement linkRegister;
    @FindBy(id = "firstName")
    WebElement txtFirstName;
    @FindBy(id = "lastName")
    WebElement txtLastName;
    @FindBy(id = "email")
    WebElement txtEmail;
    @FindBy(id = "password")
    WebElement txtPassword;
    @FindBy(id = "phoneNumber")
    WebElement txtPhoneNumber;
    @FindBy(id = "address")
    WebElement txtAddress;
    @FindBy(css = "[type=radio]")
    List<WebElement> checkGender;
    @FindBy(css = "[type=checkbox]")
    WebElement acceptButton;
    @FindBy(id = "register")
    WebElement registerButton;

    public SignupPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void doSignup(UserModel userModel){

        txtFirstName.sendKeys(userModel.getFirstname());
        txtLastName.sendKeys(userModel.getLastname()!=null?userModel.getLastname():"");
        txtEmail.sendKeys(userModel.getEmail());
        txtPassword.sendKeys(userModel.getPassword());
        txtPhoneNumber.sendKeys(userModel.getPhonenumber());
        txtAddress.sendKeys(userModel.getAddress()!=null?userModel.getAddress():"");
        checkGender.get(0).click();
        acceptButton.click();
        registerButton.click();


    }


}
