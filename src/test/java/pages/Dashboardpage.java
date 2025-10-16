package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Dashboardpage {

    @FindBy(css = "[type=submit]")
    public List<WebElement> btnUserprofileIcon;

    public  Dashboardpage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

}