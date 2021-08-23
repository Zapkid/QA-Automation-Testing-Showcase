package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserInfoPage {

    @FindBy(css = ".css-kdj7v3 .css-1vxgxz7-button")
    public WebElement btn_delete;

    @FindBy(css = "button[aria-label='Confirm Modal Danger Button']")
    public WebElement btn_confirm_delete;
}
