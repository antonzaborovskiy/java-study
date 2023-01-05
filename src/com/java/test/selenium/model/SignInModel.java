package com.java.test.selenium.model;

import org.openqa.selenium.WebElement;

import com.java.test.selenium.interfaces.model.SignInModelInterface;

public class SignInModel implements SignInModelInterface {

    private String userName;
    private String password;

    public SignInModel(WebElement usernameElement, WebElement passwordElement) {
        this.userName = parseLoginCredential(usernameElement);
        this.password = parseLoginCredential(passwordElement);
    }

    public String getUsername() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }
    
    private String parseLoginCredential(WebElement element) {
        String[] components = element.getText().split(" : ");
        return components[components.length-1];
    }
}
