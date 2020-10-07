package com.cybertek.task5;

import com.cybertek.Credentials.Bitrix;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test2_Alex {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(Bitrix.baseURL);
    }

    @Test
    public void VisualEditor_isDisplayed(){
       // Go to <https://login2.nextbasecrm.com/>
       // driver.get(Bitrix.baseURL);

        //Enter valid username <helpdesk11@cybertekschool.com>
        //Enter valid password <UserUser>
        Bitrix.helpdesk(driver);

        //User click on the <Activity Stream> module
        BrowserUtils.wait(1);
        driver.findElement(By.className("menu-item-link")).click();

        //User clicks on <TASK> sub module
        BrowserUtils.wait(1);
        driver.findElement(By.id("feed-add-post-form-tab-tasks")).click();

        //User click and see the editor text-bar displays on top of the message box.
        BrowserUtils.wait(1);
        WebElement visualEditor = driver.findElement(By.id("lhe_button_editor_task-form-lifefeed_task_form"));
        WebElement toolBar = driver.findElement(By.id("bx-html-editor-tlbr-cnt-lifefeed_task_form"));
        Assert.assertTrue(toolBar.isDisplayed(),"Tool Bar is NOT displayed. Verification FAILED!");

        BrowserUtils.wait(1);
        visualEditor.click();
        Assert.assertFalse(toolBar.isDisplayed(),"Tool Bar is displayed. Verification FAILED!");

        BrowserUtils.wait(1);
        visualEditor.click();
        Assert.assertTrue(toolBar.isDisplayed(),"Tool Bar is NOT displayed. Verification FAILED!");


    }


    @AfterMethod
    public void tearDownMethod() {

        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //   driver.close();
    }
}

