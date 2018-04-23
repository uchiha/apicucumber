package apicucumber;

import cucumber.api.CucumberOptions; //cant be used with cucumber-core 2.4.0
import cucumber.api.testng.AbstractTestNGCucumberTests;


//plugin={"pretty", "html:out.html"},
@CucumberOptions(glue= "definitions", features="src/test/resources/features/initial.feature", tags= {"@specificRestaurant"})
public class RunCukesTest extends AbstractTestNGCucumberTests {

}
