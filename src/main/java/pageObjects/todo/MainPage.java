package pageObjects.todo;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage {

    // Create new Todo field
    @FindBy(css = "input[placeholder='Create a task']")
    private WebElement create_field;

    @Step("Get Create new Todo field element")
    public WebElement getCreate_field(){
        return create_field;
    }

    // UnCompleted Todos
    @FindBy(css = "div[class*='taskWrapper']")
    private List<WebElement> todos_list;

    @Step("Get Todos element list")
    public List<WebElement> getTodos_list(){
        return todos_list;
    }

    // Completed Todos
    @FindBy(css = "div[class*='completed']")
    private List<WebElement> todos_completed_list;

    @Step("Get Completed Todos element list")
    public List<WebElement> getTodos_completed_list(){
        return todos_completed_list;
    }

    // Color Tag Selector
    @FindBy(css = "div[class^='tagSelector']")
    private WebElement tag_selector;

    @Step("Get Tag selector element")
    public WebElement getTag_selector(){
        return tag_selector;
    }

    // Color Tag Options
    @FindBy(css = "div[class^='tagSelector'] div[class^='wrapper'] div span")
    private List<WebElement> tags_list;

    @Step("Get Tags element list")
    public List<WebElement> getTags_list(){
        return tags_list;
    }

    // Toggle All Completed
    @FindBy(css = "div[class*='allCompleted']")
    private WebElement toggle_all_completed;

    @Step("Get Toggle all element")
    public WebElement getToggle_all_completed(){
        return toggle_all_completed;
    }


}
