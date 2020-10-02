package com.cybertek.Credentials;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VyTrack {

    public static String baseURL = "https://qa2.vytrack.com/user/login";

    public static void user(WebDriver driver){

        // Enter username: “user161”
        WebElement userNameInput = driver.findElement(By.id("prependedInput"));
        userNameInput.sendKeys("user161");

        // Enter password: “UserUser123”
        WebElement passwordInput = driver.findElement(By.id("prependedInput2"));
        passwordInput.sendKeys("UserUser123"+Keys.ENTER);

      //  WebElement loginButton = driver.findElement(By.id(""));
      //  loginButton.click();

    }

    public static void storeManager(WebDriver driver){


        // Enter username: “storemanager212”
        WebElement userNameInput = driver.findElement(By.id("prependedInput"));
        userNameInput.sendKeys("storemanager212");

        // Enter password: “UserUser123”
        WebElement passwordInput = driver.findElement(By.id("prependedInput2"));
        passwordInput.sendKeys("UserUser123"+Keys.ENTER);

    }

    public static void salesManager(WebDriver driver){


        // Enter username: “salesmanager212”
        WebElement userNameInput = driver.findElement(By.id("prependedInput"));
        userNameInput.sendKeys("salesmanager212");

        // Enter password: “UserUser123”
        WebElement passwordInput = driver.findElement(By.id("prependedInput2"));
        passwordInput.sendKeys("UserUser123"+Keys.ENTER);

    }


}
