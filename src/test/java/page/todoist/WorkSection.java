package page.todoist;

import control.Button;
import control.Label;
import control.TextBox;
import org.openqa.selenium.By;

public class WorkSection {
    public Button addWorkButton = new Button(By.xpath("//button[@data-add-task-navigation-element = 'true']"));
    public Button editWorkButton = new Button(By.xpath("//button[@aria-label='Editar']"));
    public Button moreMenuButton = new Button(By.xpath("//button[@data-testid='more_menu']"));
    public Button deleteWorkButton = new Button(By.xpath("//div[text()='Eliminar tarea']"));
    public TextBox addEditNameWorkTxtBox = new TextBox(By.xpath("//div[contains(@class,'public-DraftStyleDefault-block')]"));
    public TextBox addEditDescriptionWorkTxtBox = new TextBox(By.xpath("//textarea[contains(@class,'description_field')]"));
    public Button saveWorkButton = new Button(By.xpath("//button[@data-testid = 'task-editor-submit-button']"));

    public boolean isWorkDisplayedInList(String workName){
        Label workSaved = new Label(By.xpath("//div[text() = '" + workName+ "']"));
        return workSaved.isControlDisplayed();
    }
}
