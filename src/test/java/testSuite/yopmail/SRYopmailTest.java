package testSuite.yopmail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.yopmail.EmailPage;
import page.yopmail.EmailSection;
import session.Session;
import utils.GetPropertiesYopmail;

import java.util.Date;

public class SRYopmailTest extends TestBase{
    EmailSection emailSection = new EmailSection();
    EmailPage emailPage = new EmailPage();

    @Test
    public void verifySendReceive() throws InterruptedException {
        String temporalMail = GetPropertiesYopmail.getInstance().getEmail() + new Date().getTime() + "@yopmail.com";
        String emailSubject = "SUBR" + new Date().getTime();
        String emailMsg = "MESSAGER" + new Date().getTime();
        // Create a temporal mail
        mainPage.temporalMailTxtBox.setText(temporalMail);
        mainPage.enterEmailButton.click();
        // Create new mail
        emailPage.newMailButton.waitControlIsClickablePage();
        emailPage.newMailButton.click();
        // Set information for the new mail & send
        emailSection.iframeMsg.waitControlIsClickablePage();
        emailSection.enterIframeEmail();
        emailSection.destinataryTxtBox.waitControlIsInThePage();
        emailSection.destinataryTxtBox.setText(temporalMail);
        emailSection.subjectTxtBox.setText(emailSubject);
        emailSection.bodyTxtBox.setText(emailMsg);
        emailSection.sendTxtBox.click();

        // Verify that the email sent message is displayed
        emailSection.msgSentLabel.waitControlIsInThePage();
        Assertions.assertTrue(emailSection.msgSentLabel.isControlDisplayed(), "ERROR! MESSAGE WAS NOT SENT UI");

        // This wait is necessary because the email takes 1 - 2 seconds to arrive
        Thread.sleep(2000);
        Session.getInstance().outOfIframe();
        // Refresh the inbox
        emailPage.refreshButton.waitControlIsClickablePage();
        emailPage.refreshButton.click();

        emailPage.iframeInbox.waitControlIsClickablePage();
        emailPage.enterIframeInbox();

        // Verify that the email was received by looking at the subject of the message
        Assertions.assertTrue(emailPage.isSubjectDisplayedOnList(emailSubject),"ERROR! THE EMAIL WAS NOT RECEIVED");

    }
}
