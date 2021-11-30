package io.swagger;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import static io.restassured.RestAssured.*;

public class CreateUser {
    ValidateResponse validate;

    public CreateUser() {
        validate = new ValidateResponse();
    }

    @Test
    public void createSingleUser() {
        File jsonData = new File("src/test/resources/payloads/singleUser.json");
        Response response =
                given().
                        contentType(ContentType.JSON).
                        body(jsonData).
                        when().
                        post("https://petstore.swagger.io/v2/user").
                        then().
                        extract().response();

        validate.validateAPI(response);
    }

    @Test
    public void createMultipleUsers() {
        File jsonData = new File("src/test/resources/payloads/multipleUsers.json");
        Response usersResponse =
                given().
                        contentType(ContentType.JSON).
                        body(jsonData).
                        when().
                        post("https://petstore.swagger.io/v2/user/createWithArray").
                        then().
                        extract().response();

        validate.validateAPI(usersResponse);
    }


    //  Negative test cases which throw error codes
    @Test
    public void createUserWithoutData() {
        Response response =
                given().
                        contentType(ContentType.JSON).
                        when().
                        post("https://petstore.swagger.io/v2/user").
                        then().
                        extract().response();

        Assert.assertEquals(405, response.getStatusCode());
    }

    @Test
    public void createUserWithStringIDInsteadOfInt() {
        File jsonData = new File("src/test/resources/payloads/idAsString.json");
        Response response =
                given().
                        contentType(ContentType.JSON).
                        body(jsonData).
                        when().
                        post("https://petstore.swagger.io/v2/user").
                        then().
                        extract().response();

        Assert.assertEquals(500, response.getStatusCode());
    }

    @Test
    public void createUserWithStringUserStatusInsteadOfInt() {
        File jsonData = new File("src/test/resources/payloads/userStatusAsString.json");
        Response response =
                given().
                        contentType(ContentType.JSON).
                        body(jsonData).
                        when().
                        post("https://petstore.swagger.io/v2/user").
                        then().
                        extract().response();

        Assert.assertEquals(500, response.getStatusCode());
    }

    @Test
    public void createMalformedContentInRequest() {
        File jsonData = new File("src/test/resources/payloads/malformedRequest.json");
        Response response =
                given().
                        contentType(ContentType.JSON).
                        body(jsonData).
                        when().
                        post("https://petstore.swagger.io/v2/user").
                        then().
                        extract().response();

        Assert.assertEquals(400, response.getStatusCode());
    }

    @Test
    public void createRequestWithWrongContentTypeInPayload() {
        File jsonData = new File("src/test/resources/payloads/textPayload.txt");
        given().
                contentType(ContentType.JSON).
                body(jsonData).
                when().
                post("https://petstore.swagger.io/v2/user").
                then().
                assertThat().
                statusCode(400);
    }
}
