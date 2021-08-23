package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {

    @FindBy(css = "input[placeholder='Create a task']")
    public WebElement create_field;

    @FindBy(css = "div[class*='button']")
    public WebElement sort_button;

//    @FindBy(css = "div.wrapper_7gdK1.content_1bjOR div")
//    public List<WebElement> sort_options;

    // UnCompleted Todos
    @FindBy(css = "div[class*='taskWrapper']")
    public List<WebElement> todos_list;

    // Completed Todos
    @FindBy(css = "div[class*='completed']")
    public List<WebElement> todos_completed_list;

    // Color Tag Selector
    @FindBy(css = "div[class^='tagSelector']")
    public WebElement tag_selector;

    // Color Tag Options
    @FindBy(css = "div[class^='tagSelector'] div[class^='wrapper'] div span")
    public List<WebElement> tags_list;

    // Toggle All Completed
    @FindBy(css = "div[class*='allCompleted']")
    public WebElement toggle_all_completed;
}
