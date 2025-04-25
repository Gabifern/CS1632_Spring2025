package edu.pitt.cs;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PitcherStepDefinitions {
    private Pitcher pitcher;
    
    @Given("a Pitcher")
    public void aPitcher() {
        // Write code here that turns the phrase above into concrete actions
        pitcher = new Pitcher();
    }

@When("I add {int} stress to pitcher")
    public void iAddStressToPitcher(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
    pitcher.addStress(int1);
}

@Then("getStress returns {int}")
    public void getStressReturns(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
    assertEquals((int)int1, pitcher.getStress());
}

}
