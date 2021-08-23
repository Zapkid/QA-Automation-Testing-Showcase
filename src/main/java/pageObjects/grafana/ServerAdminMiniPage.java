package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServerAdminMiniPage {

    @FindBy(css = ".sidemenu__top a[class='side-menu-header-link][href='/admin/users']")
    public WebElement btn_header;

    @FindBy(css = ".dropdown-menu.dropdown-menu--sidemenu li + li a[href='/admin/users']")
    public WebElement btn_users;

    @FindBy(css = ".sidemenu__top a[href='/admin/orgs']")
    public WebElement btn_orgs;

    @FindBy(css = ".sidemenu__top a[href='/admin/settings']")
    public WebElement sidemenu_settings;

    @FindBy(css = ".sidemenu__top a[href='/admin/stats']")
    public WebElement btn_stats;

    @FindBy(css = ".sidemenu__top a[href='/admin/upgrading']")
    public WebElement btn_upgrade;

}
