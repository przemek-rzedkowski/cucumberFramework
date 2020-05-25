package com.cucumberFramework.support;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Base64;
import com.google.api.client.util.StringUtils;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.*;
import com.google.api.services.gmail.model.Thread;
import org.openqa.selenium.WebDriver;

import javax.mail.MessagingException;
import java.io.*;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class MailHelper {

    WebDriver driver;
    Gmail service;
    String user;


    public MailHelper(WebDriver driver) {
        this.driver = driver;
        try {
            this.buildService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String APPLICATION_NAME = "sonnen3";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList("https://mail.google.com/");
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = MailHelper.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public void printLabels() throws IOException {
        ListLabelsResponse listResponse = service.users().labels().list(user).execute();
        List<Label> labels = listResponse.getLabels();
        if (labels.isEmpty()) {
            System.out.println("No labels found.");
        } else {
            System.out.println("Labels:");
            for (Label label : labels) {
                System.out.printf("- %s\n", label.getName());
            }
        }
    }

    /**
     * List all Messages of the user's mailbox matching the query.
     * can be used to indicate the authenticated user.
     * @param query String used to filter the Messages listed.
     * @throws IOException
     */
    public List<Message> listMessagesMatchingQuery(String query) throws IOException {
        ListMessagesResponse response = service.users().messages().list(user).setQ(query).execute();

        List<Message> messages = new ArrayList<>();
        while (response.getMessages() != null) {
            messages.addAll(response.getMessages());
            if (response.getNextPageToken() != null) {
                String pageToken = response.getNextPageToken();
                response = service.users().messages().list(user).setQ(query)
                        .setPageToken(pageToken).execute();
            } else {
                break;
            }
        }

        for (Message message : messages) {
            //System.out.println(message.toPrettyString());
        }

        return messages;
    }

    /**
     * Get Message with given ID.
     *
     * can be used to indicate the authenticated user.
     * @param messageId ID of Message to retrieve.
     * @return Message Retrieved Message.
     * @throws IOException
     */
    public String getMessage(String messageId)
            throws IOException {
        Message message = service.users().messages().get(user, messageId).execute();
        MessagePart part = message.getPayload().getParts().get(0).getParts().get(0);
        //System.out.println(StringUtils.newStringUtf8(Base64.decodeBase64(part.getBody().getData())));

        return StringUtils.newStringUtf8(Base64.decodeBase64(part.getBody().getData()));
    }

    public String getMessageRaw(String messageId)
            throws IOException {
        Message request = service.users().messages().get(user, messageId).setFormat("raw").execute();
        //System.out.println("Message snippet: " + mess);

        return StringUtils.newStringUtf8(Base64.decodeBase64(request.getRaw()));
    }

    public void buildService() throws IOException, GeneralSecurityException, MessagingException {
        user = "me";
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public void deleteAllThreads() throws IOException {
        List<Thread> threads = new ArrayList<>();
        ListThreadsResponse response = service.users().threads().list(user).execute();
        while(response.getThreads() != null) {
            threads.addAll(response.getThreads());
            if(response.getNextPageToken() != null) {
                String pageToken = response.getNextPageToken();
                response = service.users().threads().list(user).setPageToken(pageToken).execute();
            } else {
                break;
            }
        }

        for(Thread thread : threads) {
            service.users().threads().delete(user, thread.getId()).execute();
            //System.out.println(thread.toPrettyString());
        }
    }

}
