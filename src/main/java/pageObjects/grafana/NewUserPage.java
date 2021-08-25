package pageObjects.grafana;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewUserPage {

    @FindBy(css = ".css-xs0vux input[name='name']")
    private WebElement form_name;

    @Step("Get Form Name field element")
    public WebElement getForm_name(){
        return form_name;
    }

    @FindBy(css = ".css-xs0vux input[name='email']")
    private WebElement form_email;

    @Step("Get Form Email field element")
    public WebElement getForm_email(){
        return form_email;
    }

    @FindBy(css = ".css-xs0vux input[name='login']")
    private WebElement form_username;

    @Step("Get Form Username field element")
    public WebElement getForm_username(){
        return form_username;
    }

    @FindBy(css = ".css-xs0vux input[name='password']")
    private WebElement form_password;

    @Step("Get Form Password field element")
    public WebElement getForm_password(){
        return form_password;
    }

    @FindBy(css = ".css-xs0vux button[type='submit']")
    private WebElement form_submit;

    @Step("Get Form Submit button element")
    public WebElement getForm_submit(){
        return form_submit;
    }

}
