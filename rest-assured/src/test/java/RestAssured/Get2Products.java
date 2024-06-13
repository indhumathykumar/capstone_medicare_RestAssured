package RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Get2Products {

	@Test
	public void get2Products() {
		RestAssured.baseURI = "http://localhost:8080";

		// Send GET request and get the response
		Response response = RestAssured.given().when().get("/medicare/show/category/2/products").then().extract()
				.response();
		ResponseBody body = response.getBody();
		// Validate the status code
		response.then().statusCode(200);

		String bodyAsString = body.asString();
		Assert.assertEquals(bodyAsString.contains("Analgesics"), true, "Response body contains Analgesics");

		int statusCode = response.getStatusCode();

		if (statusCode == 200) {
			System.out.println(response.asPrettyString());
			System.out.println(response.getStatusLine());
			System.out.println("Response contains Analgesics");
			System.out.println("Status Code: " + statusCode);

		} else {
			System.out.println("Error: Unexpected status code: " + statusCode);
		}
	}

}
