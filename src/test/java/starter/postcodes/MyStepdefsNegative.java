package starter.postcodes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.actions.NegativePetActions;
import starter.actions.PostCodeAPI;

public class MyStepdefsNegative {
    NegativePetActions NegativePetStore ;



    @Given("I do a GET pet from the pet store")
    public void iDoAGetPetFromThePetStore() {
        NegativePetStore.getNegative();
    }

    @When("Get response status")
    public void getResponseStatus() {
        NegativePetStore.responseCode200();
    }

    @Then("I verify if the pet is not availabe")
    public void iVerifyIfThePetIsNotAvailabe() {
    }
}
