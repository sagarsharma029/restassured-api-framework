package utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "userData")
    public Object[][] getUserData() {

        return new Object[][] {
                {"user1@test.com", "user1", "password1"},
                {"user2@test.com", "user2", "password2"},
                {"user3@test.com", "user3", "password3"}
        };
    }
    //For Negative Data Driven Test
    /*@DataProvider(name="invalidUserData")
    public Object[][] invalidData() {
        return new Object[][] {
                {"", "user1", "pass"},
                {"abc", "", "pass"},
                {null, "user3", ""}
        };
    }*/

}