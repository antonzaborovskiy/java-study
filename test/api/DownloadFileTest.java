package api;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Assert;
import org.junit.Test;

@RunWith(MockitoJUnitRunner.class)
public class DownloadFileTest {

    @Test
    public void downloadFileTest() {
        String accessToken = "sl.BfT-7UrfCRvoDoIKvDlJo8txDYp0FsQTQGct2xDdcn_LAzIs0RomMCYLtSHNtIyqTgygJOqyHJI4YY1eotLyiI0p_brmudChZOTtM1U7HFKK5oaEFiic5rXWOZgIQ01pKgakAzc";
        String filePath = "/tests/upload.txt";
        String savePath = "files/testSaveFile.txt";

        Header authHeader = new Header("Authorization", "Bearer " + accessToken);
        Header apiArgHeader = new Header("Dropbox-API-Arg", "{\"path\":\"" + filePath + "\"}");

        Response response = RestAssured.given()
                .header(authHeader)
                .header(apiArgHeader)
                .post("https://content.dropboxapi.com/2/files/download");

        // Verify the response
        Assert.assertEquals(200, response.getStatusCode());

        // Save the downloaded file
        try (OutputStream outputStream = new FileOutputStream(savePath)) {
            response.getBody().asInputStream().transferTo(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
