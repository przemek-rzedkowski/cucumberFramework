package com.cucumberFramework.baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;

import static com.cucumberFramework.support.PropertiesHelper.*;


public class TestBase {

	public static WebDriver driver;
	private static boolean headless;
	private ChromeOptions chromeOptions;
	private FirefoxOptions firefoxOptions;


	public WebDriver startBrowser() throws IOException {
		loadConfigurationProperties();
		headless = Boolean.parseBoolean(properties.getProperty("config.browser.headless"));
		if (properties.getProperty("config.browser.env").equals("local")) {
			setupDriver();
		} else {
			String host = "http://localhost:4444/wd/hub";
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("window-size=1920,1080");
			chromeOptions.addArguments("start-maximized");
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--disable-dev-shm-usage");
			driver = new RemoteWebDriver(new URL(host), chromeOptions);
		}
		driver.get("https://my.dev.sonnen.de/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		return driver;
	}

	public void setupDriver() {
		if (properties.getProperty("config.browser").equals("CHROME")) {
			WebDriverManager.chromedriver().setup();
			chromeOptions = new ChromeOptions();
			chromeOptions.setHeadless(headless);
			//chromeOptions.addArguments("window-size=1920,1080");
			chromeOptions.addArguments("start-maximized"); 						// https://stackoverflow.com/a/26283818/1689770
			chromeOptions.addArguments("enable-automation");					// https://stackoverflow.com/a/43840128/1689770
			chromeOptions.addArguments("--no-sandbox"); 						//https://stackoverflow.com/a/50725918/1689770
			chromeOptions.addArguments("--disable-infobars"); 					//https://stackoverflow.com/a/43840128/1689770
			chromeOptions.addArguments("--disable-dev-shm-usage"); 				//https://stackoverflow.com/a/50725918/1689770
			chromeOptions.addArguments("--disable-browser-side-navigation"); 	//https://stackoverflow.com/a/49123152/1689770
			chromeOptions.addArguments("--disable-gpu");
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE); 			//workaround, probably may cause faulty results
			driver = new ChromeDriver(chromeOptions);
		} else if (properties.getProperty("config.browser").equals("FIREFOX")) {
			WebDriverManager.firefoxdriver().setup();
			firefoxOptions = new FirefoxOptions();
			firefoxOptions.setHeadless(headless);
			firefoxOptions.addArguments("window-size=1920,1080");
			firefoxOptions.addArguments("start-maximized");
			driver = new FirefoxDriver(firefoxOptions);
		}
	}

	public void getAddress(String url) {
		driver.get(url);
	}
}
