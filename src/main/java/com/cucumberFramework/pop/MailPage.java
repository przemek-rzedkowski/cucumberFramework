package com.cucumberFramework.pop;

import com.cucumberFramework.baseTest.BasePage;
import com.cucumberFramework.support.MailHelper;
import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.support.WebElementHelper;
import com.google.api.services.gmail.model.Message;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;


public class MailPage extends BasePage {

    WebDriver driver;
    MailHelper mailHelper;

    public MailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        element = new WebElementHelper(waitHelper, driver);
        mailHelper = new MailHelper(driver);
    }

    @Override
    public boolean isPageDisplayed() {
        return true;
    }


    public void listSandboxMessages() {
        String messageId;
        try {
            messageId = mailHelper.listMessagesMatchingQuery("Sandbox").get(0).getId();
            mailHelper.getMessage(messageId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean isMessageDelivered() {
        List<Message> sandbox = null;
        try {
            sandbox = mailHelper.listMessagesMatchingQuery("Sandbox");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert sandbox != null;
        //System.out.println("sandbox.size = " + sandbox.size());
        return sandbox.size() == 1;
    }

    public void deleteAllThreads() {
        try {
            mailHelper.deleteAllThreads();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAllThreadsIfSerialNumber(String arg0) {
        if (arg0.equals("serial number")) {
            try {
                mailHelper.deleteAllThreads();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String extractActivationToken() {
        String messageId;
        String msgText = null;
        try {
            messageId = mailHelper.listMessagesMatchingQuery("Sandbox").get(0).getId();
            msgText = mailHelper.getMessage(messageId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(msgText);
        assert msgText != null;
        int start = msgText.indexOf("https://my-de");
        return msgText.substring(start, start + 233);
    }

    public String breakActivationToken() { return extractActivationToken().replaceFirst("0","1");}

    public String extractResetPasswordToken() {
        String messageId;
        String msgText = null;
        try {
            messageId = mailHelper.listMessagesMatchingQuery("Sandbox").get(0).getId();
            msgText = mailHelper.getMessageRaw(messageId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert msgText != null;
        int start = msgText.indexOf("https://my-de");
        String url = msgText.substring(start, start + 254);
        return url.replace("=", "");
    }

    public String breakResetPasswordToken() { return extractResetPasswordToken().replaceFirst("0", "1"); }
}
