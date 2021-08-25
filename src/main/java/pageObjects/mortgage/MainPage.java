package pageObjects.mortgage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class MainPage {

    private AppiumDriver mobileDriver;

    public MainPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        //PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(id = "etAmount")
    public AndroidElement txt_amount;

    @Step("Get Amount element")
    public AndroidElement getTxt_amount(){
        return txt_amount;
    }

    @AndroidFindBy(id = "etTerm")
    public AndroidElement txt_term;

    @Step("Get Term element")
    public AndroidElement getTxt_term(){
        return txt_term;
    }

    @AndroidFindBy(id = "etRate")
    public AndroidElement txt_rate;

    @Step("Get Rate element")
    public AndroidElement getTxt_rate(){
        return txt_rate;
    }

    @AndroidFindBy(id = "btnCalculate")
    public AndroidElement btn_calculate;

    @Step("Get Calculate Button")
    public AndroidElement getBtn_calculate(){
        return btn_calculate;
    }

    @AndroidFindBy(id = "tvRepayment")
    public AndroidElement txt_repayment;

    @Step("Get Repayment element")
    public AndroidElement getTxt_repayment(){
        return txt_repayment;
    }

}
