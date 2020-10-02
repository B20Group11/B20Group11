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
        String thingsToDo = faker.book().title();

        BrowserUtils.wait(1);
        WebElement taskTitle = driver.findElement(By.xpath("//*[@data-bx-id='task-edit-title']"));
        taskTitle.sendKeys(thingsToDo + Keys.ENTER);

        BrowserUtils.wait(1);
        WebElement checkbox1 = driver.findElement(By.xpath("//div[@class='task-info-panel-important']"));
        checkbox1.click();

        BrowserUtils.wait(1);
        WebElement sendButton = driver.findElement(By.id("blog-submit-button-save"));
        sendButton.click();

        BrowserUtils.wait(1);
        WebElement taskNameLink= driver.findElement(By.xpath("//a[.='"+thingsToDo+"']"));
        taskNameLink.click();

        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"task-detail-important-button\"]"));

        System.out.println(checkbox2.getText());
        ////*[@id="task-detail-important-button"]/span[2]

        //Assert.assertTrue(checkbox2.isSelected(),"Checkbox2 is NOT selected. Verification FAILED!");

    }



    @AfterMethod
    public void tearDownMethod() {

      // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     //   driver.close();
    }
}

