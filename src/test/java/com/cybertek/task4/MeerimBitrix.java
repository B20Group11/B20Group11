package com.cybertek.task4;

import com.cybertek.Credentials.Bitrix;
import com.cybertek.Credentials.VyTrack;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.WatchEvent;
import java.util.concurrent.TimeUnit;

public class MeerimBitrix {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.get("https://login2.nextbasecrm.com/stream/");
        Bitrix.helpdesk(driver);
//
    }@Test
    public void us1Ac1(){
        WebElement message=driver.findElement(By.xpath("//span[.='Message']"));
        message.click();
        WebElement uploadFiles=driver.findElement(By.xpath("//span[@id='bx-b-uploadfile-blogPostForm']"));
        uploadFiles.click();
        WebElement upload=driver.findElement(By.xpath("//td[@class='diskuf-selector wd-fa-add-file-light-cell wd-fa-add-file-from-main']"));
        upload.click();
        Assert.assertTrue(upload.isDisplayed());
    }
    @Test
    public void us1Ac2() throws InterruptedException {
        WebElement message=driver.findElement(By.xpath("//span[.='Message']"));
        message.click();
        WebElement AllEmployees=driver.findElement(By.xpath("//a[@id='bx-destination-tag']"));
        AllEmployees.click();
        WebElement mail=driver.findElement(By.xpath("//div[@class='bx-finder-box-item-t7-name']"));
        mail.click();
        mail.click();
        Assert.assertTrue(mail.isDisplayed());
    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {

        Thread.sleep(1000);
        driver.close();
}
}
