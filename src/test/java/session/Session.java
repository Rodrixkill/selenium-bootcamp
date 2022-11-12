package session;

import browser.FactoryBrowser;
import control.Control;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GetProperties;

import java.time.Duration;

public class Session {
    private static Session instance = null;
    private WebDriver browser;
    private Session() {
        browser= FactoryBrowser.make(GetProperties.getInstance().getBrowser()).create();
    }

    public static Session getInstance() {
        if(instance == null)
            instance = new Session();
        return instance;
    }

    public void closeSession() {
        browser.quit();
        instance = null;
    }

    public WebDriver getBrowser() {
        return browser;
    }

    public void acceptAlert(){
        browser.switchTo().alert().accept();
    }

    public void enterIframe(String id){
        browser.switchTo().frame(id);
    }

    public void outOfIframe(){
        browser.switchTo().parentFrame();
    }

}
