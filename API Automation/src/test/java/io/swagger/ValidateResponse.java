package io.swagger;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

public class ValidateResponse {
    String type;
    String message;
    Response response = null;

    // Public method internally calls different methods to validate
    public void validateAPI(Response response) {
        this.response = response;
        validateStatus();
        validateHeader();
        validateResponseStructure();
        validateAPIResponseBody();
    }

    // Validates Status code directly from the response
    private void validateStatus() {
        Assert.assertEquals(200, response.getStatusCode());
    }

    // Validates if the HTTP headers are as expected
    private void validateHeader() {
        String contentType = response.header("content-type");
        Assert.assertEquals("application/json", contentType);

        String accessControlAllowHeaders = response.header("access-control-allow-headers");
        Assert.assertEquals("Content-Type, api_key, Authorization", accessControlAllowHeaders);

        String accessControlAllowMethods = response.header("access-control-allow-methods");
        Assert.assertEquals("GET, POST, DELETE, PUT", accessControlAllowMethods);

        String accessControlAllowOrigin = response.header("access-control-allow-origin");
        Assert.assertEquals("*", accessControlAllowOrigin);
    }

    // Validate if the JSON Response body is according to schema
    private void validateResponseStructure() {

        JsonPath jsonPathEvaluator = response.jsonPath();

        if ((jsonPathEvaluator.get("code")) == null) {
            Assert.fail();
        }

        if ((type = jsonPathEvaluator.get("type")) == null) {
            Assert.fail();
        }

        if ((message = jsonPathEvaluator.get("message")) == null) {
            Assert.fail();
        }
    }

    // Validates the content of the Response for user creation
    private void validateAPIResponseBody() {
        // status code already checked for, checking the remaining
        Assert.assertEquals("unknown", type);
        Assert.assertTrue(!message.isEmpty());
    }
}
