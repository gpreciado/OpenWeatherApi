package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class ApiTests {

	
		static WebDriver driver;
		Response resp;
		int code;
		
		
		//Valid Request by City Name
		@Given("^I'm using the OpenWeatherMap Api$")
		public void i_m_using_the_OpenWeatherMap_Api() {
			System.setProperty("webdriver.gecko.driver", "/Users/gabrielpreciado/Downloads/Automation Folder/geckodriver");
		    driver = new FirefoxDriver();
		    //driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		@When("^I make a valid Api request by City name$")
		public void i_make_a_valid_Api_request_by_City_name() {
			resp = RestAssured.get("https://openweathermap.org/data/2.5/forecast/daily?id=524901&lang=zh_cn&appid=09859eb585c0b5887a4574b672da642b");
			
		}

		@Then("^I get a valid response with Code(\\d+)$")
		public void i_get_a_valid_response_with_Code(int arg1) {
			code = resp.getStatusCode();
			System.out.println("Status code is: " + code);
			
			Assert.assertEquals(200, code);
						
			throw new PendingException();
		}

		//Valid Api Request by City Id
		
		@Given("^I'm using the OpenWeatherMap Api$")
		public void i_m_using_the_OpenWeatherMap_Api() {
			System.setProperty("webdriver.gecko.driver", "/Users/gabrielpreciado/Downloads/Automation Folder/geckodriver");
		    driver = new FirefoxDriver();
		    //driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@When("^I make a valid Api request by City name$")
		public void i_make_a_valid_Api_request_by_City_Id() {
			resp = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?id=2172798&appid=637b12e57ae47a00e6d7d07695068939");
			
		}
		
		@Then("^I get a valid response with Code200(\\d+)$")
		public void i_get_a_valid_response_with_City_Id() {
			code = resp.getStatusCode();
			System.out.println("Status code is: " + code);
			
			Assert.assertEquals(200, code);
						
			driver.close();
		}
		
		//Valid Api Request with Geographic Coordinates
		@Given("^I'm using the OpenWeatherMap Api$")
		public void i_m_using_the_OpenWeatherMap_Api() {
			System.setProperty("webdriver.gecko.driver", "/Users/gabrielpreciado/Downloads/Automation Folder/geckodriver");
		    driver = new FirefoxDriver();
		    //driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@When("^I make a valid Api request by Geographic Coordinates$")
		public void i_make_a_valid_Api_request_by_City_Geographic_Coordinates() {
			resp = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=637b12e57ae47a00e6d7d07695068939");
			
		}
		
		@Then("^I get a valid response with Code200(\\d+)$")
		public void i_get_a_valid_response_with_Geographic_Coordinates() {
			code = resp.getStatusCode();
			System.out.println("Status code is: " + code);
			
			Assert.assertEquals(200, code);
						
			driver.close();
		}
		
		//Invalid Request with wrong or missing Api Id Key
		@Given("^I'm using the OpenWeatherMap Api$")
		public void i_m_using_the_OpenWeatherMap_Api() {
			System.setProperty("webdriver.gecko.driver", "/Users/gabrielpreciado/Downloads/Automation Folder/geckodriver");
		    driver = new FirefoxDriver();
		    //driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@When("^I make an invalid Api request$")
		public void i_make_an_invalid_Api_request() {
			resp = RestAssured.get("https://openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=xxxxxxxxxx");
			
		}
		
		@Then("^I get a valid response with Code200(\\d+)$")
		public void i_get_an_invalid_response() {
			code = resp.getStatusCode();
			System.out.println("Status code is: " + code);
			
			Assert.assertEquals(401, code);
						
			driver.close();
		}



		

}

