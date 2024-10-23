//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

@Feature("Recipes")
public class recipesTest extends BaseTestSpooner {
    String apiKey = "330506eeafd54d4298ea3256961b4f96";

    public recipesTest() {
    }

    @Test(
            description = "Test Search Recipes"
    )
    public void searchRecipes() {
        ((ValidatableResponse)((ValidatableResponse)((Response)((RequestSpecification)RestAssured.given().queryParam("apiKey", new Object[]{this.apiKey}).queryParam("query", new Object[]{"pasta"}).queryParam("maxFat", new Object[]{"25"}).queryParam("number", new Object[]{"2"}).log().ifValidationFails()).when().get("/recipes/complexSearch", new Object[0])).then()).statusCode(200)).extract().response();
    }

    @Test(
            description = "Test Search Recipes by Nutrient"
    )
    public void searchRecipesByNutrient() {
        ((ValidatableResponse)((ValidatableResponse)((Response)((RequestSpecification)RestAssured.given().queryParam("apiKey", new Object[]{this.apiKey}).queryParam("minCarbs", new Object[]{"10"}).queryParam("maxCarbs", new Object[]{"50"}).queryParam("number", new Object[]{"2"}).log().ifValidationFails()).when().get("/recipes/findByNutrients", new Object[0])).then()).statusCode(200)).extract().response();
    }

    @Test(
            description = "Test Search Recipes by Ingredients"
    )
    public void searchRecipesByIngredients() {
        ((ValidatableResponse)((ValidatableResponse)((Response)((RequestSpecification)RestAssured.given().queryParam("apiKey", new Object[]{this.apiKey}).queryParam("ingredients", new Object[]{"apple,flour,sugar"}).queryParam("number", new Object[]{"2"}).log().ifValidationFails()).when().get("/recipes/findByIngredients", new Object[0])).then()).statusCode(200)).extract().response();
    }

    @Test(
            description = "Test Get Random Recipes"
    )
    public void getRandomRecipes() {
        ((ValidatableResponse)((ValidatableResponse)((Response)((RequestSpecification)RestAssured.given().queryParam("apiKey", new Object[]{this.apiKey}).queryParam("include-tags", new Object[]{"vegetarian,dessert"}).log().ifValidationFails()).when().get("/recipes/random", new Object[0])).then()).statusCode(200)).extract().response();
    }

    @Test(
            description = "Analyze Recipe"
    )
    public void testAnalyzeRecipe() {
        String requestBody = "{\n    \"title\": \"Spaghetti Carbonara\",\n    \"servings\": 2,\n    \"ingredients\": [\n        \"1 lb spaghetti\",\n        \"3.5 oz pancetta\",\n        \"2 Tbsps olive oil\",\n        \"1  egg\",\n        \"0.5 cup parmesan cheese\"\n    ],\n    \"instructions\": \"Bring a large pot of water to a boil and season generously with salt. Add the pasta to the water once boiling and cook until al dente. Reserve 2 cups of cooking water and drain the pasta. \"\n}";
        ((ValidatableResponse)((ValidatableResponse)((Response)RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).queryParam("apiKey", new Object[]{this.apiKey}).body(requestBody).when().post("/recipes/analyze", new Object[0])).then()).statusCode(200)).extract().response();
    }
}
