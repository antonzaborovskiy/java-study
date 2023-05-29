package api;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class FileMoveTest {

    @Test
    public void testFileMove() {
        // Set base URI
        RestAssured.baseURI = "https://api.dropboxapi.com";

        // Define the request body
        String requestBody = "{\n" +
                "    \"allow_ownership_transfer\": false,\n" +
                "    \"allow_shared_folder\": false,\n" +
                "    \"autorename\": false,\n" +
                "    \"from_path\": \"/Homework/math\",\n" +
                "    \"to_path\": \"/Homework/algebra\"\n" +
                "}";

        // Send the request and validate the response
        given()
                .header("Authorization", "Bearer sl.BfT-7UrfCRvoDoIKvDlJo8txDYp0FsQTQGct2xDdcn_LAzIs0RomMCYLtSHNtIyqTgygJOqyHJI4YY1eotLyiI0p_brmudChZOTtM1U7HFKK5oaEFiic5rXWOZgIQ01pKgakAzc")
                .header("Content-Type", ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/2/files/move_v2")
                .then()
                .statusCode(200);
    }
}