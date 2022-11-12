package page.todoist;

import control.Button;
import control.Label;
import control.TextBox;
import org.openqa.selenium.By;
import session.Session;

public class WorkSection {
    public Button addWorkButton = new Button(By.xpath("//button[@data-add-task-navigation-element = 'true']"));
    public TextBox addEditNameWorkTxtBox = new TextBox(By.xpath("//div[contains(@class,'public-DraftStyleDefault-block')]"));
    public TextBox addEditDescriptionWorkTxtBox = new TextBox(By.xpath("//textarea[contains(@class,'description_field')]"));
    public Button saveWorkButton = new Button(By.xpath("//button[@data-testid = 'task-editor-submit-button']"));

    public TextBox editWorkDescriptionTxtBox = new TextBox(By.xpath("//div[@data-testid='task-details-modal']//textarea[@placeholder = 'Description']"));
    public Button saveWorkDescriptionButton = new Button(By.xpath("//div[@data-testid='task-details-modal']//button[@data-testid='task-editor-submit-button']"));
    public Button openMoreMenuButton = new Button(By.xpath("//div[@data-testid='task-details-modal']//button[@aria-haspopup='menu']"));
    public Button deleteTaskModalButton = new Button(By.xpath("//div[text()='Delete task…']"));
    public Button closeModalButton = new Button(By.xpath("//button[@aria-label='Close modal']"));

    public boolean isWorkDisplayedInList(String workName){
        Label workSaved = new Label(By.xpath("//div[text() = '" + workName+ "']"));
        return workSaved.isControlDisplayed();
    }

    public void clickOnWork(String workName){
        new Label(By.xpath("//div[text() = '" + workName+ "']")).click();

    }
    public void editWork(String workName){
        new Button(By.xpath("//div[@aria-label='Task name']/div[@class = 'markdown_content task_content' and text()='" + workName + "']")).click();
    }

}
