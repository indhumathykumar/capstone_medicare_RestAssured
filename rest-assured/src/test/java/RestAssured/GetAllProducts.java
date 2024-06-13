package RestAssured;


import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;


public class GetAllProducts
{	
	@Test
	public void getAllProds()
	{
		RestAssured.baseURI = "http://localhost:8080";
		RequestSpecification specification = RestAssured.given();
		io.restassured.response.Response result =    specification.request(Method.GET, "/medicare/show/all/products");	

	
		int statusCode = result.getStatusCode();
       //validating response code
        if (statusCode == 200) {
        	 System.out.println("Status Code: " + statusCode);
        	System.out.println(result.asPrettyString());
    		System.out.println(result.getStatusLine());
    	
        } else {
            System.out.println("Error: Unexpected status code: " + statusCode);
        }
		
	}

}
