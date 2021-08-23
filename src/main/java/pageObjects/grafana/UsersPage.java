package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UsersPage {

    @FindBy(css = ".css-5tn967-button")
    public WebElement btn_newUser;

    // Includes Header row - Add 'tbody' before 'tr' to Exclude Header row.
    @FindBy(css = "table[class='filter-table form-inline filter-table--hover'] tr")
    public List<WebElement> users_tableRowsWithHeader;

    @FindBy(css = "table[class='filter-table form-inline filter-table--hover'] tbody tr")
    public List<WebElement> users_tableRowsNoHeader;

    @FindBy(css = "input[placeholder='Search user by login, email, or name.']")
    public WebElement search_field;
}
