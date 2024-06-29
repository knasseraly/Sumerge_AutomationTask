import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Testcases {
    public EdgeDriver driver;
    public Methods methods;
    public Data data;

    @BeforeMethod
    public void init() {
        driver = new EdgeDriver();
        methods = new Methods(driver);
        data = new Data();
        System.setProperty("webdriver.edge.driver", "driver\\msedgedriver.exe");
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void CheckLoginFields() {

      String userNameField = methods.checkUsername(driver);
      String passwordField = methods.checkPassword(driver);
      String loginField = methods.checkLoginBtn(driver);


        Assert.assertEquals(userNameField,"user-name");
        Assert.assertEquals(passwordField,"password");
        Assert.assertEquals(loginField,"login-button");

    }

    @Test
    public void LoginWithValidCredentials() {

methods.enterusername(data.Valid_username,driver);
methods.enterpassword(data.Valid_password,driver);
methods.clicklogin(driver);
    }

    @Test
    public void LoginWithInvalidUsername() {

        methods.enterusername(data.Invalid_username, driver);
        methods.enterpassword(data.Valid_password, driver);
        methods.clicklogin(driver);
        String message = String.valueOf(methods.getErrorMessage(driver));
        Assert.assertEquals(message,"Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void LoginWithInvalidPassword() {

        methods.enterusername(data.Valid_username, driver);
        methods.enterpassword(data.Invalid_password, driver);
        methods.clicklogin(driver);
        String message = String.valueOf(methods.getErrorMessage(driver));
        Assert.assertEquals(message,"Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void LoginWithInvalidCredentials() {

        methods.enterusername(data.Invalid_username, driver);
        methods.enterpassword(data.Invalid_password, driver);
        methods.clicklogin(driver);
        String message = String.valueOf(methods.getErrorMessage(driver));
        Assert.assertEquals(message,"Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void LoginWithEmptyPassword() {

        methods.enterusername(data.Valid_username, driver);
        methods.enterpassword(data.EmptyPasword, driver);
        methods.clicklogin(driver);
        String message = String.valueOf(methods.getErrorMessage(driver));
        Assert.assertEquals(message,"Epic sadface: Password is required");

    }
    @Test
    public void LoginWithEmptyUsername() {

        methods.enterusername(data.EmptyUsername, driver);
        methods.enterpassword(data.Valid_password, driver);
        methods.clicklogin(driver);
        String message = String.valueOf(methods.getErrorMessage(driver));
        Assert.assertEquals(message,"Epic sadface: Username is required");

    }


    @AfterMethod
    public void quiteDriver() {
        driver.quit();
    }

}
