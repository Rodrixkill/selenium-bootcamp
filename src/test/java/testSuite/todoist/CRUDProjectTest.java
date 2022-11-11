package testSuite.todoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.todoist.EditProjectModal;

import java.util.Date;

public class CRUDProjectTest extends BaseTest{

    EditProjectModal editProjectModal = new EditProjectModal();

    @Test
    public void verifyCRUDProject(){
        String projectName = "Proj" + new Date().getTime();
        String updateProjectName = "UpdateProj" + new Date().getTime();

        mainPage.addProject.click();
        editProjectModal.projectNameTxtBox.setText(projectName);
        editProjectModal.saveCreationProjectButton.click();

        Assertions.assertTrue(mainPage.isProjectDisplayedInList(projectName), "Error! project not created");

        mainPage.openMoreMenu.click();
        mainPage.editProject.click();
        editProjectModal.projectNameTxtBox.cleanSetText(updateProjectName);
        editProjectModal.saveEditionProjectButton.click();

        Assertions.assertTrue(mainPage.isProjectDisplayedInList(updateProjectName), "Error! project not updated");

        mainPage.openMoreMenu.click();
        mainPage.deleteProject.click();
        mainPage.confirmButtonProject.click();

        Assertions.assertFalse(mainPage.isProjectDisplayedInList(updateProjectName), "Error! could not delete a project");

    }
}
