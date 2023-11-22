package starter.actions;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class NegativePetActions {

    private static String petstoreUri = "https://petstore.swagger.io";


    public void getNegative() {
        SerenityRest.given().basePath("/v2/pet/1").relaxedHTTPSValidation().get(petstoreUri);
    }
    public void responseCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }


}
