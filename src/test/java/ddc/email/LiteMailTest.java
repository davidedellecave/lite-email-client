package ddc.email;


import ddc.support.jack.JsonConf;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.junit.jupiter.api.Test;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Properties;

public class LiteMailTest {


    public static void sendEmail(Session session, String from, String toEmail, String subject, String body) {
        try {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress(from, "NoReply-JD"));

            msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

            msg.setSubject(subject, "UTF-8");

            msg.setText(body, "UTF-8");

            msg.setSentDate(Date.from(ZonedDateTime.now().toInstant()));

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            System.out.println("Message is ready");
            Transport.send(msg);

            System.out.println("EMail Sent Successfully!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Test_JavaMail_2() {
        //port 465 is for SSL and port 587 is for TLS
        LiteMailConfig conf = TestUtil.loadSecret("medisport");

        var username = conf.getUsername();
        var password = conf.getPassword();
        var from = conf.getFrom();
        var smtp = conf.getSmtpHost();
        var toEmail = conf.getTo().get(0);
        //var port = 465;
        var port = 25;
        var tlsPort = 587;
        var sslPort = 465;
        var sslEnabled = true;
        var TlsEnabled = false;

        var portUsed = sslPort;

        try {

            // create properties field
            Properties props = new Properties();

            props.put("mail.smtp.host", smtp);
            if (sslEnabled) {
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");
                props.put("mail.smtp.ssl.enable", "true");

            }
            if (TlsEnabled) {
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.port", "587");
            }

/*            props.put("mail.pop3s.host", smtp);
            props.put("mail.pop3s.port", portUsed);
            props.put("mail.pop3s.starttls.enable", TlsEnabled);*/

            // Setup authentication, get session
            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(
                                    username, password);
                        }
                    });
            session.setDebug(true);
            sendEmail(session, from, toEmail, "test", "test");

/*            // create the POP3 store object and connect with the pop server
            //Store store = emailSession.getStore("pop3s");
            //store.connect();

            // create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());
            }

            // close the store and folder objects
            emailFolder.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Test_BulkMail() throws EmailException {
        LiteMailConfig conf = TestUtil.loadSecret("medisport");

        var username = conf.getUsername();
        var password = conf.getPassword();
        var from = conf.getFrom();
        var smtp = conf.getSmtpHost();
        var toEmail = conf.getTo().get(0);

        //var port = 465;
        var port = 465;
        var sPort = "465";
        var SslEnabled = true;

        Email email = new SimpleEmail();
        email.setHostName(smtp);
        email.setSmtpPort(port);
        //email.setAuthentication(username, password) ;
        email.setAuthenticator(new DefaultAuthenticator(username, password));
        email.setSslSmtpPort(sPort);
        email.setSSLOnConnect(SslEnabled);
        email.setFrom(from);
        email.setSubject("TestMail");
        email.setMsg("This is a test mail ... :-)");
        email.addTo(toEmail);

        email.send();
    }

    /*
    @Test
    public void Test_JavaMail() {

        MimeMessage msg = new MimeMessage(session);
        //set message headers
        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");

        msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

        msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

        msg.setSubject(subject, "UTF-8");

        msg.setText(body, "UTF-8");

        msg.setSentDate(Date.from(Instant.now()));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        System.out.println("Message is ready");
        Transport.send(msg);

        System.out.println("EMail Sent Successfully!!");

    }
*/
    @Test
    public void Test_JavaMail() {
        LiteMailConfig conf = TestUtil.loadSecret("medisport");
        var username = conf.getUsername();
        var password = conf.getPassword();
        var from = conf.getFrom();
        var smtp = conf.getSmtpHost();
        var toEmail = conf.getTo().get(0);

        //var port = 465;
        var port = 25;
        var sPort = "465";
        var SslEnabled = false;

        System.out.println("SimpleEmail Start");


        Properties props = System.getProperties();

        props.put("mail.smtp.host", smtp);

        Session session = Session.getInstance(props, null);

        sendEmail(session, from, toEmail, "SimpleEmail Testing Subject", "SimpleEmail Testing Body");
    }
}

