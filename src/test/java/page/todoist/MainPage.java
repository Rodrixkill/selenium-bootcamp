package page.todoist;

import control.Button;
import control.Label;
import org.openqa.selenium.By;

public class MainPage {
    public Button addProject = new Button(By.xpath("//button[@aria-label = 'Add project']"));
    public Button editProject = new Button(By.xpath("//div[text() = 'Edit project']"));

    public Button deleteProject = new Button(By.xpath("//div[text() = 'Delete project']"));
    public Button confirmButtonProject = new Button(By.xpath("//span[text() = 'Delete']"));

    public Label getProjectNameLabel(String projectName){
        return new Label(By.xpath("//span[text() = '" + projectName+ "']"));
    }

    public boolean isProjectDisplayedInList(String projectName){
        Label projectCreated = new Label(By.xpath("//span[text() = '" + projectName+ "']"));
        return projectCreated.isControlDisplayed();
    }

    public Button openMoreMenuButton(String projectName){
        return new Button(By.xpath("//a[contains(@aria-label,'" + projectName + "')]/following-sibling::div/button"));
    }
}
