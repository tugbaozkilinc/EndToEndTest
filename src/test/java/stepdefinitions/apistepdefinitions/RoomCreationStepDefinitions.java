package stepdefinitions.apistepdefinitions;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.Room;
import utilities.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class RoomCreationStepDefinitions {

    int roomNumber = Faker.instance().number().numberBetween(1000, 1000000);
    Response response;
    Room expectedData;
    @Given("user sends post request for room data")
    public void user_sends_post_request_for_room_data() {
        //Set the url
        spec.pathParams("first", "api", "second", "rooms");

        //Set the expected data
        expectedData = new Room("Beautiful Room", 100, roomNumber, "TWIN", true);
        System.out.println("Expected Data: " + expectedData);

        //Send the request and get the response
        response = given(spec).body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
    }

    @Then("user gets the room data and assert the data")
    public void user_gets_the_room_data_and_assert_the_data() {
        //Do assertion
        //1. yol:
        Room actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), Room.class);
        System.out.println("Actual Data: " + actualData);
        assertEquals(201, response.statusCode());
        assertEquals(expectedData.getDescription(), actualData.getDescription());
        assertEquals(expectedData.getPrice(), actualData.getPrice());
        assertEquals(expectedData.getRoomNumber(), actualData.getRoomNumber());
        assertEquals(expectedData.getRoomType(), actualData.getRoomType());
        assertEquals(expectedData.isStatus(), actualData.isStatus());

        //2. yol:
        response.then().body("roomNumber", equalTo(roomNumber), "roomType", equalTo("TWIN"), "status", equalTo(true), "price", equalTo(100),
                                  "description", equalTo("Beautiful Room"));
        //3. yol:
        JsonPath jsonPath = response.jsonPath();
        assertEquals((int)expectedData.getRoomNumber(), jsonPath.getInt("roomNumber"));
        assertEquals(expectedData.getRoomType(), jsonPath.getString("roomType"));
        assertEquals(expectedData.isStatus(), jsonPath.getBoolean("status"));
        assertEquals((int)expectedData.getPrice(), jsonPath.getInt("price"));
        assertEquals(expectedData.getDescription(), jsonPath.getString("description"));

        //4. yol
        Map<String, Object> actualDataMap = response.as(HashMap.class);
        assertEquals(expectedData.getRoomNumber(), actualDataMap.get("roomNumber"));
        assertEquals(expectedData.getRoomType(), actualDataMap.get("roomType"));
        assertEquals(expectedData.isStatus(), actualDataMap.get("status"));
        assertEquals(expectedData.getPrice(), actualDataMap.get("price"));
        assertEquals(expectedData.getDescription(), actualDataMap.get("description"));

        //5. yol:
        Room actualDataGson = new Gson().fromJson(response.asString(), Room.class); //new ObjectMapper().readValue(response.asString(), Room.class);
        assertEquals(expectedData.getDescription(), actualDataGson.getDescription());
        assertEquals(expectedData.getPrice(), actualDataGson.getPrice());
        assertEquals(expectedData.getRoomNumber(), actualDataGson.getRoomNumber());
        assertEquals(expectedData.getRoomType(), actualDataGson.getRoomType());
        assertEquals(expectedData.isStatus(), actualDataGson.isStatus());

        //6. yol:
        Room actualDataPojo = response.as(Room.class);
        assertEquals(201, response.statusCode());
        assertEquals(expectedData.getDescription(), actualDataPojo.getDescription());
        assertEquals(expectedData.getPrice(), actualDataPojo.getPrice());
        assertEquals(expectedData.getRoomNumber(), actualDataPojo.getRoomNumber());
        assertEquals(expectedData.getRoomType(), actualDataPojo.getRoomType());
        assertEquals(expectedData.isStatus(), actualDataPojo.isStatus());
    }

}
