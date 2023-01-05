package api;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.java.test.webApi.ClientFactory;
import com.java.test.webApi.Interface.ClientInterface;

import io.restassured.RestAssured;

import org.junit.Before;
import org.junit.Test;

@RunWith(MockitoJUnitRunner.class)
public class AuthorizationTest {

    private String appKey;

    @Before
    public void setup() {
        RestAssured.baseURI = "https://www.dropbox.com";
        
        // set your app key before start testing
        appKey = "your-app-key";
    }
    
    @Test
    public final void testSuccessApi() throws Exception {

        ClientInterface clientForApi = new ClientFactory().build(RestAssured.given());

        clientForApi.authorization(appKey);
    }
}
