package api;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ListFoldersTest {

    @Test
    public void testListFolders() {
        // Set base URI
        RestAssured.baseURI = "https://api.dropboxapi.com";

        // Define the request body
        String requestBody = "{\n" +
                "    \"actions\": [],\n" +
                "    \"limit\": 100\n" +
                "}";

        // Send the request and validate the response
        given()
                .header("Authorization", "Bearer sl.BfT-7UrfCRvoDoIKvDlJo8txDYp0FsQTQGct2xDdcn_LAzIs0RomMCYLtSHNtIyqTgygJOqyHJI4YY1eotLyiI0p_brmudChZOTtM1U7HFKK5oaEFiic5rXWOZgIQ01pKgakAzc")
                .header("Content-Type", ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/2/sharing/list_folders")
                .then()
                .statusCode(200);
    }
}