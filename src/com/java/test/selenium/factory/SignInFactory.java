package com.java.test.selenium.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.java.test.selenium.interfaces.factory.SignInFactoryInterface;
import com.java.test.selenium.interfaces.model.SignInModelInterface;

public class SignInFactory implements SignInFactoryInterface {

    private WebDriver driver;

    public SignInFactory(WebDriver driver) {
        this.driver = driver;
    }

    public void signIn(SignInModelInterface model) {
        WebElement inputUsername = this.driver.findElement(By.name("username"));
        WebElement inputPassword = this.driver.findElement(By.name("password"));
        WebElement buttonSignIn = this.driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));

        inputUsername.sendKeys(model.getUsername());
        inputPassword.sendKeys(model.getPassword());
        buttonSignIn.click();
    }
}
