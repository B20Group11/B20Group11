package com.cybertek.task5;

import com.cybertek.Credentials.Bitrix;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US1_ACNumber4 {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(Bitrix.baseURL);
    }

    @Test
    public void activityStreamModule() {
        Bitrix.helpdesk(driver);
        BrowserUtils.wait(1);

        WebElement activityStreamBtn = driver.findElement(By.xpath("//a[@title='Activity Stream']"));
        BrowserUtils.wait(1);
        activityStreamBtn.click();
        BrowserUtils.wait(1);

        WebElement messageBtn = driver.findElement(By.xpath("//span[.='Message']/span"));
        BrowserUtils.wait(1);
        messageBtn.click();
        BrowserUtils.wait(1);


        WebElement insertVideo = driver.findElement(By.xpath("//span[@class='bxhtmled-top-bar-btn bxhtmled-button-video']"));
        BrowserUtils.wait(1);
        insertVideo.click();
        BrowserUtils.wait(1);


        WebElement videoSource = driver.findElement(By.xpath("//input[@id='video_idPostFormLHE_blogPostForm-source']"));
        videoSource.sendKeys("https://www.youtube.com/watch?v=mhwmB95EX1A&list=RDmhwmB95EX1A&start_radio=1");
        BrowserUtils.wait(50);

        WebElement saveBtn = driver.findElement(By.xpath("//input[@id='undefined']"));
        BrowserUtils.wait(1);
        saveBtn.click();
        BrowserUtils.wait(1);


        WebElement sendMessageBtn = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        BrowserUtils.wait(10);
        sendMessageBtn.click();
        BrowserUtils.wait(1);

    }

    @AfterMethod
    public void tearDownMethod() {
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.close();



    }
}
