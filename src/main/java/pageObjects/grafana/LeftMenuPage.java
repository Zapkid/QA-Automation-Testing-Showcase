package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftMenuPage {

    @FindBy(css = ".sidemenu")
    public WebElement menu_sidemenu;

    @FindBy(css = ".sidemenu__logo")
    public WebElement btn_logo;

    @FindBy(css = ".sidemenu__top")
    public WebElement sidemenu_top;

    @FindBy(css = ".sidemenu__top div[class='sidemenu-item dropdown'] .sidemenu-link")
    public WebElement btn_search;

    @FindBy(css = ".sidemenu__top div[class='sidemenu-item dropdown'] a[href='/dashboard/new']")
    public WebElement btn_create;

    @FindBy(css = ".sidemenu__top div[class='sidemenu-item dropdown'] a[href='/']")
    public WebElement btn_dashboards;

    @FindBy(css = ".sidemenu__top div[class='sidemenu-item dropdown'] a[href='/explore']")
    public WebElement btn_explore;

    @FindBy(css = ".sidemenu__top div[class='sidemenu-item dropdown'] a[href='/alerting/list']")
    public WebElement btn_alerting;

    @FindBy(css = ".sidemenu__top div[class='sidemenu-item dropdown'] a[href='/datasources']")
    public WebElement btn_configuration;

    @FindBy(css = ".sidemenu__top div[class='sidemenu-item dropdown'] a[href='/admin/users']")
    public WebElement btn_serverAdmin;

    @FindBy(css = ".sidemenu")
    public WebElement sidemenu_bottom;

    @FindBy(css = ".sidemenu__bottom div[class='sidemenu-item dropdown dropup'] a[href='/profile']")
    public WebElement btn_profile;

    @FindBy(css = ".sidemenu__bottom div[class='sidemenu-item dropdown dropup'] a[href='/admin/users']")
    public WebElement btn_help;

}
