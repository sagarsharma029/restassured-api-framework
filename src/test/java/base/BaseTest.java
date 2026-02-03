package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {

    protected static Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "https://fakestoreapi.com";
        logger.info("Base URI set to Fake Store API");
    }
}
