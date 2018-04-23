package definitions;

import org.apache.http.client.utils.URIBuilder;

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
	URIBuilder urlb;

	@Given("^I want to open \"([^\"]*)\" endpoint$")
	public void i_want_to_open(String endPoint) throws Exception {
		baseURIAssembled = endPoint;
		
	}
	
	@When("^I use the \"([^\"]*)\" resource$")
	public void i_check_out(String qHandle) throws Exception {
		baseURIAssembled += qHandle;
	}
	/*
	@When("^I try to get \"([^\"]*)\"$")
	public void i_try_to_get(String queryBase) throws Exception {
		
		baseURIAssembled += queryBase;
		System.out.println("The actual request is: " + baseURIAssembled);
		RestAssured.baseURI = baseURIAssembled;
//		httpRequest = RestAssured.given();
//		response = httpRequest.request(Method.GET, baseURIAssembled);
		response = RestAssured.given().get(baseURIAssembled);
        		
	}
	*/
	
	@Given("^trigger the get request$")
	public void trigger_the_get_request() throws Exception {
		response = httpRequest.get(baseURIAssembled);
	}
	
	@When("^add \"([^\"]*)\" parameter as \"([^\"]*)\"$")
	public void add_parameter_as(String param, String val) throws Exception {
		httpRequest = RestAssured.given().param(param, val);
	    
	}
	
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
