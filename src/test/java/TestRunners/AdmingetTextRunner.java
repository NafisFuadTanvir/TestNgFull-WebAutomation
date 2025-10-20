package TestRunners;

import configue.Setup;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Dashboardpage;
import pages.Loginpage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AdmingetTextRunner extends Setup {
    @Test(description = "Admin can login and export all users from user table")
    public  void adminLogin() throws IOException {
        Loginpage loginpage= new Loginpage(driver);
        String adminEmail= System.getProperty("email");
        String adminPassword= System.getProperty("password");
        loginpage.doLogin(adminEmail,adminPassword);

        Dashboardpage dashboardpage= new Dashboardpage(driver);

        List<String> users = dashboardpage.getAllUsers();

        // ✅ Step 4: Write them into a text file (optional secondary file)
        String filePath = System.getProperty("user.dir") + "/users.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

        for (String user : users) {
            writer.write(user);
            writer.newLine();
        }

        writer.close();
        System.out.println("✅ Users exported successfully to: " + filePath);

    }
}
