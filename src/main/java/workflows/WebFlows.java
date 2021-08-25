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
        UIActions.updateText(grafanaLogin.getTxt_username(), user);
        UIActions.updateText(grafanaLogin.getTxt_password(), pass);
        UIActions.click(grafanaLogin.getBtn_login());
        UIActions.click(grafanaLogin.getBtn_skip());
    }

    @Step("Business Flow: Login to Grafana with DB Credentials")
    public static void loginWithDB(){
        String query = "SELECT name, password FROM Employees WHERE id='3'";
        List<String> cred = DBActions.getCredentials(query);
        UIActions.updateText(grafanaLogin.getTxt_username(), cred.get(0));
        UIActions.updateText(grafanaLogin.getTxt_password(), cred.get(1));
        UIActions.click(grafanaLogin.getBtn_login());
        UIActions.click(grafanaLogin.getBtn_skip());
    }

    @Step ("Business flow: Add New User")
    public static void addNewUser (String name, String email, String username, String password) {
        UIActions.click(grafanaUsersPage.getBtn_newUser());
        UIActions.updateText(grafanaNewUser.getForm_name(), name);
        UIActions.updateText(grafanaNewUser.getForm_email(), email);
        UIActions.updateText(grafanaNewUser.getForm_username(), username);
        UIActions.updateText(grafanaNewUser.getForm_password(), password);
        saveScreenshot("Add New user - " + username, "png");
        UIActions.click(grafanaNewUser.getForm_submit());
    }

    @Step ("Business flow: Delete User by Username")
    public static void deleteUser (String username) {
        for (WebElement elem : grafanaUsersPage.getUsers_tableRowsWithHeader()) {
            elem = elem.findElement(By.xpath("//a[contains(text(),'" + username + "')]"));
            if (elem.getText().equalsIgnoreCase(username)){
                UIActions.click(elem);
                UIActions.click(grafanaUser.getBtn_delete());
                saveScreenshot("Delete " + username, "png");
                UIActions.click(grafanaUser.getBtn_confirm_delete());
                break;
            }
        }
    }

    @Step ("Business flow: Search & Verify username")
    public static void searchAndVerifyUser (String username, String shouldExists) {
        UIActions.sendKeysAndWait(grafanaUsersPage.getSearch_field(), username);
        saveScreenshot("Search " + username, "png");
        if (shouldExists.equalsIgnoreCase("yes")) {
            Verifications.userFound(grafanaUsersPage.getUsers_tableRowsWithHeader());
        } else if (shouldExists.equalsIgnoreCase("no")) {
            Verifications.userNotFound(grafanaUsersPage.getUsers_tableRowsWithHeader());
        } else {
            throw new RuntimeException("Invalid input from DDT. Should be: 'yes' or 'no'");
        }
    }

}
