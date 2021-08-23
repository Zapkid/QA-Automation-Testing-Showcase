package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

public class UIActions extends CommonOps{

    @Step("Click on Element")
    public static void click(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step ("No wait Click on element")
    public static void noWaitClick(WebElement elem){
        elem.click();
    }

    @Step("Update Text Element")
    public static void updateText(WebElement elem, String text){
        wait.until((ExpectedConditions.visibilityOf(elem)));
        elem.sendKeys(text);
    }

    @Step("Update Text Element as Human")
    public static void updateTextHuman(WebElement elem, String text){
        wait.until((ExpectedConditions.visibilityOf(elem)));
        for(char ch : text.toCharArray()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            elem.sendKeys(ch + "");
        }
    }

    @Step ("Update element text")
    public static void noWaitSendKeys(WebElement elem, String text){
        elem.sendKeys(text);
    }

    @Step ("Update element text as human")
    public static void sendKeysAndWait(WebElement elem, String text){
        wait.until((ExpectedConditions.visibilityOf(elem)));
        elem.sendKeys(text);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    @Step("Update DropDown Element")
//    public static void updateDropDown(WebElement elem, String text){
//        wait.until((ExpectedConditions.visibilityOf(elem)));
//        Select dropDown = new Select(elem);
//        dropDown.selectByVisibleText(text);
//    }

    @Step("Mouse Hover Element")
    public static void mouseHover(WebElement elem1, WebElement elem2){
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

    @Step("Mouse Hover Element")
    public static void mouseHover(WebElement elem1){
        action.moveToElement(elem1).click().build().perform();
    }
}
