package com.java.test.selenium.factory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.java.test.selenium.interfaces.factory.AddESSUserFactoryInterface;
import com.java.test.selenium.interfaces.model.ESSUserModelInterface;

public class AddESSUserFactory implements AddESSUserFactoryInterface {

    private WebDriver driver;

    public AddESSUserFactory(WebDriver driver) {
        this.driver = driver;
    }

    public void addESSUser(ESSUserModelInterface user) throws InterruptedException {
        
        addButtonClick();

        inputUserData(user);
        
        selectRole();

        selectStatus();
        
        Thread.sleep(1000);

        saveButtonClick();
    }

    private void addButtonClick() {
        WebElement addButton = this.driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']"));

        addButton.click();
    }

    private void saveButtonClick() {
        WebElement saveButton = this.driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));

        saveButton.click();
    }

    private void inputUserData(ESSUserModelInterface user) throws InterruptedException {
        List<WebElement> inputs = this.driver.findElements(By.xpath("//input[@class='oxd-input oxd-input--active']"));
        WebElement userNameInput = inputs.get(1);
        WebElement passInput = inputs.get(2);
        WebElement passConfirmationInput = inputs.get(3);
       
        inputEmployees(user);

        userNameInput.sendKeys(user.getName() + " " + user.getSurname());
        passInput.sendKeys(user.getPassword());
        passConfirmationInput.sendKeys(user.getPassword());
    }

    private void inputEmployees(ESSUserModelInterface user) throws InterruptedException {
        WebElement employeeNameInput = this.driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));

        employeeNameInput.sendKeys(user.getEmployeeName());

        // List<WebElement> employees = this.driver.findElements(By.xpath("//div[@class='oxd-autocomplete-option']"));
        // Thread.sleep(1000);

        List<WebElement> employees = this.driver.findElements(By.xpath("//span[@data-v-30f0a592]"));
        Thread.sleep(1000);

        try {
            employees.get(0).click();
        } catch(Exception e) {
    
            employeeNameInput.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
            employeeNameInput.sendKeys("a");

            Thread.sleep(1000);
            employees = this.driver.findElements(By.xpath("//span[@data-v-30f0a592]"));

            employees.get(0).click();
        }      
    }

    private void selectRole() {
        List<WebElement> selectFields = this.driver.findElements(By.xpath("//div[@class='oxd-select-text-input']"));

        WebElement role = selectFields.get(0);
        role.click();

        List<WebElement> roleItems = this.driver.findElements(By.xpath("//div[@class='oxd-select-option']"));

        roleItems.get(2).click();
    }

    private void selectStatus() {
        List<WebElement> selectFields = this.driver.findElements(By.xpath("//div[@class='oxd-select-text-input']"));

        WebElement role = selectFields.get(1);
        role.click();

        List<WebElement> roleItems = this.driver.findElements(By.xpath("//div[@class='oxd-select-option']"));

        roleItems.get(1).click();
    }
}
