package testRunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import setup.Setup;

public class LoginPageTestRunner extends Setup {
    WebElement alertTextElem;
    LoginPage loginPage;
    WebElement forgotPasswordLinkElem;

    @Test(priority = 1, description = "Admin can't login with invalid creds")
    public void doLoginIfWrongCreds(){
        loginPage=new LoginPage(driver);
        loginPage.doLogin("wronguser","wrongpass");
        alertTextElem= driver.findElement(By.className("oxd-alert-content-text"));
        Assert.assertEquals(alertTextElem.getText(),"Invalid credentials");
    }

    @Test(priority = 2, description = "Admin can login with valid creds",groups = "smoke")
    public void doLogin(){
        loginPage=new LoginPage(driver);
        loginPage.doLogin("Admin","admin123");
        Assert.assertTrue(loginPage.btnProfileImage.isDisplayed());
    }

    @Test(priority = 3,description = "Admin can logout by clicking on logout button",groups = "smoke")
    public void doLogout(){
        loginPage=new LoginPage(driver);
        loginPage.doLogout();
        forgotPasswordLinkElem=driver.findElement(By.className("orangehrm-login-forgot-header"));
        Assert.assertTrue(forgotPasswordLinkElem.isDisplayed());
    }
}
