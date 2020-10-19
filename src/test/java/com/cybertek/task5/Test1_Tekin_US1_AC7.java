package com.cybertek.task5;

import com.cybertek.Credentials.Bitrix;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test1_Tekin_US1_AC7 {



        WebDriver driver;

        @BeforeMethod
        public void setUpMethod() {
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get(Bitrix.baseURL);
        }

        @Test
        public void HighPriority_checkbox() {
            //driver.get(Bitrix.baseURL);
            Bitrix.helpdesk(driver);

            BrowserUtils.wait(1);
            driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']")).click();
            BrowserUtils.wait(1);
            driver.findElement(By.xpath("//span[@id='lhe_button_editor_blogPostForm']")).click();
            BrowserUtils.wait(1);
            driver.findElement(By.xpath("//span[@id='lhe_button_editor_blogPostForm']")).click();
            BrowserUtils.wait(1);

            Assert.assertTrue(driver.findElement(By.id("bx-html-editor-tlbr-idPostFormLHE_blogPostForm")).isDisplayed());

        }



    @AfterMethod
    public void tearDownMethod() {
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.close();
    }


}
