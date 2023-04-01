package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.MedunnaHomePage;
import pages.MedunnaLoginPage;
import utilities.Driver;

import java.util.List;

public class MedunnaSignInStepDefinitions {

    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
    MedunnaLoginPage medunnaLoginPage = new MedunnaLoginPage();
    @Given("user goes to the url {string}")
    public void user_goes_to_the_url(String string) {
        Driver.getDriver().get(string);
    }

    @When("user clicks on user icon")
    public void user_clicks_on_user_icon() {
        medunnaHomePage.userIcon.click();
    }

    @When("user clicks on Sign in option in an open window")
    public void user_clicks_on_sign_in_option_in_an_open_window() {
        medunnaHomePage.signInOption.click();
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password(io.cucumber.datatable.DataTable dataTable) {
        List<String> credentials = dataTable.row(1);
        medunnaLoginPage.username.sendKeys(credentials.get(0));
        medunnaLoginPage.password.sendKeys(credentials.get(1));
    }

    @When("user clicks on Remember me checkbox")
    public void user_clicks_on_remember_me_checkbox() {
        medunnaLoginPage.rememberMe.click();
    }

    @When("user clicks on Sign in submit button")
    public void user_clicks_on_sign_in_submit_button() {
        medunnaLoginPage.signIn.click();
    }

}
