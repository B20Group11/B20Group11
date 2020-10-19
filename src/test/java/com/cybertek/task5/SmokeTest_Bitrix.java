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

    @Test
    //B211-118 AC# 2. User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box. (Alex)
    public void VisualEditor_isDisplayed(){
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

    @Test
    //B211-128 AC #4 Automation User should be able to insert videos by clicking on the video icon and entering the video URL.(Ziiadin)
    public void activityStreamModule() {
        driver.get(Bitrix.baseURL);

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

    @Test
    //B211-128 Automation AC#1 User should be able to click on upload files icon to upload files and pictures from local disks,
    // download from external drive, select documents from bixtrix24, and create files to upload.(Meerim)
    public void us1Ac1(){
        driver.get(Bitrix.baseURL);
        Bitrix.helpdesk(driver);

        WebElement message=driver.findElement(By.xpath("//span[.='Message']"));
        message.click();
        WebElement uploadFiles=driver.findElement(By.xpath("//span[@id='bx-b-uploadfile-blogPostForm']"));
        uploadFiles.click();
        WebElement upload=driver.findElement(By.xpath("//td[@class='diskuf-selector wd-fa-add-file-light-cell wd-fa-add-file-from-main']"));
        upload.click();
        Assert.assertTrue(upload.isDisplayed());
    }

    @Test
    //B211-117 Automation AC#2. User should be able to add users from selecting contact from E-mail user,
    // Employees and Departments and Recent contact lists.(Meerim)
    public void us1Ac2() throws InterruptedException {
        driver.get(Bitrix.baseURL);
        Bitrix.helpdesk(driver);

        WebElement message=driver.findElement(By.xpath("//span[.='Message']"));
        message.click();
        WebElement AllEmployees=driver.findElement(By.xpath("//a[@id='bx-destination-tag']"));
        AllEmployees.click();
        WebElement mail=driver.findElement(By.xpath("//div[@class='bx-finder-box-item-t7-name']"));
        mail.click();
        mail.click();
        Assert.assertTrue(mail.isDisplayed());
    }


}


