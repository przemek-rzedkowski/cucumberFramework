package com.cucumberFramework.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailHelper {

    WebDriver driver;

    public MailHelper(WebDriver driver){
        this.driver = driver;
    }

    public void openInbox(String url) {
        driver.get(url);
    }
}
