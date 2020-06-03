package com.cucumberFramework.pop;

import com.cucumberFramework.baseTest.BasePage;
import com.cucumberFramework.support.MailHelper;
import com.cucumberFramework.support.WaitHelper;
import com.google.api.services.gmail.model.Message;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MailPage extends BasePage {

    WebDriver driver;
    MailHelper mailHelper;

    public MailPage(WebDriver driver) {
        this.driver = driver;
        waitHelper = new WaitHelper(driver);
        mailHelper = new MailHelper(driver);
    }

    @Override
    public boolean isPageDisplayed() {
        return true;
    }

    public int listMatchingMessages(String query) {
        String messageId;
        List<Message> messages = new ArrayList<>();
        try {
            messages = mailHelper.listMessagesMatchingQuery(query);
            System.out.println(messages.size());
            if (messages.size() == 0) return 0;
            messageId = messages.get(0).getId();
            mailHelper.getMessage(messageId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return messages.size();
    }


    public boolean isMessageDelivered() {
        final List[] sandbox = new List[]{null};
        return waitHelper.getFluentWait().until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    sandbox[0] = mailHelper.listMessagesMatchingQuery("Sandbox");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                assert sandbox[0] != null;
                //System.out.println("sandbox = " + sandbox[0].size());
                return sandbox[0].size() == 1;
            }
        });
    }

    public void deleteAllThreads() {
        try {
            mailHelper.deleteAllThreads();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String extractToken(String query) {
        String messageId;
        String msgText = null;
        try {
            messageId = mailHelper.listMessagesMatchingQuery(query).get(0).getId();
            msgText = mailHelper.getMessageRaw(messageId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert msgText != null;
        return msgText;
    }

    public void deleteAllThreadsIfSerialNumber(String arg0) { if (arg0.equals("serial number")) deleteAllThreads(); }

    public String extractActivationToken() {
        String msgText = extractToken("Sandbox: Einladung zur sonnenCommunity");

        int start = msgText.indexOf("https://my.de");
        String url =  msgText.substring(start, start + 242);
        url = url.replace("=", "");
        return url.replaceFirst("dev", "staging");
    }

    public String breakActivationToken() { return extractActivationToken().replaceFirst("0","1");}

    public String extractResetPasswordToken() {
        String msgText = extractToken("Sandbox: sonnenCommunity - Passwort zurücksetzen");

        int start = msgText.indexOf("https://my.de");
        String url = msgText.substring(start, start + 254);
        url = url.replace("=", "");
        url = url.replaceFirst("de", "staging");
        return url.replaceFirst("v", "");
    }

    public String breakResetPasswordToken() { return extractResetPasswordToken().replaceFirst("0", "1"); }

    public String extractSFCode() {
        String msgText = extractToken("Sandbox: Verify your identity in Salesforce");

        int start = msgText.indexOf("Code:") + 6;
        return msgText.substring(start, start + 5);
    }
}
