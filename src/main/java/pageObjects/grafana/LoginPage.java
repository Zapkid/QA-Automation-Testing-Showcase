package pageObjects.grafana;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(css = "input[name='user']")
    private WebElement txt_username;

    @Step("Get Username field element")
    public WebElement getTxt_username(){
        return txt_username;
    }

    @FindBy(css = "input[name='password']")
    private WebElement txt_password;

    @Step("Get Password field element")
    public WebElement getTxt_password(){
        return txt_password;
    }

    @FindBy(css = ".css-w9m50q-button")
    private WebElement btn_login;

    @Step("Get Login button")
    public WebElement getBtn_login(){
        return btn_login;
    }

    @FindBy(css = ".css-g4ra35-button")
    private WebElement btn_skip;

    @Step("Get Skip button")
    public WebElement getBtn_skip(){
        return btn_skip;
    }

}
