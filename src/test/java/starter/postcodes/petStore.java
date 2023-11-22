package starter.postcodes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class petStore {

    private static String endpoint = "http://api.zippopotam.us/{id}";

    @Step("Get location by postcode {0} in country {1}")
    public void fetchLocationByPostCodeAndCountry() {
        SerenityRest.given()
                .pathParam("id", 1)
                .get(endpoint);
    }
    private static String RANDOM_USERS = "https://randomuser.me";
    public void fetchRandomUsers() {
        SerenityRest.given().basePath("/api/").relaxedHTTPSValidation().get(RANDOM_USERS);
    }

    @Given("Get available pet in the store")
    public void getAvailablePetInTheStore() {
//        SerenityRest.given()
//                .pathParam("postcode", postcode)
//                .pathParam("country", country)
//                .get(LOCATION_BY_POST_CODE_AND_COUNTRY);

    }

    @When("Check the response code ok")
    public void checkTheResponseCodeOk() {
    }


}
