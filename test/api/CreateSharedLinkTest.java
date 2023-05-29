package api;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

@RunWith(MockitoJUnitRunner.class)
public class CreateSharedLinkTest {
    private String accessToken;

    @Before
    public void setup() {
        accessToken = "sl.BfT-7UrfCRvoDoIKvDlJo8txDYp0FsQTQGct2xDdcn_LAzIs0RomMCYLtSHNtIyqTgygJOqyHJI4YY1eotLyiI0p_brmudChZOTtM1U7HFKK5oaEFiic5rXWOZgIQ01pKgakAzc";
        RestAssured.baseURI = "https://api.dropboxapi.com";
    }

    @Test
    public void testCreateSharedLinkWithSettings() {
        String requestBody = "{\"path\": \"/path/to/file.txt\",\"settings\": {\"requested_visibility\": \"public\"}}";

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/2/sharing/create_shared_link_with_settings");

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
        String sharedLink = response.jsonPath().getString("url");
        String sharedLinkStatus = response.jsonPath().getString("link_permissions.resolved_visibility");
        assertEquals("public", sharedLinkStatus);

        System.out.println("Shared Link: " + sharedLink);
    }
}
