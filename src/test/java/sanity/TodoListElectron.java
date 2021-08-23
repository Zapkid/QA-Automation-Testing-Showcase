package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

//@Listeners(utilities.Listeners.class)
public class TodoListElectron extends CommonOps {

    @Test (description = "Add Todo")
    @Description ("Verify Add new Todo item to the list")
    public void Test01_AddTodo() {
        ElectronFlows.createTodo("Learn Quality Assurance");
        ElectronFlows.createTodo("Learn Automation");
        Verifications.verifyInt(ElectronFlows.getTodoListSize(), 2);
    }

    @Test (description = "Complete Todo")
    @Description ("Verify Todo completed")
    public void Test02_CompleteTodo() {
        ElectronFlows.completeTodoByName("Learn Quality Assurance");
        Verifications.verifyInt(ElectronFlows.getCompletedTodoListSize(), 1);
    }

    @Test (description = "Delete Todo")
    @Description ("Verify Todo deleted")
    public void Test03_DeleteTodo() {
        ElectronFlows.deleteTodoByName("Learn Quality Assurance");
        Verifications.verifyInt(ElectronFlows.getCompletedTodoListSize(), 0);
    }

    @Test (description = "Add Todo with Color Tag")
    @Description ("Verify Todo added with a color tag")
    public void Test04_AddTodoWithColorTag() {
        ElectronFlows.createTodoWithColorTag("I have a green color tag", "background: rgb(114, 204, 87);");
        Verifications.verifyString(ElectronFlows.getColorTagByTodoName("I have a green color tag"), "background: rgb(114, 204, 87);");
    }

    @Test (description = "Complete All Todos")
    @Description ("Verify All Todos completed")
    public void Test05_CompleteAllTodos() {
        ElectronFlows.createTodoWithColorTag("Learn Electron Driver", "background: rgb(87, 185, 244);");
        ElectronFlows.completeAllTodos();
        Verifications.verifyInt(ElectronFlows.getCompletedTodoListSize(), 3);
    }
}
