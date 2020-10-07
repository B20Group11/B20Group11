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

public class Test1_Alex {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(Bitrix.baseURL);
    }

    @Test
    public void HighPriority_checkbox(){
        Bitrix.helpdesk(driver);

        BrowserUtils.wait(1);
        driver.findElement(By.className("menu-item-link")).click();
        BrowserUtils.wait(1);
        driver.findElement(By.id("feed-add-post-form-tab-tasks")).click();

        Faker faker = new Faker();
        String thingsToDo = faker.book().title();//HI

        BrowserUtils.wait(1);
        WebElement taskTitle = driver.findElement(By.xpath("//*[@data-bx-id='task-edit-title']"));
        taskTitle.sendKeys(thingsToDo+ Keys.ENTER);//HI

        BrowserUtils.wait(1);
        WebElement checkbox1 = driver.findElement(By.xpath("//div[@class='task-info-panel-important']"));
        checkbox1.click();



        BrowserUtils.wait(1);
        WebElement sendButton = driver.findElement(By.id("blog-submit-button-save"));
        sendButton.click();

        WebElement popButton = driver.findElement(By.xpath("//*[@id=\"blogPostEditCreateTaskPopup\"]/div[2]/span"));
        popButton.click();
        BrowserUtils.wait(2);
/*

        BrowserUtils.wait(1);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        BrowserUtils.wait(1);
        WebElement taskNameLink= driver.findElement(By.xpath("//a[.='"+thingsToDo+"']"));
        taskNameLink.click();


         */
        //driver.switchTo().frame(0);
       // driver.switchTo().frame(driver.findElement(By.id("iframe_jmrrrgkmc5")));
      // WebElement checkHighPriority = driver.findElement(By.xpath("//div[@class='task-info-panel-important mutable']"));
       // WebElement checkHighPriority = driver.findElement(By.xpath("//span[contains(@class, 'if-not-no')]"));
        WebElement iframe = driver.findElement(By.className("side-panel-iframe"));
        driver.switchTo().frame(iframe);


        boolean selection = driver.findElement(By.xpath("//span[@class='if-no']")).isSelected();
        System.out.println(selection);
       // WebElement checkHighPriority = driver.findElement(By.xpath("//span[contains(@class, 'if-not-no')]"));

        //Assert.assertTrue(checkHighPriority.isSelected(),"Checkbox2 is NOT selected. Verification FAILED!");
       // checkHighPriority.isSelected();

        //WebElement checkHighPriority = driver.findElement(By.id("task-detail-important-button"));
        //checkHighPriority.click();

        //WebElement checkHighPriority = driver.findElement(By.xpath("//div[@class='task-info-panel-important mutable']"));
       // WebElement element = driver.findElement(By.id("task-detail-important-button"));
       // String text = element.getText();
       // System.out.println(text);


       // WebElement element = driver.findElement(By.className("task-view-button timer-start ui-btn ui-btn-success"));
       // element.click();
       // System.out.println(checkHighPriority.getText());
        ////*[@id="task-detail-important-button"]/span[2]
        //"//div[@class='task-info-panel-important mutable']"

        //Assert.assertTrue(checkbox2.isSelected(),"Checkbox2 is NOT selected. Verification FAILED!");

    }








    @AfterMethod
    public void tearDownMethod() {

      // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     //   driver.close();
    }
}

