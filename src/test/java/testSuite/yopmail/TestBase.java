package testSuite.yopmail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.yopmail.MainPage;
import session.Session;
import utils.GetProperties;

public class TestBase {
    MainPage mainPage = new MainPage();

    @BeforeEach
    public void openBrowser(){
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }

    @AfterEach
    public void closeBrowser(){ //Session.getInstance().closeSession();
    }
}
