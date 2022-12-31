package com.java.test.factory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.java.test.interfaces.factory.SearchUserFactoryInterface;

public class SearchUserFactory implements SearchUserFactoryInterface {

    private WebDriver driver;

    public SearchUserFactory(WebDriver driver) {
        this.driver = driver;
    }

    public void search(String username) throws InterruptedException {
        WebElement buttonReset = this.driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--ghost']"));

        buttonReset.click();

        List<WebElement> inputs = this.driver.findElements(By.xpath("//input[@class='oxd-input oxd-input--active']"));

        WebElement usernameInput = inputs.get(1);

        usernameInput.sendKeys(username);

        WebElement buttonSearch = this.driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));

        buttonSearch.click();
    }
}
