package by.epam.appetizer.service.mailing;

import java.io.IOException;
import java.io.InputStream;
import javax.mail.*;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public final class EmailSender {

    private static final String FILE_NAME = "mail.properties";
    private static final String USERNAME = "mail.smtp.username";
    private static final String PASSWORD = "mail.smtp.password";

    private final Properties properties;

    public EmailSender() {
        properties = new Properties();
        Thread currentThread = Thread.currentThread();
        ClassLoader contextClassLoader = currentThread.getContextClassLoader();
        try (InputStream inputStream = contextClassLoader.getResourceAsStream(FILE_NAME)) {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void send(String toEmail, String subject, String text) {
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(properties.getProperty(USERNAME),
                        properties.getProperty(PASSWORD));
            }
        });
        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(properties.getProperty(USERNAME)));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject(subject);
            message.setContent(
                    "<a href=" + text + ">" + text + "</a>",
                    "text/html");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
