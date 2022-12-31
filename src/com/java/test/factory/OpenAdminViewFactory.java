package com.java.test.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.java.test.interfaces.factory.OpenAdminViewFactoryInterface;

public class OpenAdminViewFactory implements OpenAdminViewFactoryInterface {

    private WebDriver driver;

    public OpenAdminViewFactory(WebDriver driver) {
        this.driver = driver;
    }

    public void openAdminView() {
        WebElement buttonAdmin = this.driver.findElement(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']"));

        buttonAdmin.click();
    }
}
