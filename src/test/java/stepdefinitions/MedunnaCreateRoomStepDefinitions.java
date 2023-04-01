package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MedunnaHomePage;
import pages.MedunnaRoomPage;
import utilities.Driver;

public class MedunnaCreateRoomStepDefinitions {

    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
    MedunnaRoomPage medunnaRoomPage = new MedunnaRoomPage();
    public static int roomNumber = Faker.instance().number().numberBetween(1000, 10000);
    @When("user clicks on Items&Titles icon")
    public void user_clicks_on_items_titles_icon() {
        medunnaHomePage.itemsTitles.click();
    }

    @When("user clicks on Room option in an open window")
    public void user_clicks_on_room_option_in_an_open_window() {
        medunnaHomePage.room.click();
    }

    @When("user clicks on Create a new Room button")
    public void user_clicks_on_create_a_new_room_button() {
        medunnaRoomPage.createNewRoomButton.click();
    }

    @When("user enters a valid room number value for Room Number input")
    public void user_enters_a_valid_room_number_value_for_room_number_input() {
        medunnaRoomPage.roomNumber.sendKeys(roomNumber + "");
    }

    @When("user selects DAYCARE option from Room Type dropdown")
    public void user_selects_daycare_option_from_room_type_dropdown() {
        Select select = new Select(medunnaRoomPage.roomType);
        select.selectByVisibleText("DAYCARE");
    }

    @When("user clicks on Status check box")
    public void user_clicks_on_status_check_box() {
        medunnaRoomPage.status.click();
    }

    @When("user enters a valid price value {string} for price input")
    public void user_enters_a_valid_price_value_for_price_input(String string) {
        medunnaRoomPage.roomPrice.sendKeys(string);
    }

    @When("user enters a valid description value {string} for description input")
    public void user_enters_a_valid_description_value_for_description_input(String string) {
        medunnaRoomPage.description.sendKeys(string);
    }

    @When("user clicks on Save button")
    public void user_clicks_on_save_button() {
        medunnaRoomPage.saveButton.click();
    }

    @Then("user should see A new Room is created with identifier message {string}")
    public void user_should_see_a_new_room_is_created_with_identifier_message(String string) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(medunnaRoomPage.message));
        Assert.assertTrue(medunnaRoomPage.message.isDisplayed());
    }

    @Then("user closes the application")
    public void user_closes_the_application() {
        Driver.closeDriver();
    }

}
