package driverBuilder;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.java.test.selenium.interfaces.builder.DriverBuilderInterface;

public class ChromeDriverBuilder implements DriverBuilderInterface{

    public WebDriver buildAndLaunch() {
        WebDriver driver = new ChromeDriver(); //Creating an object of Chrome
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        driver.get("https://opensource-demo.orangehrmlive.com/");

        return driver;
    }
    
    public void close(WebDriver driver) {
        driver.close();
    }
}
