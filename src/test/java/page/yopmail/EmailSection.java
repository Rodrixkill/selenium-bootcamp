package page.yopmail;

import control.Label;
import control.TextBox;
import org.openqa.selenium.By;
import session.Session;

public class EmailSection {
    public TextBox destinataryTxtBox = new TextBox(By.id("msgto"));
    public TextBox subjectTxtBox = new TextBox(By.id("msgsubject"));
    public TextBox bodyTxtBox = new TextBox(By.id("msgbody"));
    public TextBox sendTxtBox = new TextBox(By.id("msgsend"));
    public Label msgSentLabel = new Label(By.id("msgpopmsg"));
    public Label iframeMsg = new Label(By.id("ifmail"));
    // Enter the iframe ifmail
    public void enterIframeEmail(){
        Session.getInstance().enterIframe("ifmail");
    }

}
