package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    By usernameFieldBy = By.id("user-name");
    By passwordFieldBy = By.id("password");
    By loginButtonBy = By.id("login-button");

    public void performLogin(String username, String password){
        writeText(usernameFieldBy, username);
        writeText(passwordFieldBy, password);
        clickElement(loginButtonBy);
    }
}