package starter.postcodes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.actions.PostCodeAPI;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class PostCodeStepDefinitions {

    @Steps
    PostCodeAPI postCodeAPI;

    @When("I look up a post code for country code")
    public void lookUpAPostCode() {
        postCodeAPI.fetchLocationByPostCodeAndCountry("10000", "US");
    }

    @Then("the resulting location should be in a Country")
    public void theResultingLocationShouldBe() {
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body(LocationResponse.COUNTRY, equalTo("United States")));
        restAssuredThat(response -> response.body(LocationResponse.FIRST_PLACE_NAME, equalTo("New York City")));
    }
    @And("the results should have a correct State abbr")
    public void theResultingAbbrShouldBe() {
//         restAssuredThat(response -> response.body(LocationResponse.FIRST_PLACE_NAME, equalTo("New York City")));
        restAssuredThat(response -> response.body(LocationResponse.COUNTRY_ABBR, equalTo("U111")));

    }

    @Given("I Set POST service api endpoint")
    public void iSetPOSTServiceApiEndpoint() {
       postCodeAPI.fetchRandomUsers();
    }


    @When("Send a POST HTTP request")
    public void sendAPOSTHTTPRequest() {
        restAssuredThat(response -> response.statusCode(200));
        System.out.println(lastResponse().toString());
    }

    @Then("I receive valid Response")
    public void iReceiveValidResponse() {

        System.out.println(lastResponse().toString());

    }
}
