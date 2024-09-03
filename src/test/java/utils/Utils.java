package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import setup.EmployeeModel;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static void saveUsers(EmployeeModel model) throws IOException, ParseException {
        String fileLocation="./src/test/resources/users.json";
        JSONParser parser=new JSONParser();//read from file
        JSONArray empArray=(JSONArray) parser.parse(new FileReader(fileLocation));

        //object create
        JSONObject empObj=new JSONObject();
        empObj.put("firstName",model.getFirstName());
        empObj.put("lastName",model.getLastName());
        empObj.put("username",model.getUsername());
        empObj.put("password",model.getPassword());

        empArray.add(empObj);

        FileWriter writer=new FileWriter(fileLocation);
        writer.write(empArray.toJSONString());
        writer.flush();
        writer.close();

    }
    public static JSONArray readJSONData() throws IOException, ParseException {
        String fileLocation="./src/test/resources/users.json";
        JSONParser parser=new JSONParser();//read from file
        JSONArray empArray=(JSONArray) parser.parse(new FileReader(fileLocation));
        return empArray;
    }

    public static void doScroll(WebDriver driver, int scrollValue){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+scrollValue+")");
    }
}
