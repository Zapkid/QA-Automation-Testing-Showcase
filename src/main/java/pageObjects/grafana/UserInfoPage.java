package pageObjects.grafana;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserInfoPage {

    @FindBy(css = ".css-kdj7v3 .css-1vxgxz7-button")
    private WebElement btn_delete;

    @Step("Get Delete button")
    public WebElement getBtn_delete(){
        return btn_delete;
    }

    @FindBy(css = "button[aria-label='Confirm Modal Danger Button']")
    private WebElement btn_confirm_delete;

    @Step("Get Confirm Delete button")
    public WebElement getBtn_confirm_delete(){
        return btn_confirm_delete;
    }

}
