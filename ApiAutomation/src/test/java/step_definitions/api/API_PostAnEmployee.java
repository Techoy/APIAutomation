package step_definitions.api;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class API_PostAnEmployee {

	Response response;

	RequestSpecification request = RestAssured.given();

	Map user;

	@When("^I send a GET request for \"([^\"]*)\"$")
	public void iSendAGETRequestFor(String url) throws Throwable {

		response = given().accept(ContentType.JSON).when().get(url);

	}

	@Then("^Status code is (\\d+)$")
	public void statusCodeIs(int statusCode) throws Throwable {

		Assert.assertEquals(response.statusCode(),statusCode);
	}


	@And("^match response \"([^\"]*)\"$")
	public void matchResponse(String matching) throws Throwable {

		String jsonPath=matching.split("==")[0];
		String excepted=matching.split("==")[1];

		Assert.assertEquals(response.jsonPath().get(jsonPath)+"", excepted);


	}

	@When("^I send the POST request for \"([^\"]*)\"$")
	public void iSendThePOSTRequestFor(String url) throws Throwable {

		request.header("Content-Type", "application/json");

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Vireader");
		requestParams.put("LastName", "Sianagh");

		requestParams.put("UserName", "simpasdfaleuser001");
		requestParams.put("Password", "paasdfsasword1");
		requestParams.put("Email",  "asdaafw@gmail.com");

		response = request.body(requestParams).when().post(url);
	}

}
