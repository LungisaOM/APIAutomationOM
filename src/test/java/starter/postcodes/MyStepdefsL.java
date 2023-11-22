package starter.postcodes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.SerenityTestClass.Pet;

import static net.serenitybdd.rest.RestRequests.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static net.serenitybdd.rest.SerenityRest.when;

public class MyStepdefsL {
    @Given("Kitty is available in the pet store")
    public Long kittyIsAvailableInThePetStore() {


        Pet pet = new Pet("Kitty", "available");

        Long newId = given().relaxedHTTPSValidation()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/pet")
                .body(pet, ObjectMapperType.GSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON).post().getBody().as(Pet.class, ObjectMapperType.GSON).getId();
        return newId;
    }

    @When("I ask for a pet using Kitty's ID")
    public void iAskForAPetUsingKittySID() {
        when().get("/" + 2);
    }

    @Then("I get Kitty as result")
    public void iGetKittyAsResult() {

        then().body("name", Matchers.equalTo("doggie"));
        then().body("status",Matchers.equalTo("available"));

            }

//    @Given("Get available pet in the store")
//    public void getAvailablePetInTheStore() {
//        SerenityRest.given()
//                .pathParam("postcode", postcode)
//                .pathParam("country", country)
//                .get(LOCATION_BY_POST_CODE_AND_COUNTRY);
//
//    }

//    @When("Check the response code ok")
//    public void checkTheResponseCodeOk() {
//    }
}
