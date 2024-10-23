import io.qameta.allure.Feature;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


@Feature("Connect User")
public class ConnectUserTest extends BaseTestSpooner{
    @Test(description= "Get Username and Hash")
    public void testConnectUser(){
        String apiKey = "330506eeafd54d4298ea3256961b4f96";
        String requestBody = "{\n" +
                "    \"username\": \"najihabrl\",\n" +
                "    \"firstName\": \"Najiha\",\n" +
                "    \"lastName\": \"Brilianti\",\n" +
                "    \"email\": \"najihabrilianti@gmail.com\"\n" +
                "}";

        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("apiKey",apiKey)
                .body(requestBody)
                .post("users/connect")
                .then()
                .statusCode(200)
                .extract().response();
    }
}
