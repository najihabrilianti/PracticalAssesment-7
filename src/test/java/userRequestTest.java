import io.qameta.allure.Feature;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Feature("User Module")
public class userRequestTest extends BaseTestUser{

    @Test(priority = 1)
    public void createUser(){
        String requestBody = "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"reginaag\",\n" +
                "  \"firstName\": \"Regina\",\n" +
                "  \"lastName\": \"Ayu\",\n" +
                "  \"email\": \"reginaag@email.com\",\n" +
                "  \"password\": \"passwordrere123\",\n" +
                "  \"phone\": \"123-456-7890\",\n" +
                "  \"userStatus\": 0\n" +
                "}";
        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestBody)
                .log().ifValidationFails()
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract().response();
    }

    @Test(priority = 2)
    public void getUser() {
        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get( "/reginaag")
                .then()
                .statusCode(200)
                .extract().response();
    }
    @Test(priority = 3)
    public void updateUser(){
        String requestBody="{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"rere\",\n" +
                "  \"firstName\": \"Regina\",\n" +
                "  \"lastName\": \"Ayu Gayatri\",\n" +
                "  \"email\": \"rere@email.com\",\n" +
                "  \"password\": \"password\",\n" +
                "  \"phone\": \"9876-543-21\",\n" +
                "  \"userStatus\": 1\n" +
                "}";
        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestBody)
                .log().ifValidationFails()
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract().response();

    }

    @Test(priority = 4)
    public void loginUser(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get("/login?username=rere&password=password")
                .then()
                .statusCode(200)
                .extract().response();
    }

    @Test(priority = 5)
    public void deleteUser(){
        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .delete("/rere") // Menggunakan endpoint untuk menghapus user
                .then()
                .statusCode(200) // Memastikan status code adalah 200
                .extract().response();
    }

    @Test(priority = 6)
    public void logoutUser(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get("/logout")
                .then()
                .statusCode(200)
                .extract().response();
    }
}