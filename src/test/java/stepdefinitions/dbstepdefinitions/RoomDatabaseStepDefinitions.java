package stepdefinitions.dbstepdefinitions;

import io.cucumber.java.en.Given;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static stepdefinitions.MedunnaCreateRoomStepDefinitions.roomNumber;

public class RoomDatabaseStepDefinitions {

    @Given("assert the room with room number")
    public void assert_the_room_with_room_number() throws SQLException {
        //Class.forName() JDBC 4.0 ten beri kullanılmıyor.
        Connection connection = DriverManager.getConnection("jdbc:postgresql://medunna.com:5432/medunna_db_v2", "select_user", "Medunna_pass_@6");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM room ORDER BY created_date DESC");
        List<Integer> roomNumberList = new ArrayList<>();
        while (resultSet.next()){
            roomNumberList.add(resultSet.getInt("room_number"));
        }
        System.out.println("Room Number List: " + roomNumberList);
        System.out.println("Room Number: " + roomNumber);
        assertTrue(roomNumberList.contains(roomNumber));
        //NOTE: Database Navigator(plugin) da aramayi bu sekilde yap:
        //SELECT * FROM "public".room ORDER BY created_date DESC
    }

}
