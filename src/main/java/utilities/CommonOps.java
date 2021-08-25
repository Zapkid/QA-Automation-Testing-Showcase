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
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {

    // Initiate Parameters from Suite XML & chosen platform
    @BeforeClass
    @Parameters({"PlatformName", "BrowserName", "URL", "Timeout", "DDTFile", "ActiveDB", "DBURL", "DBUsername", "DBPassword"})
    public void startSession(String PlatformName, String BrowserName, String URL, String Timeout, String DDTFile, String ActiveDB, String DBURL, String DBUsername, String DBPassword) {
        // --- Init Params ---
        platform = PlatformName;
        browserName = BrowserName;
        url = URL;
        timeout = Timeout;
        ddtFile = DDTFile;
        activeDB = ActiveDB;
        dbURL = DBURL;
        dbUserName = DBUsername;
        dbPassword = DBPassword;
        softAssert = new SoftAssert();
        screen = new Screen();

        // Initiate platform based on external platform parameter
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
            ManageDB.openConnection();
        else
            throw new RuntimeException("Invalid platform name");
    }

    // Close session
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

    // Start video recording before starting a test
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

    // Re-navigate to Grafana URL after each test
    @AfterMethod
    public void afterMethod(){
        if(platform.equalsIgnoreCase("web"))
            driver.get(url);
    }

    // Initiate Browser, Navigate to URL, Actions & Wait
    // Initiate Grafana Page Objects
    public static void initWeb(){
        if(browserName.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if(browserName.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if(browserName.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException("Invalid Browser Type");

        // TODO: Initiate Grafana Server

        driver.manage().window().maximize();
        setDriverTimeoutAndWait();
        driver.get(url);
        action = new Actions(driver);

        ManagePages.initGrafana();
    }

    // Setup Chrome driver with Boni Garcia WebDriverManager
    public static WebDriver initChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    // Setup Firefox driver with Boni Garcia WebDriverManager
    public static WebDriver initFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    // Setup IE driver with Boni Garcia WebDriverManager
    public static WebDriver initIEDriver(){
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }

    // Initiate Mobile Driver & connect to Appium server
    // Initiate UK Mortgage app
    public static void initMobile() {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try {
            mobileDriver = new AndroidDriver<>(new URL(getData("AppiumServer")), dc);
        } catch (Exception e) {
            System.out.println("Can not connect to appium server, see details: " + e);
        }

        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(timeout), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(timeout));
        action = new Actions(driver);

        ManagePages.initMortgage();
    }

    // Connect to API
    public static void initAPI() {
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("UserName"), getData("Password"));
    }

    // Initiate Electron Driver & Todolist app
    // Initiate Todolist Page Objects
    public static void initElectron() {
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriver"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronApp"));
        driver = new ChromeDriver(opt);
        setDriverTimeoutAndWait();

        ManagePages.initToDo();
    }

    // Initiate Electron Driver & Todolist app
    // Initiate Todolist Page Objects
    public static void initDesktop() {
        // TODO: Initiate WinAppDriver.exe
        dc.setCapability("app", getData("CalculatorApp"));
        try {
            driver = new WindowsDriver<>(new URL(getData("AppiumServerDesktop")), dc);
        } catch (Exception e) {
            System.out.println("Can not Connect to Appium Server, See Details: " + e);
        }
        setDriverTimeoutAndWait();

        ManagePages.initCalculator();
    }

    // Get Configuration Data
    public static String getData(String nodeName) {
        File xmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder docBuilder;
        Document doc = null;

        try {
            xmlFile = new File("D:\\Automation\\FinalProject\\Configuration\\DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            docBuilder = dbFactory.newDocumentBuilder();
            doc = docBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            System.out.println("Error reading XML file: " + e);
        } finally {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }

    // Take a screenshot for Allure report & save a png file
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

    // Repeated code
    public static void setDriverTimeoutAndWait(){
        driver.manage().timeouts().implicitlyWait(Long.parseLong(timeout), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(timeout));
    }
}
