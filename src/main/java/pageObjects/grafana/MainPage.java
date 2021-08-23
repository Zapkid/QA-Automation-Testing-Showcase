package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage {

    @FindBy(css = ".css-1aanzv4")
    public WebElement txt_welcomeHeader;

    @FindBy(css = ".css-1hik5m6 button")
    public List<WebElement> btns_toolbar;

}
