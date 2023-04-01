package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MedunnaLoginPage {

    public MedunnaLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(name = "rememberMe")
    public WebElement rememberMe;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signIn;

}
