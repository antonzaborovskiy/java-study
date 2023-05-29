package api;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

@RunWith(MockitoJUnitRunner.class)
public class ListFolderTest {

    private static final String BASE_URI = "https://api.dropboxapi.com";
    private static final String ACCESS_TOKEN = "sl.BfT-7UrfCRvoDoIKvDlJo8txDYp0FsQTQGct2xDdcn_LAzIs0RomMCYLtSHNtIyqTgygJOqyHJI4YY1eotLyiI0p_brmudChZOTtM1U7HFKK5oaEFiic5rXWOZgIQ01pKgakAzc";

    @Before
    public void setup() {
        RestAssured.baseURI = BASE_URI;
    }
    
    @Test
    public final void testSuccessApiCalls() throws Exception {
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .contentType("application/json")
                .body("{\"path\": \"\"}")
                .when()
                .post("/2/files/list_folder")
                .then()
                .extract()
                .response();

        assertEquals(200, response.getStatusCode());
        assertEquals("application/json", response.contentType());
        assertEquals("tests", response.path("entries[0].name"));
    }
}
