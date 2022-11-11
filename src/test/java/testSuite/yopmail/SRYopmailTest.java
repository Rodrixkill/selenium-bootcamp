package testSuite.yopmail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.yopmail.EmailPage;
import page.yopmail.EmailSection;
import session.Session;
import utils.GetProperties;

import java.util.Date;

public class SRYopmailTest extends TestBase{
    EmailSection emailSection = new EmailSection();
    EmailPage emailPage = new EmailPage();

    @Test
    public void verifySendReceive(){
        String temporalMail = GetProperties.getInstance().getEmail() + new Date().getTime() + "@yopmail.com";
        String emailSubject = "SUBR" + new Date().getTime();
        String emailMsg = "MESSAGER" + new Date().getTime();

        mainPage.temporalMailTxtBox.setText(temporalMail);
        mainPage.enterEmailButton.click();

        emailPage.newMailButton.waitControlIsClickablePage();
        emailPage.newMailButton.click();

        emailSection.iframeMsg.waitControlIsClickablePage();
        emailSection.enterIframeEmail();
        emailSection.destinataryTxtBox.setText(temporalMail);
        emailSection.subjectTxtBox.setText(emailSubject);
        emailSection.bodyTxtBox.setText(emailMsg);
        emailSection.sendTxtBox.click();

        /*
        emailSection.msgSentLabel.waitControlIsInThePage();

        Assertions.assertTrue(emailSection.msgSentLabel.isControlDisplayed(), "ERROR! MESSAGE WAS NOT SENT UI");
        Session.getInstance().outOfIframe();

        */
        Session.getInstance().outOfIframe();

        emailPage.refreshButton.waitControlIsClickablePage();
        emailPage.refreshButton.click();

        emailPage.iframeInbox.waitControlIsClickablePage();
        emailPage.enterIframeInbox();

        Assertions.assertTrue(emailPage.isSubjectDisplayedOnList(emailSubject),"ERROR! THE EMAIL WAS NOT RECEIVED");


    }
}
