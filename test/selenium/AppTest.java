package selenium;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.openqa.selenium.WebDriver;

import com.java.test.Client;
import com.java.test.interfaces.ClientInterface;

import driverBuilder.ChromeDriverBuilder;

import org.junit.Test;

@RunWith(MockitoJUnitRunner.class)
public class AppTest {

    @Test
    public final void testSuccessGetVersion() throws Exception {
        // WebDriverManager.chromedriver().setup();
        
        ChromeDriverBuilder builder = new ChromeDriverBuilder();
        WebDriver driver = builder.buildAndLaunch(); 
        ClientInterface client = new Client(driver);

        client.signIn();

        client.openAdminView();

        client.admin_userManagement_users();

        String name = "Anton";
        String surname = "Zaborovskiy2";
        String username = name + " " + surname;

        client.addESSUser(name, surname, "1qaz2wsx#EDC", "Odis  Adalwin");

        Thread.sleep(5000);

        client.removeUser(username);

        client.searchUser(username);

        Thread.sleep(5000);

        builder.close(driver);
    }
}
