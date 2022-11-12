package page.todoist;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class EditProjectModal {
    public TextBox projectNameTxtBox = new TextBox(By.id("edit_project_modal_field_name"));
    public Button saveProjectButton = new Button(By.xpath("//footer[@class='reactist_modal_box__actions']/button[@type='submit']"));

}
