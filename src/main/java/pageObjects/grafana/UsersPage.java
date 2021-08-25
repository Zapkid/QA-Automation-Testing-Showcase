package pageObjects.grafana;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UsersPage {

    @FindBy(css = ".css-5tn967-button")
    private WebElement btn_newUser;

    @Step("Get New User button")
    public WebElement getBtn_newUser(){
        return btn_newUser;
    }

    // Includes Header row
    @FindBy(css = "table[class='filter-table form-inline filter-table--hover'] tr")
    private List<WebElement> users_tableRowsWithHeader;

    @Step("Get Users Table with header")
    public List<WebElement> getUsers_tableRowsWithHeader(){
        return users_tableRowsWithHeader;
    }

//    // Excludes Header row
//    @FindBy(css = "table[class='filter-table form-inline filter-table--hover'] tbody tr")
//    public List<WebElement> users_tableRowsNoHeader;

    @FindBy(css = "input[placeholder='Search user by login, email, or name.']")
    private WebElement search_field;

    @Step("Get User Search field")
    public WebElement getSearch_field(){
        return search_field;
    }
}
