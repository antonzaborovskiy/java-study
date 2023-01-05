package com.java.test.selenium.interfaces;

public interface ClientInterface {
    void signIn();

    void openAdminView();

    void admin_userManagement_users();

    void addESSUser(String name, String surname, String password, String employeeName) throws InterruptedException;

    void searchUser(String username) throws InterruptedException;

    void removeUser(String username) throws InterruptedException;
}
