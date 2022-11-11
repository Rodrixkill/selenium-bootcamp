package testSuite.todoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.todoist.EditProjectModal;
import page.todoist.WorkSection;

import java.util.Date;

public class CRUDWorkTest extends BaseTest{
    EditProjectModal editProjectModal = new EditProjectModal();
    WorkSection workSection = new WorkSection();

    @Test
    public void verifyCRUDWork(){
        String projectName = "Proj" + new Date().getTime();
        String workName = "Work" + new Date().getTime();
        String updatedWorkName = "UPDWork" + new Date().getTime();
        String workDescription = "Work this is a description" + new Date().getTime();
        String updatedWorkDescription = "Updated description" + new Date().getTime();

        mainPage.addProject.click();
        editProjectModal.projectNameTxtBox.setText(projectName);
        editProjectModal.saveCreationProjectButton.click();

        Assertions.assertTrue(mainPage.isProjectDisplayedInList(projectName), "Error! project not created");

        workSection.addWorkButton.click();
        workSection.addEditNameWorkTxtBox.setText(workName);
        workSection.addEditDescriptionWorkTxtBox.setText(workDescription);
        workSection.saveWorkButton.click();

        Assertions.assertTrue(workSection.isWorkDisplayedInList(workName), "Error! work could not be created");

        workSection.editWorkButton.click();
        workSection.addEditNameWorkTxtBox.setText(updatedWorkName);
        workSection.addEditDescriptionWorkTxtBox.setText(updatedWorkDescription);
        workSection.saveWorkButton.click();

        Assertions.assertTrue(workSection.isWorkDisplayedInList(updatedWorkName), "Error! work could not be updated");

        workSection.moreMenuButton.click();
        workSection.deleteWorkButton.click();
        mainPage.confirmButtonProject.click();

        Assertions.assertFalse(workSection.isWorkDisplayedInList(updatedWorkName), "Error! could not delete a work");

    }
}
