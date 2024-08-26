package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class Testflow {
    @Given("testing the flow")
    public void testing_the_flow() {
        System.out.println("testing successful");
    }

    @And("second flow")
    public void secondFlow() {
        System.out.println("second flow done successfully");
    }


}
