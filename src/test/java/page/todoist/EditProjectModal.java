package page.todoist;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class EditProjectModal {
    public TextBox projectNameTxtBox = new TextBox(By.id("edit_project_modal_field_name"));
    public Button saveCreationProjectButton = new Button(By.xpath("//footer/button[contains(text(),\"adir\")]"));
    public Button saveEditionProjectButton = new Button(By.xpath("//button[text() = \"Guardar\"]"));

}
