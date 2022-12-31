package com.java.test.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.java.test.interfaces.factory.UserManagementUsersFactoryInterface;

public class UserManagementUsersFactory implements UserManagementUsersFactoryInterface {

    private WebDriver driver;

    public UserManagementUsersFactory(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        WebElement dropDownUserManagement = this.driver.findElement(By.xpath("//span[@class='oxd-topbar-body-nav-tab-item']"));

        dropDownUserManagement.click();

        WebElement itemUsers = this.driver.findElement(By.xpath("//a[@href='#']"));

        itemUsers.click();
    }
}
