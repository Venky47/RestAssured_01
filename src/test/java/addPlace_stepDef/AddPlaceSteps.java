package addPlace_stepDef;

import enums.APIResources;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import resources.TestDataBuilder;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static resources.Utils.getJsonPath;
import static resources.Utils.requestSpecification;

public class AddPlaceSteps {
    public static ResponseSpecification resspec;
    public static RequestSpecification res;
    public static Response response;
    public static JsonPath js;
    public static String placeId;   //static- same placeId will be used per instance
    TestDataBuilder testDataBuilder=new TestDataBuilder();

    @Given("Add place payload")
    public void addPlacePayload() throws IOException {
        res=given().spec(requestSpecification())
                .body(testDataBuilder.addPlacePayload());
        resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

    }

//    @Given("Add place payload with {string} {string} {string}")
//    public void addPlacePayloadWith(String name, String language, String address) throws IOException {
//        res=given().spec(requestSpecification())
//                .body(testDataBuilder.addPlacePayload(name,language,address));
//    }
@Given("Add place payload with {string} {string} {string}")
public void addPlacePayloadWith(String name, String language, String address) throws IOException {
    res=given().spec(requestSpecification())
                .body(testDataBuilder.addPlacePayload(name,language,address));
    resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

}

    @When("user calls {string} with POST http request")
    public void userCallsWithPOSTHttpRequest(String AddPlaceAPI) {
        response=res.when().post("/maps/api/place/add/json")
                .then().spec(resspec).extract().response();
    }

    @When("user calls {string} with {string} http request")
    public void userCallsWithHttpRequest(String resource, String httpMethod) {
        APIResources apiResources=APIResources.valueOf(resource);
//        resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        if(httpMethod.equalsIgnoreCase("POST")){
            response=res.when().post(apiResources.getResources())
                    .then().spec(resspec).extract().response();
        } else if (httpMethod.equalsIgnoreCase("GET")) {
            response=res.when().get(apiResources.getResources())
                    .then().spec(resspec).extract().response();
        }else if (httpMethod.equalsIgnoreCase("PUT")) {
            response = res.when().put(apiResources.getResources())
                    .then().spec(resspec).extract().response();
        }
    }
    @Then("the API call got success with status code {int}")
    public void theAPICallGotSuccessWithStatusCode(int int1) {
        assertEquals(response.getStatusCode(),200);
    }

    @Then("the API call got success with status code {string}")
    public void theAPICallGotSuccessWithStatusCode(String expectedStatusCode) {
        int sc=response.getStatusCode();
        String actualStatusCode=String.valueOf(sc);
        assertEquals(actualStatusCode,expectedStatusCode);
    }

    @And("{string} in response body is {string}")
    public void inResponseBodyIs(String keyValue, String Expectedvalue) {
        assertEquals(getJsonPath(response,keyValue),Expectedvalue);
        System.out.println(Expectedvalue);
    }


    @Then("get the {string}")
    public void getThe(String place_Id) throws IOException {
        String actualResponse=response.asString();
        js=new JsonPath(actualResponse);
        placeId=js.get(place_Id);
        System.out.println("place_Id is "+placeId);
//        given().spec(requestSpecification()).queryParam("place_id",placeId);
//        System.out.println(getJsonPath(response,"name"));

    }

    @Then("verify the {string} is present in the body")
    public void verifyTheIsPresentInTheBody(String name) {
        String actualName=getJsonPath(response,name);
        System.out.println("actual name is "+actualName);
        Assert.assertEquals(actualName,name);
    }

    @Given("delete API payload")
    public void deleteAPIPayload() throws IOException {
        res=given().spec(requestSpecification())
                .body(testDataBuilder.deletePlacePayload(placeId));
        resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

    }
}
