package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {

    // Initiate Browser, Wait, Actions & Navigate to URL
    public static void initWeb(){
        if(browserName.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if(browserName.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if(browserName.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException("Invalid Browser Type");

        driver.manage().window().maximize();
//        driver.manage().window().setPosition(new Point(0,0));
//        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(timeout), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(timeout));
        driver.get(url);
        ManagePages.initGrafana();
        action = new Actions(driver);
    }

    public static WebDriver initChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static WebDriver initFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    public static WebDriver initIEDriver(){
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }

    public static void initMobile() {
        dc.setCapability(MobileCapabilityType.UDID, udID);
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
        try {
            mobileDriver = new AndroidDriver<>(new URL(appiumServer), dc);
        } catch (Exception e) {
            System.out.println("Can not connect to appium server, see details: " + e);
        }
        ManagePages.initMortgage();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(timeout), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(timeout));
        action = new Actions(driver);
    }

    public static void initAPI() {
        RestAssured.baseURI = urlAPI;
        httpRequest = RestAssured.given().auth().preemptive().basic(userName, password);
    }

    public static void initElectron() {
        System.setProperty("webdriver.chrome.driver", electronDriverPath);
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(electronAppPath);
//        dc.setCapability("chromeOptions", opt);
//        dc.setBrowserName("chrome");
        driver = new ChromeDriver(opt);
        ManagePages.initToDo();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(timeout), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(timeout));
//        action = new Actions(driver);
    }

    public static void initDesktop() {
        dc.setCapability("app", calculatorApp);
        try {
            driver = new WindowsDriver<>(new URL(appiumServerDesktop), dc);
        } catch (Exception e) {
            System.out.println("Can not Connect to Appium Server, See Details: " + e);
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(timeout), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(timeout));
        ManagePages.initCalculator();
    }

    @BeforeClass
    @Parameters({"PlatformName", "BrowserName", "URL", "Timeout", "ActiveDB", "DDTFile", "UDID", "AppPackage", "AppActivity", "AppiumServer",
            "URLAPI", "UserName", "Password", "ElectronDriverPath", "ElectronAppPath", "CalculatorApp", "AppiumServerDesktop"})
    public void startSession(String PlatformName, String BrowserName, String URL, String Timeout, String ActiveDB, String DDTFile,
                             String UDID, String AppPackage, String AppActivity, String AppiumServer, String URLAPI, String UserName, String Password,
                             String ElectronDriverPath, String ElectronAppPath, String CalculatorApp, String AppiumServerDesktop) {
        // --- Init Params ---
        platform = PlatformName;
        browserName = BrowserName;
        url = URL;
        timeout = Timeout;
        activeDB = ActiveDB;
        ddtFile = DDTFile;
        udID = UDID;
        appPackage = AppPackage;
        appActivity = AppActivity;
        appiumServer = AppiumServer;
        urlAPI = URLAPI;
        userName = UserName;
        password = Password;
        electronDriverPath = ElectronDriverPath;
        electronAppPath = ElectronAppPath;
        calculatorApp = CalculatorApp;
        appiumServerDesktop = AppiumServerDesktop;

        if(platform.equalsIgnoreCase("web"))
            initWeb();
        else if(platform.equalsIgnoreCase("mobile"))
            initMobile();
        else if(platform.equalsIgnoreCase("api"))
            initAPI();
        else if(platform.equalsIgnoreCase("electron"))
            initElectron();
        else if(platform.equalsIgnoreCase("desktop"))
            initDesktop();
        else if(activeDB.equalsIgnoreCase("yes"))
            ManageDB.openConnection(dbURL, dbUserName, dbPassword);
        else
            throw new RuntimeException("Invalid platform name");
        softAssert = new SoftAssert();
//        screen = new Screen();
    }

    @AfterClass
    public void closeSession(){
        if(activeDB.equalsIgnoreCase("yes")){
            ManageDB.closeConnection();
        }
        if(!platform.equalsIgnoreCase("api")) {
            if(!platform.equalsIgnoreCase("mobile"))
                driver.quit();
            else
                mobileDriver.quit();
        }
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        if(!platform.equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @AfterMethod
    public void afterMethod(){
        if(platform.equalsIgnoreCase("web"))
            driver.get(url);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] saveScreenshot(String desc, String format) {
        Date date= new Date();
        long time = date.getTime();
        Timestamp timeStamp = new Timestamp(time);
        String timeString = timeStamp.toString();
        timeString = timeString.substring(11).replace(".", ":").replace(":", "_");
        byte[] imgBytes = new byte[0];
        if(!platform.equalsIgnoreCase("mobile") &&
                !platform.equalsIgnoreCase("api")){
            imgBytes = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        } else if (platform.equalsIgnoreCase("mobile")){
            imgBytes = ((TakesScreenshot)mobileDriver).getScreenshotAs(OutputType.BYTES);
        }
        try {
            FileUtils.writeByteArrayToFile(new File("./screenshots/" + timeString + " - " + desc + "." + format), imgBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imgBytes;
    }
}
