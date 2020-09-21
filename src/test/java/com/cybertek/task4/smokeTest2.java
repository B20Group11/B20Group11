package com.cybertek.task4;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class smokeTest2 {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // User should be able to login at:
        driver.get("https://qa2.vytrack.com/user/login");
        Thread.sleep(2000);
    }
    //Verify IF a  truck driver should be able to reset grid by click on grid setting
    @Test
    public void reset_grid_by_click_on_grid_setting() throws InterruptedException {
        //    driver.manage().deleteAllCookies();
        driver.findElement(By.id("prependedInput")).sendKeys("user161");
        Thread.sleep(1000);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.className("unclickable")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Vehicle Odometer")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@title='Grid Settings']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[contains(@id,'column-c155')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@class='close']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@title='Reset']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("user-menu")).click();
        Thread.sleep(1000);
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(1000);
        driver.close();
    }
}
