package testSuite.todoist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.todoist.LoginPage;
import page.todoist.MainPage;
import session.Session;
import utils.GetPropertiesTodoist;

public class TodoistTestBase {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    @BeforeEach
    public void openBrowser(){
        Session.getInstance().getBrowser().get(GetPropertiesTodoist.getInstance().getHost());
        // Login performed for each test
        loginPage.loginButton.click();
        loginPage.emailTxtBox.isControlDisplayed();
        loginPage.emailTxtBox.setText(GetPropertiesTodoist.getInstance().getEmail());
        loginPage.passTxtBox.setText(GetPropertiesTodoist.getInstance().getPassword());
        loginPage.loginTriggerButton.click();
    }

    @AfterEach
    public void closeBrowser(){
        Session.getInstance().closeSession();
    }
}
