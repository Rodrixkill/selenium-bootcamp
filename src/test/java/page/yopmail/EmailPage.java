package page.yopmail;

import control.Button;
import control.Label;
import org.openqa.selenium.By;
import session.Session;

public class EmailPage {
    public Button newMailButton = new Button(By.id("newmail"));
    public Button refreshButton = new Button(By.id("refresh"));
    public Label iframeInbox = new Label(By.id("ifinbox"));

    public boolean isSubjectDisplayedOnList(String subjectReceived){
        Label emailCreated = new Label(By.xpath("//div[text()='"+subjectReceived+"']"));
        emailCreated.waitControlIsClickablePage();
        return emailCreated.isControlDisplayed();
    }

    public boolean isCompleteDisplayedOnList(String emailDestination, String subjectReceived){
        Label emailCreated = new Label(By.xpath("//span[text()='"+emailDestination+"']"));
        Label subjectCreated = new Label(By.xpath("//span[text()='"+subjectReceived+"']"));
        return emailCreated.isControlDisplayed() && subjectCreated.isControlDisplayed();
    }
    public void enterIframeInbox(){
        Session.getInstance().enterIframe("ifinbox");
    }
}
