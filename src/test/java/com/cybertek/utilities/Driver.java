package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
<<<<<<< HEAD
import org.openqa.selenium.firefox.FirefoxDriver;
=======
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
>>>>>>> origin/master

public class Driver {
    private Driver(){}

    private static WebDriver driver;

    public static WebDriver getDriver(){

        if(driver == null){

            String browser = ConfigurationReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
<<<<<<< HEAD
            }
        }
        return driver;
=======
                case "opera":
                    WebDriverManager.operadriver();
                    driver = new OperaDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver();
                    driver = new EdgeDriver();
                    break;

            }
        }

        return driver;

>>>>>>> origin/master
    }

    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }


}
