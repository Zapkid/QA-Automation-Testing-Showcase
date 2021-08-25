package pageObjects.grafana;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage {

    @FindBy(css = ".css-1aanzv4")
    private WebElement txt_welcomeHeader;

    @Step("Get Welcome Header element")
    public WebElement getTxt_welcomeHeader(){
        return txt_welcomeHeader;
    }

    @FindBy(css = ".css-1hik5m6 button")
    private List<WebElement> btns_toolbar;

    @Step("Get Toolbar buttons")
    public List<WebElement> getToolbarButtons(){
        return btns_toolbar;
    }

}
