import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.*;


public class Methods {

private EdgeDriver driver;
Elements elements = new Elements();

    public Methods(EdgeDriver driver) {
        this.driver = driver;
    }

    public void enterusername(String user_Name , EdgeDriver driver)
    {
        WebElement username = driver.findElement(By.id(elements.Username));
        username.sendKeys(user_Name);
    }
    public void enterpassword(String Pass ,EdgeDriver driver)
    {
        WebElement password = driver.findElement(By.id(elements.Password));
        password.sendKeys(Pass);
    }
    public void clicklogin(EdgeDriver driver)
    {
        WebElement loginbtn = driver.findElement(By.id(elements.LoginButton));
        loginbtn.click();

    }
    public String checkUsername(EdgeDriver driver)
    {
        String username = driver.findElement(By.id(elements.Username)).getAttribute("id");
        return username;
    }
    public String checkPassword(EdgeDriver driver) {
        String password = driver.findElement(By.id(elements.Password)).getAttribute("id");
        return password;
    }
    public String checkLoginBtn(EdgeDriver driver)
    {
        String loginbtn = String.valueOf(driver.findElement(By.id(elements.LoginButton)).getAttribute("id"));
        return loginbtn;

    }

    public String getErrorMessage(EdgeDriver driver){
        String errorMessage = driver.findElement(By.xpath(elements.ErrorMessage)).getText();

        return errorMessage;
    }

}
