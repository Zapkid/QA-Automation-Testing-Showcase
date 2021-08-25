package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {

    @Step ("Business flow: Get Integer Result")
    public static String getResult(){
        return calcMain.field_result.getText().replace("Display is", "").replace(",", "").trim();
    }

    @Step ("Business flow: Enter Equation")
    public static void enterEquation(String equation){
        for (int i = 0; i < equation.length(); i++) {
            desktopCalcClick(equation.charAt(i));
        }
        saveScreenshot("Equation", "png");
    }

    @Step ("Business flow: Click corresponding button")
    public static void desktopCalcClick(char c) {
        if (Character.getNumericValue(c) == 0){
            UIActions.noWaitClick(calcMain.btn_0);
        } else if (Character.getNumericValue(c) == 1){
            UIActions.noWaitClick(calcMain.btn_1);
        } else if (Character.getNumericValue(c) == 2){
            UIActions.noWaitClick(calcMain.btn_2);
        } else if (Character.getNumericValue(c) == 3){
            UIActions.noWaitClick(calcMain.btn_3);
        } else if (Character.getNumericValue(c) == 4){
            UIActions.noWaitClick(calcMain.btn_4);
        } else if (Character.getNumericValue(c) == 5){
            UIActions.noWaitClick(calcMain.btn_5);
        } else if (Character.getNumericValue(c) == 6){
            UIActions.noWaitClick(calcMain.btn_6);
        } else if (Character.getNumericValue(c) == 7){
            UIActions.noWaitClick(calcMain.btn_7);
        } else if (Character.getNumericValue(c) == 8){
            UIActions.noWaitClick(calcMain.btn_8);
        } else if (Character.getNumericValue(c) == 9){
            UIActions.noWaitClick(calcMain.btn_9);
        } else if (c == '+'){
            UIActions.noWaitClick(calcMain.btn_plus);
        } else if (c == '-'){
            UIActions.noWaitClick(calcMain.btn_minus);
        } else if (c == '*'){
            UIActions.noWaitClick(calcMain.btn_multiply);
        } else if (c == '/'){
            UIActions.noWaitClick(calcMain.btn_divide);
        } else if (c == '.'){
            UIActions.noWaitClick(calcMain.btn_decimal);
        } else if (c == '='){
            UIActions.noWaitClick(calcMain.btn_equals);
        } else if (c == '^'){
            UIActions.noWaitClick(calcMain.btn_power);
        } else if (c == '!'){
            UIActions.noWaitClick(calcMain.btn_factorial);
        } else if (c == '%'){
            UIActions.noWaitClick(calcMain.btn_mod);
        } else if (c == '('){
            UIActions.noWaitClick(calcMain.btn_openParenthesis);
        } else if (c == ')'){
            UIActions.noWaitClick(calcMain.btn_closeParenthesis);
        } else if (c == 'l'){
            UIActions.noWaitClick(calcMain.btn_log);
        } else if (c == 'p'){
            UIActions.noWaitClick(calcMain.btn_pi);
        } else {
            System.out.println("Invalid input: " + c);
        }
    }

    @Step ("Business flow: Change to Standard Mode")
    public static void modeStandard(){
        UIActions.noWaitClick(calcMain.btn_panel);
        UIActions.noWaitClick(calcMain.btn_standard);
    }

    @Step ("Business flow: Change to Scientific Mode")
    public static void modeScientific(){
        UIActions.noWaitClick(calcMain.btn_panel);
        UIActions.noWaitClick(calcMain.btn_scientific);
    }


    // ---------------------------------- Obsolete ------------------------------------------

    @Step ("Business flow: Addition")
    public static void addition(WebElement num_a, WebElement num_b) {
        UIActions.noWaitClick(num_a);
        UIActions.noWaitClick(calcMain.btn_plus);
        UIActions.noWaitClick(num_b);
        UIActions.noWaitClick(calcMain.btn_equals);
        saveScreenshot("Addition", "png");
    }

    @Step ("Business flow: Subtraction")
    public static void subtraction(WebElement num_a, WebElement num_b) {
        UIActions.noWaitClick(num_a);
        UIActions.noWaitClick(calcMain.btn_minus);
        UIActions.noWaitClick(num_b);
        UIActions.noWaitClick(calcMain.btn_equals);
        saveScreenshot("Subtraction", "png");
    }

    @Step ("Business flow: Multiplication")
    public static void multiplication(WebElement num_a, WebElement num_b) {
        UIActions.noWaitClick(num_a);
        UIActions.noWaitClick(calcMain.btn_multiply);
        UIActions.noWaitClick(num_b);
        UIActions.noWaitClick(calcMain.btn_equals);
        saveScreenshot("Multiplication", "png");
    }

    @Step ("Business flow: Division")
    public static void division(WebElement num_a, WebElement num_b) {
        UIActions.noWaitClick(num_a);
        UIActions.noWaitClick(calcMain.btn_divide);
        UIActions.noWaitClick(num_b);
        UIActions.noWaitClick(calcMain.btn_equals);
        saveScreenshot("Division", "png");
    }
}
