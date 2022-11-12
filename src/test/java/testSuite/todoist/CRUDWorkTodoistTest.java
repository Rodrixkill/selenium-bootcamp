package testSuite.todoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.todoist.EditProjectModal;
import page.todoist.WorkSection;

import java.util.Date;

public class CRUDWorkTodoistTest extends TodoistTestBase {
    EditProjectModal editProjectModal = new EditProjectModal();
    WorkSection workSection = new WorkSection();

    @Test
    public void verifyCRUDWork(){
        String projectName = "Proj" + new Date().getTime();
        String workName = "Work" + new Date().getTime();
        String workDescription = "Work this is a description" + new Date().getTime();
        String updatedWorkDescription = "Updated description" + new Date().getTime();

        // Project creation
        mainPage.addProject.click();
        editProjectModal.projectNameTxtBox.setText(projectName);
        editProjectModal.saveProjectButton.click();

        Assertions.assertTrue(mainPage.isProjectDisplayedInList(projectName), "Error! project not created");

        // Work creation
        workSection.addWorkButton.click();
        workSection.addNameWorkTxtBox.setText(workName);
        workSection.addDescriptionWorkTxtBox.setText(workDescription);
        workSection.saveWorkButton.click();

        Assertions.assertTrue(workSection.isWorkDisplayedInList(workName), "Error! work could not be created");

        // Work edition
        workSection.clickOnWork(workName);
        workSection.editWork(workName);
        workSection.editWorkDescriptionTxtBox.cleanSetText(updatedWorkDescription);
        workSection.saveWorkDescriptionButton.click();
        workSection.closeModalButton.click();

        Assertions.assertTrue(workSection.isWorkDisplayedInList(updatedWorkDescription), "Error! work could not be updated");

        // Work deletion
        workSection.clickOnWork(updatedWorkDescription);
        workSection.openMoreMenuButton.click();
        workSection.deleteTaskModalButton.click();
        mainPage.confirmButtonProject.click();

        Assertions.assertFalse(workSection.isWorkDisplayedInList(updatedWorkDescription), "Error! could not delete a work");

    }
}
