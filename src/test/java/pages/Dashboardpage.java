package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dashboardpage {
    WebDriver driver;

    @FindBy(css = "[type=submit]")
    public List<WebElement> btnUserprofileIcon;

    public  Dashboardpage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    // ✅ Get all users from table and return as List<String>
    public List<String> getAllUsers() throws IOException {
        List<String> users = new ArrayList<>();

        // ✅ Locate the table
        WebElement table = driver.findElement(By.tagName("table"));

        // ✅ Locate all table rows inside tbody
        List<WebElement> allRows = table.findElements(By.cssSelector("tbody tr"));

        // ✅ File path to save scraped data
        String filePath = "./src/test/resources/ScrapedData.txt";
        FileWriter writer = new FileWriter(filePath);

        // ✅ Loop through rows and extract data
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            StringBuilder rowData = new StringBuilder();

            for (WebElement cell : cells) {
                rowData.append(cell.getText()).append(" | ");
            }

            // Save to list and file
            users.add(rowData.toString());
            writer.write(rowData + "\n");
        }

        writer.close();
        System.out.println("✅ User data saved to: " + filePath);
        return users;
    }

}