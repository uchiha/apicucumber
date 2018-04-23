package definitions;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class applicationdefs {
	RequestSpecification httpRequest;
	Response response;
	String baseURIAssembled;
	

	@Given("^I want to open \"([^\"]*)\" endpoint$")
	public void i_want_to_open(String endPoint) throws Exception {
		baseURIAssembled = endPoint;
		
	}
	
	@When("^use the \"([^\"]*)\" resource$")
	public void i_check_out(String qHandle) throws Exception {
		baseURIAssembled += qHandle;
	}
	
	@Given("^trigger the get request$")
	public void trigger_the_get_request() throws Exception {
		response = httpRequest.get(baseURIAssembled);
	}
	
	@When("^I set \"([^\"]*)\" parameter as \"([^\"]*)\"$")
	public void set_parameter_as(String param, String val) throws Exception {
		httpRequest = RestAssured.given().param(param, val);
	    
	}
	
	@When("^add \"([^\"]*)\" parameter as \"([^\"]*)\"$")
	public void add_parameter_as(String param, String val) throws Exception {
		httpRequest = httpRequest.param(param, val);
	    
	}
	
	@Then("^the number of restaurants should be (\\d+)$")
	public void the_number_of_restaurants_should_be(int restaurantCount) throws Exception {
//		System.out.println(">>>" + response.body().jsonPath().getJsonObject("status")); // this works, give out "OK"
//		System.out.println(">>>" + response.body().jsonPath().getJsonObject("results")); //works, but gives out an array
//		List<Object> samples = response.body().jsonPath().getJsonObject("results"); // this approach works
		List<Object> samples = response.body().jsonPath().getList("results"); // this approach works like the previous one
		
		assertEquals(samples.size(), restaurantCount);
	}
	
	@Then("^the first restaurant should be \"([^\"]*)\"$")
	public void the_first_restaurant_should_be(String firstResto) throws Exception {
		ArrayList<Object> samples = response.body().jsonPath().getJsonObject("results");
		
	    /* this thing does not work.. YET!
//	    JSONObject obj = new JSONObject(samples.get(0));
//	    String n = obj.getString("reference");
//	    System.out.println(n);
 */
 
		for (Object object : samples) {
			System.out.println(object.toString());
		}

		
	}

	
	// Below is to test for debug only..
	@Then("^I print out the response$")
	public void i_print_out_the_response() throws Exception {
	    String respBody = response.getBody().asString();
	    System.out.println("Here we go! " + respBody);
	}
	
	@Given("^test it out$")
	public void test_it_out() throws Exception {
		httpRequest = RestAssured.given().
				param("query", "restaurants+in+Sydney").
				param("key", "AIzaSyBLzFAnW-1XE28hZ2BpJxcpGOquAdBZ8sQ");
		
		response = httpRequest.when().get("https://maps.googleapis.com/maps/api/place/textsearch/json");
		
		System.out.println(response.getBody().asString());
				
	}
}
