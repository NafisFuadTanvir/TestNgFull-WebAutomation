package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class AddiItemPage {

    @FindBy(css = ".add-cost-button")
    public WebElement btnAddCost;
    @FindBy(id = "itemName")
    public WebElement txtItemName;
    @FindBy(css = "[type=button]")
    List <WebElement> btnIncrement;
    @FindBy(id="amount")
    WebElement txtAmount;
    @FindBy(id = "purchaseDate")
    WebElement txtDate;
    @FindBy(id="month")
    WebElement txtMonth;
    @FindBy(id = "remarks")
    WebElement txtRemarks;
    @FindBy(className = "submit-button")
    WebElement btnSubmit;

    @FindBy(css = "table tbody tr")
    public List<WebElement> itemRows;


    public AddiItemPage(WebDriver driver){
        PageFactory.initElements(driver,this);


    }
    public void addItemAllFields(WebDriver driver, String name, String amount, String date, String month, String remarks) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(txtItemName));

        txtItemName.clear();
        txtItemName.sendKeys(name);

        btnIncrement.get(2).click();

        txtAmount.clear();
        txtAmount.sendKeys(amount);

        txtDate.clear();
        txtDate.sendKeys(date);

        txtMonth.sendKeys(month);

        txtRemarks.clear();
        txtRemarks.sendKeys(remarks);

        btnSubmit.click();
    }

    public void addItemMandatory(WebDriver driver, String name, String amount) {
        // Wait until the item name input is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(txtItemName));

        txtItemName.clear();
        txtItemName.sendKeys(name);

        txtAmount.clear();
        txtAmount.sendKeys(amount);

        btnSubmit.click();
    }
    // Get total count of items
    public int getItemCount() {
        return itemRows.size();
    }

    // Check if a specific item name is visible
    public boolean isItemVisible(String itemName) {
        for (WebElement row : itemRows) {
            if (row.getText().contains(itemName)) {
                return true;
            }
        }
        return false;
    }


}

