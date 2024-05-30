package com.unac.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

public class Action {

    public static void navigateUrl(WebDriver myBrowser, String url) {
        myBrowser.navigate().to(url);
    }

    public static void clickElement(WebDriver myBrowser, By target) {
        myBrowser.findElement(target).click();
    }

    public static void sendData(WebDriver myBrowser, By target, String strData) {
        myBrowser.findElement(target).sendKeys(strData);
    }

    public static String generateUniqueUsername(String baseUsername) {
        return baseUsername + UUID.randomUUID().toString().substring(0, 8);
    }
}
