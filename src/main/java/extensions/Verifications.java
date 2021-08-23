package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.sikuli.script.FindFailed;
//import org.testng.annotations.Parameters;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.*;

public class Verifications extends CommonOps {

    @Step("Verify Text In Element")
    public static void verifyTextInElement(WebElement elem, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }

    @Step ("Verify Int")
    public static void verifyInt (int actual, int exp){
        assertEquals(actual, exp);
    }

    @Step ("Verify String")
    public static void verifyString (String actual, String exp){
        assertEquals(actual, exp);
    }

    @Step ("Verify String Contains")
    public static void verifyStringContains (String actual, String exp){
        assertTrue(actual.contains(exp));
    }

    @Step("Verify Number Of Elements")
    public static void numberOfElements(List<WebElement> elems, int expected){
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        assertEquals(elems.size(), expected);
    }

    @Step("Verify Visibility Of Elements (Soft-Assertion)")
    public static void visibilityOfElements(List<WebElement> elems) {
        for(WebElement elem : elems) {
            softAssert.assertTrue(elem.isDisplayed(), "Sorry " + elem.getText() + " not displayed");
        }
        softAssert.assertAll("Some elements were not displayed");
    }

    @Step("Verify Element Visually")
    public static void verifyVisualElement(String ImageRepo, String expectedImageName) {
//        try {
//            screen.find(ImageRepo + expectedImageName + ".png");
//        } catch (FindFailed findFailed) {
//            System.out.println("Error Comparing Image File: " + findFailed);
//            fail("Error Comparing Image File: " + findFailed);
//        }
        System.out.println("Disabled");
    }

    @Step ("Grafana: Verify user is displayed on search")
    public static void userFound (List<WebElement> list){
        assertTrue(list.size() > 1);
    }

    @Step ("Grafana: Verify user is not displayed on search")
    public static void userNotFound (List<WebElement> list){
        assertFalse(list.size() > 1);
    }

    @Step("Verify Text with Text")
    public static void verifyText(String actual, String expected) {
        assertEquals(actual, expected);
    }

    @Step("Verify Number with Number")
    public static void verifyNumber(int actual, int expected) {
        assertEquals(actual, expected);
    }
}
