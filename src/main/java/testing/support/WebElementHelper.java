package testing.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementHelper {

    //private WebDriver driver;

    private WaitHelper wait;

    public WebElementHelper(WebDriver driver, WaitHelper waitHelper) {
        //this.driver = driver;
        this.wait = waitHelper;
    }

    public WebElementHelper(WaitHelper wait) {
        this.wait = wait;
    }

    public void click(WebElement element) {
        wait.waitForPageLoaded();
        wait.waitForElement(element);
        element.click();
    }

    public void type(WebElement element, String text) {
        wait.waitForPageLoaded();
        wait.waitForElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public boolean isDisplayed(WebElement element) {
        wait.waitForPageLoaded();
        return element.isDisplayed();
    }

    public boolean isEnabled(WebElement element) {
        wait.waitForPageLoaded();
        return element.isEnabled();
    }

    public boolean hasClass(WebElement element, String saidClass) {
        wait.waitForPageLoaded();
        String classes = element.getAttribute("class");
        for (String c : classes.split(" ")) {
            if (c.equals(saidClass)) {
                return true;
            }
        }
        return false;
    }

    public void clear(WebElement element) {
        wait.waitForPageLoaded();
        element.clear();
    }

}
