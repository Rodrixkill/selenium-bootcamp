package page.yopmail;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class MainPage {
    public TextBox temporalMailTxtBox = new TextBox(By.id("login"));
    public Button enterEmailButton = new Button(By.xpath("//div[@id=\"refreshbut\"]/button"));

}
