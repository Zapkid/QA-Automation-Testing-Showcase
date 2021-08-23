package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.CommonOps;
import utilities.ManageDDT;
import workflows.WebFlows;

//@Listeners(utilities.Listeners.class)
public class GrafanaWeb extends CommonOps {

    @Test(description = "Login")
    @Description("Default login to Grafana")
    @Parameters({"UserName", "Password"})
    public void Test01_GrafanaLogin(String UserName, String Password) {
        WebFlows.login(UserName, Password);
        Verifications.verifyTextInElement(grafanaMain.txt_welcomeHeader, "Welcome to Grafana");
    }

    @Test(description = "Verify default users")
    @Description("Verify default users")
    public void Test02_ViewUsers() {
        UIActions.mouseHover(grafanaLeftMenu.btn_serverAdmin, grafanaServerAdminMini.btn_users);
        // users_tableRows counts the Header as the 1st row (intentionally)
        Verifications.numberOfElements(grafanaUsersPage.users_tableRowsWithHeader, 2);
    }

    @Test(description = "Create New User")
    @Description("Create New User")
    public void Test03_CreateNewUser() {
        UIActions.mouseHover(grafanaLeftMenu.btn_serverAdmin, grafanaServerAdminMini.btn_users);
        WebFlows.addNewUser("John Doe", "JD@localhost", "JDTester", "123abc999");
        // users_tableRows counts the Header as the 1st row (intentionally)
        Verifications.numberOfElements(grafanaUsersPage.users_tableRowsWithHeader, 3);
    }

    @Test(description = "Delete User")
    @Description("Delete User")
    public void Test04_DeleteUser() {
        UIActions.mouseHover(grafanaLeftMenu.btn_serverAdmin, grafanaServerAdminMini.btn_users);
        WebFlows.deleteUser("JDTester");
        // users_tableRows counts the Header as the 1st row (intentionally)
        Verifications.numberOfElements(grafanaUsersPage.users_tableRowsWithHeader, 2);
    }

    @Test(description = "Toolbar buttons visibility")
    @Description("Verify Toolbar buttons are visible")
    public void Test05_VerifyToolbar() {
        Verifications.visibilityOfElements(grafanaMain.btns_toolbar);
    }

    @Test(description = "User icon image", enabled = false)
    @Description("Verify User icon image using sikuli")
    @Parameters({"ImageRepo"})
    public void Test06_VerifyVisuallyUserIcon(String ImageRepo) {
        Verifications.verifyVisualElement(ImageRepo, "Grafana_UserIcon");
    }

    @Test(description = "User Search Result", dataProvider = "data-provider", dataProviderClass = ManageDDT.class)
    @Description("Verify User is found or not by searching usernames with DDT")
    public void Test07_VerifyUserSearchResult(String username, String shouldBeFound) {
        UIActions.mouseHover(grafanaLeftMenu.btn_serverAdmin, grafanaServerAdminMini.btn_users);
        WebFlows.searchAndVerifyUser(username, shouldBeFound);
    }
}
