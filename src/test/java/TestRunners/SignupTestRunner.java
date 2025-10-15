package TestRunners;

import com.github.javafaker.Faker;
import configue.Setup;
import configue.UserModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignupPage;
import services.Gmailservice;
import utils.Utils;

import java.io.IOException;

public class SignupTestRunner extends Setup {

    @Test
    public void runSignupTest() throws IOException, ParseException {
        SignupPage signuppage= new SignupPage(driver);
        Gmailservice gmailservice=new Gmailservice();
        Utils.scroll(driver,500);
        signuppage.linkRegister.click();

        Faker faker= new Faker();
        String firstname=faker.name().firstName();
        String lastname=faker.name().lastName();
        String email = "nafisf026+"+Utils.generateRandom(1000000,9999999)+"@gmail.com";
        String password="1234";
        String phonenumber="0130"+ Utils.generateRandom(1000000,9999999);
        String address=faker.country().capital();

        UserModel userModel=new UserModel();
        userModel.setFirstname(firstname);
        userModel.setLastname(lastname);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhonenumber(phonenumber);
        userModel.setAddress(address);
        signuppage.doSignup(userModel);


        JSONObject jsonObject= new JSONObject();
        jsonObject.put("firstname",firstname);
        jsonObject.put("lastname",lastname);
        jsonObject.put("email",email);
        jsonObject.put("password",password);

        try {
            Utils.saveJsonData(jsonObject,"./src/test/resources/users.json");
            System.out.println("Data Saved Successfully");
            Thread.sleep(500);
            String myEmail=gmailservice.getLatestEmail();
            System.out.println(myEmail);

            Assert.assertTrue(myEmail.contains(" Welcome to our platform!"));
        }
        catch (Exception e){
            System.out.println("not saved"+e);

        }
    }


}
