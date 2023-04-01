package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utilities.AuthenticationMedunna.medunnaToken;

public class MedunnaBaseUrl {

    public static RequestSpecification spec;
    public static void medunnaSetUp(){
        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("Authorization", "Bearer " + medunnaToken()).setBaseUri("https://medunna.com").build();
    }

}
