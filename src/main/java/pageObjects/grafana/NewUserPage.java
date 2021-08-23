package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewUserPage {

    @FindBy(css = ".css-xs0vux input[name='name']")
    public WebElement form_name;

    @FindBy(css = ".css-xs0vux input[name='email']")
    public WebElement form_email;

    @FindBy(css = ".css-xs0vux input[name='login']")
    public WebElement form_username;

    @FindBy(css = ".css-xs0vux input[name='password']")
    public WebElement form_password;

    @FindBy(css = ".css-xs0vux button[type='submit']")
    public WebElement form_submit;

}
