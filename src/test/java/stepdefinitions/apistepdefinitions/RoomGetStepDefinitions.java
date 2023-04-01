package stepdefinitions.apistepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.Room;

import java.util.List;

import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.MedunnaCreateRoomStepDefinitions.roomNumber;

public class RoomGetStepDefinitions {

    Response response;
    Room expectedData;
    @Given("user sends get request for room data")
    public void user_sends_get_request_for_room_data() {
        //Set the url
        //https://medunna.com/api/rooms?sort=createdDate,desc
        spec.pathParams("first", "api", "second", "rooms").queryParam("sort", "createdDate,desc");

        //Set the expected data
        expectedData = new Room("What a lovely view!", 200, roomNumber, "DAYCARE", true);
        System.out.println("Expected Data: " + expectedData);

        //Send the request and get the response
        response = given(spec).get("/{first}/{second}");
        response.prettyPrint();
    }

    @Given("user gets the room data and assert the response which he gets with get request")
    public void user_gets_the_room_data_and_assert_the_response_which_he_gets_with_get_request() {
        //Do assertion
        assertEquals(200, response.statusCode());
        JsonPath jsonPath = response.jsonPath();
        List<Integer> roomNumberList = jsonPath.getList("roomNumber");
        System.out.println("Room Number List: " + roomNumberList);
        assertTrue(roomNumberList.contains(roomNumber));

        assertTrue(jsonPath.getList("roomType").contains(expectedData.getRoomType()));
        assertTrue(jsonPath.getList("status").contains(expectedData.isStatus()));
        assertTrue(jsonPath.getList("description").contains(expectedData.getDescription()));
    }

}
