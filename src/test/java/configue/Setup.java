package configue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import java.time.Duration;


public class Setup {
   public  WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void setup(){
      driver=new EdgeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
      driver.get("https://dailyfinance.roadtocareer.net/");

    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){

        //driver.quit();
    }

}
