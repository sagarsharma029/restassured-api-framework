package clients;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserClient {

        public static Response getAllUser(){
            return given()
                    .when()
                    .get("/users");
        }
}