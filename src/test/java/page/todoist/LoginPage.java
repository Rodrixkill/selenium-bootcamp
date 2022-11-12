package page.todoist;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class LoginPage {
    public Button loginButton = new Button(By.xpath("//ul/li/a[@href='/auth/login']"));
    public TextBox emailTxtBox = new TextBox(By.id("element-0"));
    public TextBox passTxtBox = new TextBox(By.id("element-3"));
    public Button loginTriggerButton = new Button(By.xpath("//button[@data-gtm-id='start-email-login']"));
}
