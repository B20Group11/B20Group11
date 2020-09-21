package com.cybertek.task4;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SmokeTest {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("user161");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);
    }

    @Test
    //AC#1. Verify that truck driver should be able to see all vehicle odometer information on the grid.(Radoje)
    public void all_Vehicle_odometer_Information() throws InterruptedException {

        //   Truck driver navigate "Fleet" module and click "Vehicle Odometers" sub module
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.className("unclickable")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Vehicle Odometer")).click();
        Thread.sleep(3000);
        String expectedTitle = "Vehicle Odometer - Entities - System - Car - Entities - System";
        String actualTitle = driver.getTitle();
        Thread.sleep(3000);

    }




    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
       driver.findElement(By.id("user-menu")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(1000);
        driver.close();
    }

}
