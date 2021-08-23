package pageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

    @FindBy (name = "Calculator")
    public WebElement window_calc;

    @FindBy(name = "Clear entry")
    public WebElement btn_clearEntry;

    @FindBy(name = "Plus")
    public WebElement btn_plus;

    @FindBy(name = "Minus")
    public WebElement btn_minus;

    @FindBy(name = "Multiply by")
    public WebElement btn_multiply;

    @FindBy(name = "Divide by")
    public WebElement btn_divide;

    @FindBy(name = "Equals")
    public WebElement btn_equals;

    @FindBy (xpath = "//*[@AutomationId='CalculatorResults']")
    public WebElement field_result;

    @FindBy (xpath = "//*[@AutomationId='num0Button']")
    public WebElement btn_0;

    @FindBy (xpath = "//*[@AutomationId='num1Button']")
    public WebElement btn_1;

    @FindBy (xpath = "//*[@AutomationId='num2Button']")
    public WebElement btn_2;

    @FindBy (xpath = "//*[@AutomationId='num3Button']")
    public WebElement btn_3;

    @FindBy (xpath = "//*[@AutomationId='num4Button']")
    public WebElement btn_4;

    @FindBy (xpath = "//*[@AutomationId='num5Button']")
    public WebElement btn_5;

    @FindBy (xpath = "//*[@AutomationId='num6Button']")
    public WebElement btn_6;

    @FindBy (xpath = "//*[@AutomationId='num7Button']")
    public WebElement btn_7;

    @FindBy (xpath = "//*[@AutomationId='num8Button']")
    public WebElement btn_8;

    @FindBy (xpath = "//*[@AutomationId='num9Button']")
    public WebElement btn_9;

    @FindBy (xpath = "//*[@AutomationId='TogglePaneButton']")
    public WebElement btn_panel;

    @FindBy (xpath = "//*[@AutomationId='Standard']")
    public WebElement btn_standard;

    @FindBy (xpath = "//*[@AutomationId='Scientific']")
    public WebElement btn_scientific;

    @FindBy (xpath = "//*[@AutomationId='CalculatorResults']")
    public WebElement btn_decimal;

    @FindBy (xpath = "//*[@AutomationId='powerButton']")
    public WebElement btn_power;

    @FindBy (xpath = "//*[@AutomationId='factorialButton']")
    public WebElement btn_factorial;

    @FindBy (xpath = "//*[@AutomationId='modButton']")
    public WebElement btn_mod;

    @FindBy (xpath = "//*[@AutomationId='logBase10Button']")
    public WebElement btn_log;

    @FindBy (xpath = "//*[@AutomationId='piButton']")
    public WebElement btn_pi;

    @FindBy (xpath = "//*[@AutomationId='openParenthesisButton']")
    public WebElement btn_openParenthesis;

    @FindBy (xpath = "//*[@AutomationId='closeParenthesisButton']")
    public WebElement btn_closeParenthesis;

}
