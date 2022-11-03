package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BasicSeleniumTest {

    WebDriver driver;
    Actions builder;

    @BeforeEach
    public void setup(){
        System.out.println("setup");
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://todo.ly/");
        builder = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    public void cleanup() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void verifyCRUDTarea() throws InterruptedException {
        // login
        driver.findElement(By.xpath(LocatorsTodoLy.login)).click();
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("bootcamp@mojix44.com");
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        Thread.sleep(2000);

        Assertions.assertTrue(driver.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).isDisplayed()
                ,"ERROR login was incorrect");

        String nameProject="RodriMojix"+new Date().getTime();
        driver.findElement(By.xpath("//td[text()='Add New Project']")).click();
        driver.findElement(By.id("NewProjNameInput")).sendKeys(nameProject);
        Thread.sleep(2000);
        driver.findElement(By.id("NewProjNameButton")).click();
        Thread.sleep(2000);
        int actualResult=driver.findElements(By.xpath(" //td[text()='"+nameProject+"'] ")).size();
        Assertions.assertTrue(actualResult >= 1
                ,"ERROR The project was not created");

        String nameItem = "Rodrigo" + new Date().getTime();
        driver.findElement(By.id("NewItemContentInput")).sendKeys(nameItem);
        driver.findElement(By.id("NewItemAddButton")).click();
        Thread.sleep(1000);

        actualResult = driver.findElements(By.xpath("//div[text()='" + nameItem + "']")).size();
        Assertions.assertTrue(actualResult >= 1, "Error The work was not created");

        driver.findElement(By.xpath("//div[text()='" + nameItem + "']")).click();
        nameItem = "Updated" + new Date().getTime();
        driver.findElement(By.id("ItemEditTextbox")).clear();
        driver.findElement(By.id("ItemEditTextbox")).sendKeys(nameItem);
        // builder.moveToElement(driver.findElement(By.id("ItemEditTextbox")), 10, 25).click().build().perform();
        // This button doesn't save BUG
        driver.findElement(By.xpath("//div[@class='ItemContentDiv UnderEditingItem']/div/img[@id='ItemEditSubmit']")).click();
        Thread.sleep(5000);

        actualResult = driver.findElements(By.xpath("//td/div[text()='" + nameItem + "']")).size();
        System.out.println("HOLA" + actualResult);
        Assertions.assertTrue(actualResult >= 1, "Error The work was not updated");

    }

    @Test
    public void verifyCRUDProject() throws InterruptedException {
        // login
        driver.findElement(By.xpath("//img[contains(@src,'pagelogin')]")).click();
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("bootcamp@mojix44.com");
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        Thread.sleep(1000);
        Assertions.assertTrue(driver.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).isDisplayed()
                ,"ERROR login was incorrect");

        // create
        String nameProject="Mojix"+new Date().getTime();
        driver.findElement(By.xpath("//td[text()='Add New Project']")).click();
        driver.findElement(By.id("NewProjNameInput")).sendKeys(nameProject);
        driver.findElement(By.id("NewProjNameButton")).click();
        Thread.sleep(1000);
        int actualResult=driver.findElements(By.xpath(" //td[text()='"+nameProject+"'] ")).size();
        Assertions.assertTrue(actualResult >= 1
                ,"ERROR The project was not created");

        nameProject="Update"+new Date().getTime();
        // update
        driver.findElement(By.xpath("//div[contains(@style,'block')]/img")).click();
        driver.findElement(By.xpath("//ul[@id=\"projectContextMenu\"]//a[text()='Edit']")).click();
        driver.findElement(By.xpath("//td/div/input[@id='ItemEditTextbox']")).clear();
        driver.findElement(By.xpath("//td/div/input[@id='ItemEditTextbox']")).sendKeys(nameProject);
        driver.findElement(By.xpath("//td/div/img[@id='ItemEditSubmit']")).click();
        Thread.sleep(1000);
        actualResult=driver.findElements(By.xpath(" //td[text()='"+nameProject+"'] ")).size();
        Assertions.assertTrue(actualResult >= 1
                ,"ERROR The project was not updated");

        // delete
        driver.findElement(By.xpath("//div[contains(@style,'block')]/img")).click();
        driver.findElement(By.id("ProjShareMenuDel")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        actualResult=driver.findElements(By.xpath(" //td[text()='"+nameProject+"'] ")).size();
        Assertions.assertTrue(actualResult == 0
                ,"ERROR The project was not removed");
    }

}
