package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;

//@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps {

    @Test (description = "Addition", priority = 1)
    @Description ("Verify single digit Addition on Calculator App")
    public void Addition() {
        DesktopFlows.addition(calcMain.btn_1, calcMain.btn_2);
        Verifications.verifyInt(Integer.parseInt(DesktopFlows.getResult()), 3);
    }

    @Test (description = "Subtraction", priority = 2)
    @Description ("Verify single digit Subtraction on Calculator App")
    public void Subtraction() {
        DesktopFlows.subtraction(calcMain.btn_5, calcMain.btn_4);
        Verifications.verifyInt(Integer.parseInt(DesktopFlows.getResult()), 1);
    }

    @Test (description = "Multiplication", priority = 3)
    @Description ("Verify single digit Multiplication on Calculator App")
    public void Multiplication() {
        DesktopFlows.multiplication(calcMain.btn_6, calcMain.btn_7);
        Verifications.verifyInt(Integer.parseInt(DesktopFlows.getResult()), 42);
    }

    @Test (description = "Division", priority = 4)
    @Description ("Verify single digit Division on Calculator App")
    public void Division() {
        DesktopFlows.division(calcMain.btn_3, calcMain.btn_9);
        Verifications.verifyStringContains(DesktopFlows.getResult(), "0.33");
    }

    @Test (description = "Division by Zero", priority = 5)
    @Description ("Verify Division by Zero on Calculator App")
    public void DivisionByZero() {
        DesktopFlows.division(calcMain.btn_8, calcMain.btn_0);
        Verifications.verifyStringContains(DesktopFlows.getResult(), "Cannot divide by zero");
    }

    @Test (description = "Intentional Fail", priority = 6, enabled = false)
    @Description ("Verify Fail on Calculator App")
    public void IntentionalFail() {
        DesktopFlows.addition(calcMain.btn_8, calcMain.btn_0);
        Verifications.verifyInt(Integer.parseInt(DesktopFlows.getResult()), 80);
    }

    @Test (description = "Full Equation One", priority = 7)
    @Description ("Verify an equation operation on Calculator App")
    public void EquationOne() {
        DesktopFlows.enterEquation("4*3======/9===");
        Verifications.verifyInt(Integer.parseInt(DesktopFlows.getResult()), 4);
        DesktopFlows.modeStandard();
    }

    @Test (description = "Full Equation Two", priority = 8)
    @Description ("Verify an equation operation on Calculator App")
    public void EquationTwo() {
        DesktopFlows.enterEquation("1+2*(3^4)=%14=!l=/p=");
        Verifications.verifyStringContains(DesktopFlows.getResult(), "1.769727");
        DesktopFlows.modeStandard();
    }
}
