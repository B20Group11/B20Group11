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

    @Test
    //AC#3.(2). Verify that truck driver should be able to edit Vehicle odometer.(Alex)
    public void EditVehicleOdometer() throws InterruptedException {
//       5. Truck driver navigate "Fleet" module and click "Vehicle Odometers" sub module
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.className("unclickable")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Vehicle Odometer")).click();
        Thread.sleep(3000);
//       6. Truck driver navigate "..." module and click "edit" sub module
        Actions action = new Actions(driver);
        WebElement dropdown = driver.findElement(By.xpath("(//*[@class='action-cell grid-cell grid-body-cell'])[1]"));
        action.moveToElement(dropdown).perform();
        Thread.sleep(3000);
        WebElement edit = driver.findElement(By.xpath("//a[@title=\"Edit\"]"));
        edit.click();
//       7. Truck driver enter the Odometer Value
        Thread.sleep(2000);
        WebElement fieldOdometerValue = driver.findElement(By.xpath("//*[@data-name='field__odometer-value']"));
        Thread.sleep(1000);
        fieldOdometerValue.clear();
        Thread.sleep(1000);
        fieldOdometerValue.sendKeys("7777");
        Thread.sleep(1000);
//       8. Truck driver Choose a date value and click today data
        WebElement fieldData = driver.findElement(By.xpath("//*[@placeholder='Choose a date']"));
        Thread.sleep(1000);
        fieldData.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        fieldData.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(1000);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-handler='today']")).click();
//       9. Truck driver enter the Driver value
        Thread.sleep(1000);
        WebElement fieldDriver = driver.findElement(By.xpath("//*[@data-name='field__driver']"));
        Thread.sleep(1000);
        fieldDriver.sendKeys(Keys.BACK_SPACE);
        fieldDriver.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(1000);
        fieldDriver.sendKeys("77");
        Thread.sleep(1000);
//       10. Truck driver enter the Unit value
        WebElement fieldUnit = driver.findElement(By.xpath("//*[@onclick='return false;']"));
        fieldUnit.click();
        Thread.sleep(1000);
        WebElement fieldKm = driver.findElement(By.xpath("//*[@class='select2-results-dept-0 select2-result select2-result-selectable']"));
        fieldKm.click();
        Thread.sleep(1000);
//       11. Truck driver click on the “Save and Close” button.
        WebElement buttonSaveAndClose = driver.findElement(By.xpath("//*[@type='submit']"));
        buttonSaveAndClose.click();
        Thread.sleep(1000);
//       12. Truck driver see the confirmation message that the vehicle odometer edited.
        String expectedMassage = "Entity saved";
        String actualMassage = driver.findElement(By.xpath("//*[@class='message']")).getText();
        Assert.assertEquals(expectedMassage,actualMassage,"Message are not matching!!");

    }

    @Test
    //AC#4. Verify that truck driver should be able to reset grid by click on grid setting.(Ziiadin)
    public void reset_grid_by_click_on_grid_setting() throws InterruptedException {
       //    driver.manage().deleteAllCookies();
       // driver.findElement(By.id("prependedInput")).sendKeys("user161");
       // Thread.sleep(1000);
       // driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.className("unclickable")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Vehicle Odometer")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@title='Grid Settings']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[contains(@id,'column-c155')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='close']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@title='Reset']")).click();
        Thread.sleep(2000);
       // driver.findElement(By.id("user-menu")).click();
       // Thread.sleep(1000);
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
