package api;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

import org.junit.Test;

@RunWith(MockitoJUnitRunner.class)
public class SetProfilePhotoTest {
    private String accessToken;

    @Before
    public void setup() {
        accessToken = "sl.BfT-7UrfCRvoDoIKvDlJo8txDYp0FsQTQGct2xDdcn_LAzIs0RomMCYLtSHNtIyqTgygJOqyHJI4YY1eotLyiI0p_brmudChZOTtM1U7HFKK5oaEFiic5rXWOZgIQ01pKgakAzc";
        RestAssured.baseURI = "https://api.dropboxapi.com";
    }

    @Test
    public void testSetProfilePhoto() {
        String imagePath = "files/therock.jpeg";

        RestAssured.given()
            .header("Authorization", "Bearer " + accessToken)
            .header("Content-Type", "application/json")
            .body("{\"photo\":{\".tag\":\"base64_data\",\"base64_data\":\"" + getBase64ImageData(imagePath) + "\"}}")
        .when()
            .post("/2/account/set_profile_photo")
        .then()
            .assertThat()
            .statusCode(200);
    }

    private String getBase64ImageData(String imagePath) {
        try {
            File imageFile = new File(imagePath);
            FileInputStream fileInputStream = new FileInputStream(imageFile);
            byte[] imageData = new byte[(int) imageFile.length()];
            fileInputStream.read(imageData);
            fileInputStream.close();
            return Base64.getEncoder().encodeToString(imageData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
