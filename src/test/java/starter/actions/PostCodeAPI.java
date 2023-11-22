package starter.actions;

import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PostCodeAPI {

    private static String LOCATION_BY_POST_CODE_AND_COUNTRY = "http://api.zippopotam.us/{country}/{postcode}";

    @Step("Get location by postcode in country ")
    public void fetchLocationByPostCodeAndCountry(String postcode, String country) {
        SerenityRest.given()
                .pathParam("postcode", postcode)
                .pathParam("country", country)
                .get(LOCATION_BY_POST_CODE_AND_COUNTRY);
    }
    private static String RANDOM_USERS = "https://randomuser.me";
    public void fetchRandomUsers() {
        SerenityRest.given().basePath("/api/").relaxedHTTPSValidation().get(RANDOM_USERS);
    }


}
