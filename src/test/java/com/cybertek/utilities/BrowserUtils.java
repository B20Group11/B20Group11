package com.cybertek.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {


        public static List<String> getElementsText(List<WebElement> list) {

        List<String> webElementsAsString = new ArrayList<>();

        for (WebElement each : list) {
            webElementsAsString.add(each.getText());
        }

        return webElementsAsString;
    }

        public static void wait(double seconds) {
        try {
            Thread.sleep((long) seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
