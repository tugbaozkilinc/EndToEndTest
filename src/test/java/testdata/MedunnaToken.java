package testdata;

import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MedunnaToken {

    public static String medunnaToken(){
        String url = "https://medunna.com/api/authenticate";
        Map<String, Object> tokenBody = new HashMap<>();
        tokenBody.put("password", "Batch.103");
        tokenBody.put("rememberMe", true);
        tokenBody.put("username", "batch_yuzuc");
        return given().body(tokenBody).contentType(ContentType.JSON).post(url).jsonPath().getString("id_token");
    }

}
