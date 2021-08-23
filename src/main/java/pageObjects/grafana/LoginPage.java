package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(css = "input[name='user']")
    public WebElement txt_username;

    @FindBy(css = "input[name='password']")
    public WebElement txt_password;

    @FindBy(css = ".css-w9m50q-button")
    public WebElement btn_login;

    @FindBy(css = ".css-g4ra35-button")
    public WebElement btn_skip;
}
