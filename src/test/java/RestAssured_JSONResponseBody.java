import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;


public class RestAssured_JSONResponseBody {
    @Test
    public void IPMessageBody()
    {
        RestAssured.baseURI = "https://ipinfo.io/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("86.10.4.126");

        ResponseBody body = response.getBody();

        System.out.println("Response Body is: " + body.asString());


    }

}
