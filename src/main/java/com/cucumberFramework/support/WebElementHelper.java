package com.cucumberFramework.support;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebElementHelper {

    WebDriver driver;
    WaitHelper waitHelper;

    public WebElementHelper(WaitHelper waitHelper, WebDriver driver) {
        this.driver = driver;
        this.waitHelper = waitHelper;
    }

    public boolean hasClass(WebElement element, String saidClass) {
        waitHelper.waitForElement(element);
        String classes = element.getAttribute("class");
        for (String c : classes.split(" ")) {
            if (c.equals(saidClass)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasNoClass(WebElement element, String saidClass) {
        waitHelper.waitForElement(element);
        String classes = element.getAttribute("class");
        for (String c : classes.split(" ")) {
            if (c.equals(saidClass)) {
                return false;
            }
        }
        return true;
    }

    public void clearFields(WebElement ... elements) {
        for (int i = 0; i < elements.length; i++) {
            waitHelper.waitForElement(elements[i]);
            elements[i].clear();
        }
    }

    public void click(WebElement element) {
        waitHelper.waitForPageLoaded(driver);
        waitHelper.waitForElementToBeClickable(element);
        element.click();
    }

    public void type(WebElement element, String string) {
        waitHelper.waitForPageLoaded(driver);
        waitHelper.waitForElementToBeClickable(element);
        element.clear();
        element.sendKeys(string);
    }

    public boolean isDisplayed(WebElement element) {
        waitHelper.waitForElement(element);
        return element.isDisplayed();
    }

    public boolean isEnabled(WebElement element) {
        waitHelper.waitForPageLoaded(driver);
        return element.isEnabled();
    }

    public boolean isClickable(WebElement element) {
        try {
            waitHelper.waitForElementToBeClickable(element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickIfThereIsElement(WebElement element, String xpath) {
        waitHelper.waitForPageLoaded(driver);
        if (driver.findElements(By.xpath(xpath)).size() != 0) {
            waitHelper.waitForElement(element);
            element.click();
        }
    }

    public boolean isEnabledWithJS(WebElement element) {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        List<WebElement> elements = (List<WebElement>) js.executeScript("return jQuery.find(':disabled')");
        return elements.size() > 0;
    }
}
