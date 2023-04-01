package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MedunnaRoomPage {

    public MedunnaRoomPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Create a new Room")
    public WebElement createNewRoomButton;

    @FindBy(name = "roomNumber")
    public WebElement roomNumber;

    @FindBy(id = "room-roomType")
    public WebElement roomType;

    @FindBy(name = "status")
    public WebElement status;

    @FindBy(id = "room-price")
    public WebElement roomPrice;

    @FindBy(id = "room-description")
    public WebElement description;

    @FindBy(xpath = "//span[.='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[contains(text(), 'A new Room is created with identifier')]")
    public WebElement message;

    @FindBy(xpath = "//span[.='Created Date']")
    public WebElement createdDate;

    @FindBy(xpath = "//tbody//td[2]")
    public List<WebElement> roomNumberList;

    @FindBy(xpath = "//table//tbody/tr[1]/td[1]")
    public WebElement firstId;

}
