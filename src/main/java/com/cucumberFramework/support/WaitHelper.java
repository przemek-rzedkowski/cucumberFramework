package com.cucumberFramework.support;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WaitHelper {

	Logger logger = LoggerHelper.getLogger(WaitHelper.class);
	
	private WebDriver driver;

	private FluentWait<WebDriver> fluentWait;

	private WebDriverWait wait;

	long timeOutInSeconds = 7;
	
	public WaitHelper(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		fluentWait = new FluentWait<>(driver).
				withTimeout(Duration.ofSeconds(10)).
				pollingEvery(Duration.ofMillis(500)).
				ignoring(NoSuchElementException.class);
	}
	
	public void waitForElement(WebElement element){
		logger.info("waiting for element visibilityOf..");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		logger.info("element is visible..");
	}

	public void waitForPageLoaded(WebDriver driver) {
		wait.until((ExpectedCondition<Boolean>) wd ->
				((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
	}

	public void waitForElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public FluentWait<WebDriver> getFluentWait() { return this.fluentWait; }
}
