package tests;
import base.BaseTest;
import com.beust.ah.A;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UserDeleteApiTest extends BaseTest{

    @Test
    public void UserDeleteApiTest(){

        int userId = 1;

        Response response = given().when().delete("/users/{id}", userId);

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200, "User not deleted.");
    }

    @Test
    //Negative Test
    public void deleteInvalidUserTest(){

        int invalidUserId = 9999;

        Response response = given().when().delete("/users/{id}", invalidUserId);

        response.then().log().all();

        Assert.assertTrue(response.getStatusCode()==200 || response.getStatusCode()==404, "Unexpected status code.");
    }
}
