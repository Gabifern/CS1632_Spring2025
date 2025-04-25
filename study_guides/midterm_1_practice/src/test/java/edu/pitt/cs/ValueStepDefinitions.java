package edu.pitt.cs;
import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValueStepDefinitions {
	// TODO: Fill in!
	private Value value;

	@Given("a Value")
    public void aValue() {
        // Write code here that turns the phrase above into concrete actions
        value = new Value();
    }

    //have the time(s) in the parentheses
    @When("I call incVal {int} time(s)")
    public void iCallIncValTimes(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        for (int i = 0; i < int1; i++)
        {
            value.incVal();
        }
    }
    
    @Then("getVal returns {int}")
    public void getValReturns(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals((int)int1, value.getVal()); 
        //need to cast to an int
    }

}
