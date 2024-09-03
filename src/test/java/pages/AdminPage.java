package pages;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

import java.io.IOException;
import java.util.List;

import static utils.Utils.readJSONData;


public class AdminPage {
    //Menu List
    @FindBy(className = "oxd-main-menu-item--name")
    public List<WebElement> leftMenubar;

    @FindBy(className = "oxd-input")
    public List <WebElement> textField;

    @FindBy(className = "oxd-button")
    public List <WebElement> btn;

    @FindBy(xpath = "//input")
    public List <WebElement> directoryTextField;

    @FindBy(className = "oxd-userdropdown-img")
    public WebElement btnProfileImage;

    @FindBy(css="[role=menuitem]")
    List<WebElement> dropdownMenu;

    @FindBy(tagName = "label")
    List<WebElement> genderSelection;

    @FindBy(className = "oxd-select-text-input")
    public List<WebElement> bloodGroup;

    public AdminPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void searchUserInfoWithInvalidInfo() throws InterruptedException {
        leftMenubar.get(0).click();
        textField.get(1).sendKeys("invalid999");
        Thread.sleep(1000);
        btn.get(1).click();
    }

    public void searchUserInfo() throws InterruptedException, IOException, ParseException {
        leftMenubar.get(0).click();
        JSONArray empArray=readJSONData();
        JSONObject empObject=(JSONObject) empArray.get(empArray.size()-1);
        String username = empObject.get("username").toString();
        textField.get(1).sendKeys(username);
        Thread.sleep(7000);
        btn.get(1).click();
    }

    public void searchUserInfoFromDirectory() throws IOException, ParseException, InterruptedException {
        leftMenubar.get(8).click();
        JSONArray empArray=readJSONData();
        JSONObject empObject=(JSONObject) empArray.get(empArray.size()-1);
        String firstname = empObject.get("firstName").toString();
        Thread.sleep(1000);
        directoryTextField.get(1).sendKeys(firstname);
        Thread.sleep(3000);
        directoryTextField.get(1).sendKeys(Keys.ARROW_DOWN);
        directoryTextField.get(1).sendKeys(Keys.ENTER);
        btn.get(1).click();
    }

    public void doLogout() throws InterruptedException {
        Thread.sleep(500);
        btnProfileImage.click();//profile click
        Thread.sleep(500);
        dropdownMenu.get(3).click();//dropdown to logout select
    }

    public void userContactInfoUpdate(WebDriver driver) throws InterruptedException {
        leftMenubar.get(2).click();
        Thread.sleep(5000);
        genderSelection.get(9).click();
        Thread.sleep(3000);
        btn.get(0).click();
        Utils.doScroll(driver, 550);
        Thread.sleep(3000);
        bloodGroup.get(2).click();
        Thread.sleep(5000);
        bloodGroup.get(2).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        bloodGroup.get(2).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        bloodGroup.get(2).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        bloodGroup.get(2).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        bloodGroup.get(2).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        bloodGroup.get(2).sendKeys(Keys.ENTER);
        Thread.sleep(500);
        btn.get(1).click();

    }
}
