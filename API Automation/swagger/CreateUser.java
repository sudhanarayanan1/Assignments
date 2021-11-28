package io.swagger;
import DataClasses.UserDetails;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class CreateUser {

    @Test
    public void createUserRequest() {

        UserDetails userDetails = new UserDetails();
        userDetails.setId(0);
        userDetails.setUsername("abcxyz");
        userDetails.setFirstName("ABC");
        userDetails.setLastName("XYZ");
        userDetails.setEmail("abc@gmail.com");
        userDetails.setPhone("123456789");
        userDetails.setPassword("abc");
        userDetails.setUserStatus(1);

        Response userResponse =
                given().
                        contentType(ContentType.JSON).
                        body(userDetails).
                        log().body().
                when().
                        post("https://petstore.swagger.io/v2/user").
                then().
                        assertThat().
                        statusCode(200).
                        extract().response();

        System.out.println("\nDResponse: " + userResponse.asPrettyString());
    }

    @Test
    public void createMultipleUsersRequest() {
        UserDetails[] userDetails = new UserDetails[2];
        userDetails[0] = new UserDetails();
        userDetails[0].setId(0);
        userDetails[0].setUsername("User1");
        userDetails[0].setFirstName("Elon");
        userDetails[0].setLastName("Musk");
        userDetails[0].setEmail("elonmusk@gmail.com");
        userDetails[0].setPhone("123453459");
        userDetails[0].setPassword("elon");
        userDetails[0].setUserStatus(1);

        userDetails[1] = new UserDetails();
        userDetails[1].setId(1);
        userDetails[1].setUsername("User2");
        userDetails[1].setFirstName("Tim");
        userDetails[1].setLastName("Cook");
        userDetails[1].setEmail("timcook@gmail.com");
        userDetails[1].setPhone("5456456789");
        userDetails[1].setPassword("tim");
        userDetails[1].setUserStatus(1);

        Response usersResponse =
                given().
                        contentType(ContentType.JSON).
                        body(userDetails).
                        log().body().
                when().
                        post("https://petstore.swagger.io/v2/user/createWithArray").
                then().
                        assertThat().
                        statusCode(200).
                        extract().response();

        System.out.println("\nResponse: " + usersResponse.asPrettyString());
    }
}