package page.todoist;

import control.Button;
import control.Label;
import org.openqa.selenium.By;

public class MainPage {
    public Button addProject = new Button(By.xpath("//button[contains(@aria-label,\"adir proyecto\")]"));
    public Button openMoreMenu = new Button(By.xpath("//a[contains(@aria-label,'this is a')]/following-sibling::div/button"));
    public Button editProject = new Button(By.xpath("//div[text() = \"Editar proyecto\"]"));
    public Button deleteProject = new Button(By.xpath("//div[text() = \"Eliminar proyecto\"]"));
    public Button confirmButtonProject = new Button(By.xpath("//span[text() = \"Eliminar\"]"));

    public Label getProjectNameLabel(String projectName){
        return new Label(By.xpath("//span[text() = '" + projectName+ "']"));
    }

    public boolean isProjectDisplayedInList(String projectName){
        Label projectCreated = new Label(By.xpath("//span[text() = '" + projectName+ "']"));
        return projectCreated.isControlDisplayed();
    }
}
