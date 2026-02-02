package tests;

import base.BaseTest;
import com.beust.ah.A;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class UserGetSingleApiTest extends BaseTest{

    @Test
    public void getSingleUserTest(){

        int userId = 1;

        Response response =
                given()
                        .when()
                        .get("/users/{id}", userId);

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200, "Status code not 200");

        int actualId = response.jsonPath().getInt("id");
        Assert.assertEquals(actualId, userId, "User ID not matching");

        String username = response.jsonPath().getString("username");
        Assert.assertNotNull(username, "Username is NULL");

        String email = response.jsonPath().getString("email");
        Assert.assertNotNull(email, "Email is NULL");

    }
}
