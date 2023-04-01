package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MedunnaHomePage {

    public MedunnaHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "account-menu")
    public WebElement userIcon;

    @FindBy(linkText = "Sign in")
    public WebElement signInOption;

    @FindBy(id = "entity-menu")
    public WebElement itemsTitles;

    @FindBy(linkText = "Room")
    public WebElement room;

}
