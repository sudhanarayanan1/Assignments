package io.swagger;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.io.File;
import static io.restassured.RestAssured.*;

@RunWith(DataProviderRunner.class)
public class CreateUser {
    ValidateResponse validate;

    public CreateUser() {
        validate = new ValidateResponse();
    }

    @DataProvider
    public static Object[][] apiCallToBeTested() {
        return new Object[][]{
                {"https://petstore.swagger.io/v2/user"},
                {"https://petstore.swagger.io/v2/user/createWithArray"}
        };
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
    @UseDataProvider("apiCallToBeTested")
    public void createUserWithoutData(String url) {
        Response response =
                given().
                        contentType(ContentType.JSON).
                when().
                        post(url).
                then().
                        extract().response();

        Assert.assertEquals(405, response.getStatusCode());
    }

    @Test
    @UseDataProvider("apiCallToBeTested")
    public void createUserWithStringIDInsteadOfInt(String url) {
        File jsonData = new File("src/test/resources/payloads/idAsString.json");
        Response response =
                given().
                        contentType(ContentType.JSON).
                        body(jsonData).
                when().
                        post(url).
                then().
                        extract().response();

        Assert.assertEquals(500, response.getStatusCode());
    }

    @Test
    @UseDataProvider("apiCallToBeTested")
    public void createUserWithStringUserStatusInsteadOfInt(String url) {
        File jsonData = new File("src/test/resources/payloads/userStatusAsString.json");
        Response response =
                given().
                        contentType(ContentType.JSON).
                        body(jsonData).
                when().
                        post(url).
                then().
                        extract().response();

        Assert.assertEquals(500, response.getStatusCode());
    }

    @Test
    @UseDataProvider("apiCallToBeTested")
    public void createMalformedContentInRequest(String url) {
        File jsonData = new File("src/test/resources/payloads/malformedRequest.json");
        Response response =
                given().
                        contentType(ContentType.JSON).
                        body(jsonData).
                when().
                        post(url).
                then().
                        extract().response();

        Assert.assertEquals(400, response.getStatusCode());
    }

    @Test
    @UseDataProvider("apiCallToBeTested")
    public void createRequestWithWrongContentTypeInPayload(String url) {
        File jsonData = new File("src/test/resources/payloads/textPayload.txt");
        given().
                contentType(ContentType.JSON).
                body(jsonData).
        when().
                post(url).
       then().
                assertThat().
                statusCode(400);
    }
}
