import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredTestExample {

    public String host1 = "http://www.interia.pl";
    public String host2 = "https://ipinfo.io/8.8.8.8";

    @Test
    public void firstTest(){
        given().when().get(host1).then().statusCode(200);
    }

    @Test
    public void secondTest(){
        given().contentType(ContentType.JSON).when()
                .get(host2).then().assertThat()
                .body("region", containsStringIgnoringCase("california"));
    }

    @Test
    public void thirdTest(){
        given().contentType(ContentType.JSON).when()
                .get(host2).then().assertThat()
                .body("region", equalTo("California"));
    }
}
