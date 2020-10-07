package com.cybertek.task5;


import com.cybertek.Credentials.Bitrix;
import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest_Bitrix extends TestBase {

    //  @BeforeMethod and @AfterMethod extends on the TestBase class.!!!!!!

    @Test
    //B211-118 AC# 1. User should be able to click on "High Priority" checkbox to set the current task to a top priority task. (Alex)
    public void HighPriority_checkbox(){
        // Go to <https://login2.nextbasecrm.com/>
        driver.get(Bitrix.baseURL);

        //Enter valid username <helpdesk11@cybertekschool.com>
        //Enter valid password <UserUser>
        Bitrix.helpdesk(driver);

        //User click on the <Activity Stream> module
        BrowserUtils.wait(1);
        driver.findElement(By.className("menu-item-link")).click();

        //User clicks on <TASK> sub module
        BrowserUtils.wait(1);
        driver.findElement(By.id("feed-add-post-form-tab-tasks")).click();

        //User navigate on "Things to do"  and fill out this row
        Faker faker = new Faker();
        String thingsToDo = faker.book().title();
        BrowserUtils.wait(1);
        WebElement taskTitle = driver.findElement(By.xpath("//*[@data-bx-id='task-edit-title']"));
        taskTitle.sendKeys(thingsToDo+ Keys.ENTER);

        //User set the current task to a top priority task (<High Priority> checkbox)
        BrowserUtils.wait(1);
        WebElement checkbox1 = driver.findElement(By.xpath("//div[@class='task-info-panel-important']"));
        checkbox1.click();

        //User click <SEND> button
        BrowserUtils.wait(1);
        WebElement sendButton = driver.findElement(By.id("blog-submit-button-save"));
        sendButton.click();

        //User click <pop button> button
        BrowserUtils.wait(1);
        WebElement popButton = driver.findElement(By.xpath("//*[@id=\"blogPostEditCreateTaskPopup\"]/div[2]/span"));
        popButton.click();

        //switch to iframe
        BrowserUtils.wait(2);
        WebElement iframe = driver.findElement(By.className("side-panel-iframe"));
        driver.switchTo().frame(iframe);

        //User see <High Priority> is displayed
        WebElement checkHighPriority = driver.findElement(By.xpath("//span[@class='if-not-no']"));
        Assert.assertTrue(checkHighPriority.isDisplayed(),"HighPriority is NOT selected. Verification FAILED!");


    }


}


