package hooks;


import addPlace_stepDef.AddPlaceSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static resources.Utils.requestSpecification;

//pre and post condition- which runs before and after each cucumber scenarios
public class Hooks {
/*will run before the @DeletePlace api scenario if place id is null,
* Similarly, we can add other tags based on the condition
* If it applicable for whole scenarios. then do not mention the tag
* */
    @Before("@DeletePlace")
    public void beforeScenarios() throws IOException {
        AddPlaceSteps addPlaceSteps=new AddPlaceSteps();
        if(AddPlaceSteps.placeId==null){ //this will execute only if placeId id null
          addPlaceSteps.addPlacePayloadWith("Chiru","English","Bngalore");
          addPlaceSteps.userCallsWithHttpRequest("AddPlaceAPI","POST");
          addPlaceSteps.verifyTheIsPresentInTheBody("Chiru");
        }
    }

    @After("@DeletePlace")
    public void afterScenarios(){
        System.out.println("after hook");
    }

}
