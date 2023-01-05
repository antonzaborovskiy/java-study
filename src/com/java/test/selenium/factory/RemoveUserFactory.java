package com.java.test.selenium.factory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.java.test.selenium.interfaces.factory.RemoveUserFactoryInterface;

public class RemoveUserFactory implements RemoveUserFactoryInterface {

    private WebDriver driver;

    public RemoveUserFactory(WebDriver driver) {
        this.driver = driver;
    }

    public void remove(String username) throws InterruptedException {
        this.driver.findElement(By.xpath("//div[text()='" + username + "']"));
        List<WebElement> deleteButton = driver.findElements(By.xpath("//button[@data-v-654f8522]"));
        deleteButton.get(2).click();
        
        List<WebElement> dangerButtons = this.driver.findElements(By.xpath("//button[@data-v-7e88b27e]"));
        WebElement confirmButton = dangerButtons.get(4);
        confirmButton.click();
    }
}
