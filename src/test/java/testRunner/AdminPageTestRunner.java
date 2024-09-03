package testRunner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;
import setup.Setup;


import java.io.IOException;


import static utils.Utils.readJSONData;


public class AdminPageTestRunner extends Setup {
    LoginPage loginPage;
    AdminPage adminPage;

    @BeforeTest(groups = "smoke")
    public void doLogin(){
        loginPage=new LoginPage(driver);
        loginPage.doLogin("Admin","admin123");
    }

    @Test(priority = 1, description = "Search User with invalid Info")
    public void searchUserInfoWithInvalidInfo() throws InterruptedException {
        adminPage=new AdminPage(driver);
        adminPage.searchUserInfoWithInvalidInfo();
        Thread.sleep(7000);
        String messageActual=driver.findElements(By.className("oxd-text--span")).get(12).getText();
        String messageExpected="No Records Found";
        Assert.assertTrue(messageActual.contains(messageExpected));
    }

    @Test(priority = 2, description = "Search User Valid Info", groups = "smoke")
    public void searchUserInfo() throws InterruptedException, IOException, ParseException {
        adminPage=new AdminPage(driver);
        adminPage.searchUserInfo();
        Thread.sleep(7000);
        String messageActual=driver.findElements(By.className("oxd-text--span")).get(12).getText();
        String messageExpected="Record Found";
        Assert.assertTrue(messageActual.contains(messageExpected));
    }

    @Test(priority = 3, description = "Search User From Directory", groups = "smoke")
    public void searchUserInfoFromDirectory() throws InterruptedException, IOException, ParseException {
        adminPage=new AdminPage(driver);
        adminPage.searchUserInfoFromDirectory();
        Thread.sleep(7000);
        String messageActual=driver.findElements(By.className("oxd-text--span")).get(12).getText();
        String messageExpected = "Record Found";
        //System.out.println(messageActual);
        Assert.assertTrue(messageActual.contains(messageExpected));
    }

    @Test(priority = 4, description = "Admin Logout", groups = "smoke")
    public void doLogout() throws InterruptedException {
        adminPage=new AdminPage(driver);
        adminPage.doLogout();
    }
    @Test(priority = 5, description ="Login with invalid User Info")
    public void doLoginWithInvalidUserCred(){
        loginPage=new LoginPage(driver);
        loginPage.doLoginWithInvalidCreds("InvalidUser","InvalidPassword");
    }
    @Test(priority = 6, description ="Login with valid User Info & Show FullName",groups = "smoke")
    public void doLoginWithNewUser() throws IOException, ParseException, InterruptedException {
        loginPage=new LoginPage(driver);

        JSONArray empArray=readJSONData();
        JSONObject empObject=(JSONObject) empArray.get(empArray.size()-1);
        String username=empObject.get("username").toString();
        String password=empObject.get("password").toString();
        Thread.sleep(5000);
        loginPage.doLogin(username,password);//login with last data

        String firstName=empObject.get("firstName").toString();
        String lastName=empObject.get("lastName").toString();
        String fullName=firstName+" "+lastName;

        String messageActual = driver.findElement(By.className("oxd-userdropdown-name")).getText();
        String messageExpected = fullName;

        Assert.assertTrue(messageActual.contains(messageExpected));

    }

    @Test(priority = 7, description = "Select Gender and Blood Group as O+ and logout", groups = "smoke")
    public void userContactInfoUpdate() throws InterruptedException {
        adminPage=new AdminPage(driver);
        Thread.sleep(5000);
        adminPage.userContactInfoUpdate(driver);
        adminPage.doLogout();
    }
}
