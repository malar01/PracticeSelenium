package TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;//Main class used to send API requests.
import io.restassured.response.Response;//Stores the API response (status code, body, headers).

public class APITest {
	@Test
	public void verifyUserAPI() {
		//set base url
		//define the base domain ->Base URI → https://jsonplaceholder.typicode.com
		//Endpoint → /users/1
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		//send http GET request
		//Stores full response inside response object.(status code,body,headers,Response Time)
		Response response=RestAssured.get("/users/1");
		//Print full repsonses
		System.out.println("Response Body");
		//This converts response body into String and prints it.
		System.out.println(response.getBody().asString());
		//get status code
		//This extracts HTTP status code from response.
		int statusCode=response.getStatusCode();
		System.out.println("Status Code : "+ statusCode);
		//Assertion
		Assert.assertEquals(statusCode, 200);
		
	}
}
/*Output 
Response Body
{
  "id": 1,
  "name": "Leanne Graham",
  "username": "Bret",
  "email": "Sincere@april.biz",
  "address": {
    "street": "Kulas Light",
    "suite": "Apt. 556",
    "city": "Gwenborough",
    "zipcode": "92998-3874",
    "geo": {
      "lat": "-37.3159",
      "lng": "81.1496"
    }
  },
  "phone": "1-770-736-8031 x56442",
  "website": "hildegard.org",
  "company": {
    "name": "Romaguera-Crona",
    "catchPhrase": "Multi-layered client-server neural-net",
    "bs": "harness real-time e-markets"
  }
}
Status Code : 200
PASSED: TestScripts.APITest.verifyUserAPI
*/