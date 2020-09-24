package com.cybertek.Credentials;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Bitrix {

    public static String baseURL = "https://login2.nextbasecrm.com/";

    public static void helpdesk(WebDriver driver){

        // Enter username: “helpdesk11@cybertekschool.com”
        WebElement userNameInput = driver.findElement(By.name("USER_LOGIN"));
        userNameInput.sendKeys("helpdesk11@cybertekschool.com");

        // Enter password: “UserUser”
        WebElement passwordInput = driver.findElement(By.name("USER_PASSWORD"));
        passwordInput.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

    }

    public static void marketing(WebDriver driver){

        // Enter username: “marketing11@cybertekschool.com”
        WebElement userNameInput = driver.findElement(By.name("USER_LOGIN"));
        userNameInput.sendKeys("marketing11@cybertekschool.com");

        // Enter password: “UserUser”
        WebElement passwordInput = driver.findElement(By.name("USER_PASSWORD"));
        passwordInput.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

    }

    public static void hr(WebDriver driver){

        // Enter username: “hr11@cybertekschool.com”
        WebElement userNameInput = driver.findElement(By.name("USER_LOGIN"));
        userNameInput.sendKeys("hr11@cybertekschool.com");

        // Enter password: “UserUser”
        WebElement passwordInput = driver.findElement(By.name("USER_PASSWORD"));
        passwordInput.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

    }

}
