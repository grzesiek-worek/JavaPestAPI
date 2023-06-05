import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

public class RestAssured_ResponseHeader {

    @Test
    public void IteratingHeaders()
    { RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");
        Headers allHeaders = response.headers();
        for(Header header : allHeaders) {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }
    }
}
