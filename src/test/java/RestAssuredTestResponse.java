import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.testng.Assert;


public class RestAssuredTestResponse {
    @Test
    public void GetBookDetails()
    {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");
        int statusCode = response.getStatusCode();

        System.out.println(statusCode);
        Assert.assertEquals(statusCode , 200 , "Correct status code returned");

    }
}
