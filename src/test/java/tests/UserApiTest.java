package tests;

import base.BaseTest;
import clients.UserClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserApiTest extends BaseTest{

    @Test
    public void getAllUsersTest(){
        Response response = UserClient.getAllUser();
        Assert.assertEquals(response.getStatusCode(), 200,
                "Status code is not 200");

        System.out.println(response.asPrettyString());
    }
}
