package services;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class Gmailservice {
    Properties prop;
    public Gmailservice () throws IOException {
        prop= new Properties();
        FileInputStream fs= new FileInputStream("./src/test/resources/config.properties");
        prop.load(fs);

    }

    public String getGmail() throws IOException {

        RestAssured.baseURI="https://gmail.googleapis.com";
        Response res= given().contentType("application/json").header("Authorization","Bearer "+prop.getProperty("token"))
                .when().get("/gmail/v1/users/me/messages");

      //  System.out.println(res.asString());
        JsonPath jsonObj= res.jsonPath();
        String listId=jsonObj.get("messages[0].id");

        return listId;

    }

    public String getLatestEmail() throws IOException {

        Gmailservice gmailservice= new Gmailservice();
        String messageId= gmailservice.getGmail();

        RestAssured.baseURI="https://gmail.googleapis.com";
        Response res= given().contentType("application/json").header("Authorization","Bearer "+prop.getProperty("token"))
                .when().get("/gmail/v1/users/me/messages/"+messageId);

        //  System.out.println(res.asString());
        JsonPath jsonObj= res.jsonPath();
        String myEmail=jsonObj.get("snippet");

        return myEmail;

    }




    public static void main(String[] args) throws IOException {
        Gmailservice gmailservice= new Gmailservice();
         String myEmail= gmailservice.getLatestEmail();
        System.out.println(myEmail);
    }
}
