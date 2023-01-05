package api;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.java.test.webApi.ClientFactory;
import com.java.test.webApi.Interface.ClientFactoryInterface;
import com.java.test.webApi.Interface.ClientInterface;

import io.restassured.RestAssured;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileWriter;

import org.junit.Before;
import org.junit.Test;

@RunWith(MockitoJUnitRunner.class)
public class ApiTest {

    private ClientFactoryInterface factory;
    private String token;

    @Before
    public void setup() {
        this.factory = new ClientFactory();

        // update with your correct access token before testing
        this.token = "BWQroaai3btfTfufTnbY8rmtYNtav4gSpxZECtG2x9DvzNWZvprlS0ti0TWcBOol7EFuHtk3MnDGEZVhdXvAOJiYFDAL-HY5sgeXOK1eEmIz_eR-YxhdUEPrbsi2-Q8UO-sBvrg";
    }
    
    @Test
    public final void testSuccessApiCalls() throws Exception {
        RestAssured.baseURI = "https://content.dropboxapi.com";

        ClientInterface client = this.factory.build(RestAssured.given());

        File file = this.getFile();
        String pathOnDropBox = "/tests/";

        String fileName = client.uploadFile(token, pathOnDropBox, file);

        assertEquals(file.getName(), fileName);

        RestAssured.reset();
        RestAssured.baseURI = "https://api.dropboxapi.com";

        client = factory.build(RestAssured.given());

        // @improve expects found on success
        client.getMetadata(token, pathOnDropBox + fileName);
    
        // @improve expects delete on success

        client.deleteFile(token, pathOnDropBox + fileName);

        // @improve expects found on failure
        client.getMetadata(token, pathOnDropBox + fileName);

        // @improve expects delete on failure
        client.deleteFile(token, pathOnDropBox + fileName);
    }

    private File getFile() throws Exception {
        File myObj = new File("test/api/files/upload.txt");
        
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());

            FileWriter myWriter = new FileWriter("test/api/files/upload.txt");
            myWriter.write("\n Hello, world! \n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } else {
            System.out.println("File already exists.");
        }
        return myObj;
    }
}
