package stepdefinitions.apistepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojos.Room;
import testdata.ObjectMapperUtils;

import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class RoomCreationStepDefinitions {

    Response response;
    Room expectedData;
    @Given("user sends post request for room data")
    public void user_sends_post_request_for_room_data() {
        //Set the url
        spec.pathParams("first", "api", "second", "rooms");

        //Set the expected data
        expectedData = new Room("Beautiful Room", 100, 4568, "TWIN", true);
        System.out.println("Expected Data: " + expectedData);

        //Send the request and get the response
        response = given(spec).body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
    }

    @Then("user gets the room data and assert the data")
    public void user_gets_the_room_data_and_assert_the_data() {
        //Do assertion
        Room actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), Room.class);
        System.out.println("Actual Data: " + actualData);
        assertEquals(201, response.statusCode());
        assertEquals(expectedData.getDescription(), actualData.getDescription());
        assertEquals(expectedData.getPrice(), actualData.getPrice());
        assertEquals(expectedData.getRoomNumber(), actualData.getRoomNumber());
        assertEquals(expectedData.getRoomType(), actualData.getRoomType());
        assertEquals(expectedData.isStatus(), actualData.isStatus());
    }

}
