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
public class DeleteFileTest {

    private ClientFactoryInterface factory;
    private String token;

    @Before
    public void setup() {
        this.factory = new ClientFactory();
        // update with your correct access token before testing
        this.token = "BfSDHw2iEPbT5Oriqd_JqQzpzK_CK9hWrWQshVULXYwKObLJkEEa38rS5kGINe_NXSMVZlzDQtiSy4BaaTaMk9Y6VWGD2xicrPcFPCyo-pCOTSi3-wdqlMrq6j4UfPywWKCmPpI";
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
        client.getMetadata(token, pathOnDropBox + fileName);
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
