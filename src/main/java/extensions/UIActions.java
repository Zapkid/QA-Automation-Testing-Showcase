package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

public class UIActions extends CommonOps{

    @Step("Wait for element click-ability, then Click on Element")
    public static void click(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step ("No wait Click on element")
    public static void noWaitClick(WebElement elem){
        elem.click();
    }

    @Step("Wait for element visibility, then Update Text Element")
    public static void updateText(WebElement elem, String text){
        wait.until((ExpectedConditions.visibilityOf(elem)));
        elem.sendKeys(text);
    }

    @Step("Update Text Element as Human")
    public static void updateTextAsHuman(WebElement elem, String text){
        wait.until((ExpectedConditions.visibilityOf(elem)));
        int length = text.length();
        for (int i = 0; i < length; i++){
            char c = text.charAt(i);
            try {
                Thread.sleep((int) (400 + (Math.random() * 100)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            elem.sendKeys(String.valueOf(c));
        }
    }

    @Step ("No wait Update element text")
    public static void noWaitSendKeys(WebElement elem, String text){
        elem.sendKeys(text);
    }

    @Step ("Wait for element visibility, then send keys & sleep")
    public static void sendKeysAndWait(WebElement elem, String text){
        wait.until((ExpectedConditions.visibilityOf(elem)));
        elem.sendKeys(text);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("Mouse Hover 2 Elements & Click")
    public static void mouseHover(WebElement elem1, WebElement elem2){
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

    @Step("Mouse Hover Element & Click")
    public static void mouseHover(WebElement elem1){
        action.moveToElement(elem1).click().build().perform();
    }
}
