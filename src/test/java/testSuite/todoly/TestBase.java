package testSuite.todoly;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.todoly.LoginSection;
import page.todoly.MainPage;
import page.todoly.MenuSection;
import page.todoly.ProjectSection;
import session.Session;
import utils.GetProperties;

public class TestBase {
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();
    MenuSection menuSection = new MenuSection();
    ProjectSection projectSection = new ProjectSection();
    // todo property file
    String user= GetProperties.getInstance().getUser();
    String password = GetProperties.getInstance().getPwd();

    @BeforeEach
    public void openBrowser(){
        // todo create property file
        Session.getInstance().getBrowser().get("http://todo.ly/");
    }

    @AfterEach
    public void closeBrowser(){
        Session.getInstance().closeSession();
    }

}
