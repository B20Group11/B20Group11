package com.cybertek.task4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class smokeTest1_Radoje {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.id("prependedInput")).sendKeys("user161");
        Thread.sleep(1000);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);
        //   Truck driver navigate "Fleet" module and click "Vehicle Odometers" sub module
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.className("unclickable")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Vehicle Odometer")).click();
        Thread.sleep(3000);
        String expectedTitle = "Vehicle Odometer - Entities - System - Car - Entities - System";
        String actualTitle = driver.getTitle();
/*
     if (actualTitle.equals(expectedTitle)){
         System.out.println("Title verification PASSED!");
     }else {
         System.out.println("Title verification FAILED!");
     }*/
        Assert.assertEquals(expectedTitle,actualTitle,"Titles are not matching!!");
    }





}
