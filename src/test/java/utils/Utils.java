package utils;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public  class Utils {

    public static int generateRandom(int min,int max){
        double randomId= Math.random()*(max-min)+min;
        return (int)randomId;

    }
    public static void scroll(WebDriver driver,int px){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,"+px+")");
    }

    public static void saveJsonData(JSONObject jsonObject, String filepath) throws IOException, ParseException {
        JSONParser jsonparser= new JSONParser();
        JSONArray jsonArray= (JSONArray) jsonparser.parse(new FileReader(filepath));
        jsonArray.add(jsonObject);

        FileWriter fileWriter= new FileWriter(filepath);
        fileWriter.write(jsonArray.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    }

    public  static JSONObject  readJsonData(String filepath) throws IOException, ParseException {
        JSONParser jsonParser= new JSONParser();
        JSONArray jsonArray= (JSONArray) jsonParser.parse(new FileReader(filepath));

        JSONObject jsonObject= (JSONObject) jsonArray.get(jsonArray.size()-1);

        return jsonObject;
    }

}
