package testSuite.todoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.todoist.EditProjectModal;
import utils.GetPropertiesTodoist;

import java.util.Date;

public class CRUDProjectTodoistTest extends TodoistTestBase {

    EditProjectModal editProjectModal = new EditProjectModal();

    @Test
    public void verifyCRUDProject(){
        String projectName = "Proj" + new Date().getTime();
        String updateProjectName = "UpdateProj" + new Date().getTime();

        // Project creation
        mainPage.addProject.click();
        editProjectModal.projectNameTxtBox.setText(projectName);
        editProjectModal.saveProjectButton.click();

        Assertions.assertTrue(mainPage.isProjectDisplayedInList(projectName), "Error! project not created");

        // Project edition
        mainPage.openMoreMenuButton(projectName).click();
        mainPage.editProject.click();
        editProjectModal.projectNameTxtBox.cleanSetText(updateProjectName);
        editProjectModal.saveProjectButton.click();

        Assertions.assertTrue(mainPage.isProjectDisplayedInList(updateProjectName), "Error! project not updated");

        // Project deletion
        mainPage.openMoreMenuButton(updateProjectName).click();
        mainPage.deleteProject.click();
        mainPage.confirmButtonProject.click();

        Assertions.assertFalse(mainPage.isProjectDisplayedInList(updateProjectName), "Error! could not delete a project");

    }
}
