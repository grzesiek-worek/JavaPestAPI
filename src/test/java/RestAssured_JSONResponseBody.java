import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.testng.Assert;


public class RestAssured_JSONResponseBody {
    @Test
    public void IPMessageBody()
    {
        RestAssured.baseURI = "https://ipinfo.io/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("86.10.4.126");

        ResponseBody body = response.getBody();

        System.out.println("Response Body is: " + body.asString());

        String bodyAsString = body.asString();
        Assert.assertEquals(bodyAsString.toLowerCase().contains("acklam") , true , "Response body contains Acklam");
    }

    @Test
    public void VerifyRegionInJsonResponse()
    {
        RestAssured.baseURI = "https://ipinfo.io/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("86.10.4.126");

        JsonPath jsonPathEvaluator = response.jsonPath();
        String region = jsonPathEvaluator.get("region");
        System.out.println("Region received from Response " + region);
        Assert.assertEquals(region, "England", "Correct region name received in the Response");
    }

    @Test
    public void DisplayFewNodesInIPInfoAPI()
    {
        RestAssured.baseURI = "https://ipinfo.io/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("86.10.4.126");

        JsonPath jsonPathEvaluator = response.jsonPath();
        System.out.println("IP received from Response " + jsonPathEvaluator.get("ip"));
        System.out.println("City received from Response " + jsonPathEvaluator.get("city"));
        System.out.println("Region received from Response " + jsonPathEvaluator.get("region"));
        System.out.println("Timezone description received from Response " + jsonPathEvaluator.get("timezone"));
    }
}
