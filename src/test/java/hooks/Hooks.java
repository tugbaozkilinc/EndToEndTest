package hooks;

import io.cucumber.java.Before;

import static base_urls.MedunnaBaseUrl.medunnaSetUp;

public class Hooks {

    @Before("@TC01_api")
    public void beforeApi(){
        medunnaSetUp();
    }

}
