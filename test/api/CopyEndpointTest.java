package api;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import io.restassured.RestAssured;

import org.junit.Before;
import org.junit.Test;

@RunWith(MockitoJUnitRunner.class)
public class CopyEndpointTest {
    private String accessToken;

    @Before
    public void setup() {
        accessToken = "sl.BfT-7UrfCRvoDoIKvDlJo8txDYp0FsQTQGct2xDdcn_LAzIs0RomMCYLtSHNtIyqTgygJOqyHJI4YY1eotLyiI0p_brmudChZOTtM1U7HFKK5oaEFiic5rXWOZgIQ01pKgakAzc";
        RestAssured.baseURI = "https://api.dropboxapi.com";
    }

    @Test
    public void testCopyEndpoint() {
        String fromPath = "/tests/";
        String toPath = "/tests2/";

        RestAssured.given()
            .header("Authorization", "Bearer " + accessToken)
            .header("Content-Type", "application/json")
            .body("{\"from_path\":\"" + fromPath + "\", \"to_path\":\"" + toPath + "\", \"allow_ownership_transfer\": false, \"allow_shared_folder\": false, \"autorename\": false}")
        .when()
            .post("/2/files/copy_v2")
        .then()
            .assertThat()
            .statusCode(200);
    }
}
