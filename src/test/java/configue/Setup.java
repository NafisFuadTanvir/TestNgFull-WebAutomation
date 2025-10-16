package configue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;


public class Setup {
   public  WebDriver driver;
    @BeforeTest
    public void setup(){
      driver=new EdgeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
      driver.get("https://dailyfinance.roadtocareer.net/");

    }

    @AfterTest
    public void tearDown(){

        //driver.quit();
    }

}
