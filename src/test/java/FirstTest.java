import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class FirstTest {

    public String host = "http://www.interia.pl";

    @Test
    public void firstTestExample(){
        given().when().get(host).then().statusCode(200);
    }
}
