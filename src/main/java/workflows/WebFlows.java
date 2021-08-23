package workflows;

import extensions.DBActions;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

import java.util.List;

public class WebFlows extends CommonOps {

    @Step("Business Flow: Login to Grafana")
    public static void login(String user, String pass){
        UIActions.updateText(grafanaLogin.txt_username, user);
        UIActions.updateText(grafanaLogin.txt_password, pass);
        UIActions.click(grafanaLogin.btn_login);
        UIActions.click(grafanaLogin.btn_skip);
    }

    @Step("Business Flow: Login to Grafana with DB Credentials")
    public static void loginDB(){
        String query = "SELECT name, password FROM Employees WHERE id='3'";
        List<String> cred = DBActions.getCredentials(query);
        UIActions.updateText(grafanaLogin.txt_username, cred.get(0));
        UIActions.updateText(grafanaLogin.txt_password, cred.get(1));
        UIActions.click(grafanaLogin.btn_login);
        UIActions.click(grafanaLogin.btn_skip);
    }

    @Step ("Business flow: Add New User")
    public static void addNewUser (String name, String email, String username, String password) {
        UIActions.click(grafanaUsersPage.btn_newUser);
        UIActions.updateText(grafanaNewUser.form_name, name);
        UIActions.updateText(grafanaNewUser.form_email, email);
        UIActions.updateText(grafanaNewUser.form_username, username);
        UIActions.updateText(grafanaNewUser.form_password, password);
        saveScreenshot("Add New user - " + username, "png");
        UIActions.click(grafanaNewUser.form_submit);
    }

    @Step ("Business flow: Delete User by Username")
    public static void deleteUser (String username) {
        for (WebElement elem : grafanaUsersPage.users_tableRowsWithHeader) {
            elem = elem.findElement(By.xpath("//a[contains(text(),'" + username + "')]"));
            if (elem.getText().equalsIgnoreCase(username)){
                UIActions.click(elem);
                UIActions.click(grafanaUser.btn_delete);
                saveScreenshot("Delete " + username, "png");
                UIActions.click(grafanaUser.btn_confirm_delete);
                break;
            }
        }
    }

    @Step ("Business flow: Search & Verify username")
    public static void searchAndVerifyUser (String username, String shouldExists) {
        UIActions.sendKeysAndWait(grafanaUsersPage.search_field, username);
        saveScreenshot("Search " + username, "png");
        if (shouldExists.equalsIgnoreCase("yes")) {
            Verifications.userFound(grafanaUsersPage.users_tableRowsWithHeader);
        } else if (shouldExists.equalsIgnoreCase("no")) {
            Verifications.userNotFound(grafanaUsersPage.users_tableRowsWithHeader);
        } else {
            throw new RuntimeException("Invalid input from DDT. Should be: 'yes' or 'no'");
        }
    }

}
