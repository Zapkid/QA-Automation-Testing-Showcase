package utilities;

import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base {

    // Web: Initiate Grafana Webpage Objects
    public static void initGrafana() {
        grafanaLogin = PageFactory.initElements(driver, pageObjects.grafana.LoginPage.class);
        grafanaMain = PageFactory.initElements(driver, pageObjects.grafana.MainPage.class);
        grafanaLeftMenu = PageFactory.initElements(driver, pageObjects.grafana.LeftMenuPage.class);
        grafanaServerAdminMini = PageFactory.initElements(driver, pageObjects.grafana.ServerAdminMiniPage.class);
        grafanaUsersPage = PageFactory.initElements(driver, pageObjects.grafana.UsersPage.class);
        grafanaNewUser = PageFactory.initElements(driver, pageObjects.grafana.NewUserPage.class);
        grafanaUser = PageFactory.initElements(driver, pageObjects.grafana.UserInfoPage.class);
    }

    // Mobile: Initiate UK Mortgage Calc app page Objects
    public static void initMortgage() {
        mortgageMain = new pageObjects.mortgage.MainPage(mobileDriver);
    }

    // Electron: Initiate Todolist app page Objects
    public static void initToDo() {
        todoMain = PageFactory.initElements(driver, pageObjects.todo.MainPage.class);
    }

    // Desktop: Initiate Calculator app page Objects
    public static void initCalculator() {
        calcMain = PageFactory.initElements(driver, pageObjects.calculator.MainPage.class);
    }

}
