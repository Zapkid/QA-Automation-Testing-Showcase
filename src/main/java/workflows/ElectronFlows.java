package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

public class ElectronFlows extends CommonOps {

    @Step ("Todolist Business flow: Delete Todo")
    public static void deleteTodoByName(String text) {
        getTodoByText(text).findElement(By.cssSelector("div svg[class*='destroy']")).click();
        saveScreenshot("Delete " + text, "png");
    }

    @Step ("Todolist Business flow: Complete Todo")
    public static void completeTodoByName(String text) {
        getTodoByText(text).findElement(By.cssSelector("div div label")).click();
        saveScreenshot("Complete " + text, "png");
    }

    @Step ("Todolist Business flow: Complete All Todos")
    public static void completeAllTodos() {
        todoMain.getToggle_all_completed().click();
        saveScreenshot("Complete All", "png");
    }

    // Searching both UnCompleted & Completed Todos
    @Step ("Todolist Business flow: Get Todo by Text")
    public static WebElement getTodoByText(String text) {
        WebElement e = null;
        for (WebElement elem : todoMain.getTodos_list()) {
            if (elem.findElement(By.cssSelector("div[class*='view'] div label")).getText().equalsIgnoreCase(text)){
                e = elem;
                break;
            }
        }
        for (WebElement elem : todoMain.getTodos_completed_list()) {
            if (elem.findElement(By.cssSelector("div[class*='view'] div label")).getText().equalsIgnoreCase(text)){
                e = elem;
                break;
            }
        }
        return e;
    }

    @Step ("Todolist Business flow: Check Todo list size")
    public static int getTodoListSize () {
        return todoMain.getTodos_list().size();
    }

    @Step ("Todolist Business flow: Check Completed Todo list size")
    public static int getCompletedTodoListSize () {
        return todoMain.getTodos_completed_list().size();
    }

    @Step ("Todolist Business flow: Add new Todo to the list")
    public static void createTodo(String taskName) {
        UIActions.noWaitSendKeys(todoMain.getCreate_field(), taskName);
        todoMain.getCreate_field().sendKeys(Keys.RETURN);
        saveScreenshot("Add " + taskName, "png");
    }

    @Step ("Todolist Business flow: Add new Todo to the list with a color tag")
    public static void createTodoWithColorTag(String taskName, String color) {
        UIActions.noWaitSendKeys(todoMain.getCreate_field(), taskName);
        UIActions.noWaitClick(todoMain.getTag_selector());
        clickColorTag(color);
        todoMain.getCreate_field().sendKeys(Keys.RETURN);
        saveScreenshot(color.substring(12, color.length()-2).replace("("," ").replace(",", ""), "png");
    }

    @Step ("Todolist Business flow: Click on color tag")
    public static void clickColorTag (String color) {
        for (WebElement elem : todoMain.getTags_list()) {
            if (elem.getAttribute("style").equalsIgnoreCase(color)) {
                elem.click();
                UIActions.noWaitClick(todoMain.getTag_selector());
                break;
            }
        }
    }

    @Step ("Todolist Business flow: Get Task color tag")
    public static String getColorTagByTodoName (String name) {
        return getTodoByText(name).findElement(By.cssSelector("span[class^='tag']")).getAttribute("style");
    }


}
