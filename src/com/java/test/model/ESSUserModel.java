package com.java.test.model;

import com.java.test.interfaces.model.ESSUserModelInterface;

public class ESSUserModel implements ESSUserModelInterface {

    private String name;
    private String surname;
    private String password;
    private String employeeName;

    public ESSUserModel(String name, String surname, String password, String employeeName) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.employeeName = employeeName;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    
    public String getPassword() {
        return password;
    }

    public String getEmployeeName() {
        return employeeName;
    }
}
