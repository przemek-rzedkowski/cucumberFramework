package com.cucumberFramework.pop;

import com.cucumberFramework.baseTest.BasePage;
import com.cucumberFramework.support.MailHelper;
import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.support.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPage extends BasePage {

    WebDriver driver;
    MailHelper mailHelper;

    @FindBy(xpath = "//form[@id='aso_search_form_anchor']")
    private WebElement searchField;

    @FindBy(xpath = "(//tr[@class='zA zE']//span[contains(text(), 'Sandbox')])[2]")
    private WebElement newSonnenMail;

    @FindBy(xpath = "(//tbody/tr[@class='zA yO'])[1]")
    private WebElement oldSonnenMail;

    @FindBy(xpath = "//img[@src='//ssl.gstatic.com/ui/v1/icons/mail/images/cleardot.gif' and @class='ajT']")
    private WebElement expandMailButton;

    @FindBy(xpath = "//div[@class='adn ads']//a[contains(text(), 'Passwort')]")
    private WebElement passwordLink;

    @FindBy(xpath = "//div[@class='adn ads']")
    private WebElement mail;

    @FindBy(xpath = "//input[contains(@type, 'email')]")
    private WebElement mailField;

    @FindBy(xpath = "//div[@id='identifierNext']")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@id='passwordNext']")
    private WebElement passwordNextButton;

    @FindBy(xpath = "//div[@class='asf T-I-J3 J-J5-Ji']/parent::div")
    private WebElement refreshButton;



    public MailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        element = new WebElementHelper(waitHelper, driver);
        mailHelper = new MailHelper(driver);
    }

    @Override
    public boolean isPageDisplayed() {
        return element.isDisplayed(searchField);
    }

    public boolean isMailDelivered() {
        waitHelper.justWaitForEmail(3000);
        return element.isDisplayed(newSonnenMail);
    }

    public boolean isOldMailDelivered() { return element.isDisplayed(oldSonnenMail);}

    public void goToInbox() {
        mailHelper.openInbox("https://accounts.google.com/AccountChooser/identifier?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&flowName=GlifWebSignIn&flowEntry=AddSession");
        element.type(mailField, "alighieri.dante1508@gmail.com");
        element.click(nextButton);
        element.type(passwordField, "123Sonnen");
        element.click(passwordNextButton);
        //System.out.println("stuff");
    }

    public void resetPassword() {
        waitHelper.justWaitForEmail(3000);
        element.clickIfThereIsElement(expandMailButton,
                "//img[@src='//ssl.gstatic.com/ui/v1/icons/mail/images/cleardot.gif' and @class='ajT']");
        element.click(passwordLink);
    }

    public void goIntoEmail() {
        waitHelper.justWaitForEmail(3000);
        element.click(newSonnenMail);
    }

    public void goIntoOldEmail() {
        waitHelper.justWaitForEmail(3000);
        element.click(oldSonnenMail);
    }

}
