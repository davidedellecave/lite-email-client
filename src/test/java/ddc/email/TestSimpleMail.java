package ddc.email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.junit.jupiter.api.Test;

public class TestSimpleMail {

    @Test
    public void Test_SimpleMail() throws EmailException {
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
        email.setSubject("SimpleMail");
        email.setMsg("SimpleMail Sent ... :-)");
        email.addTo(toEmail);

        email.send();
        System.out.println("SimpleMail Sent");
    }

    @Test
    public void Test_LiteMail_armada() throws EmailException, LiteMailException {
        LiteMailConfig conf = TestUtil.loadSecret("medisport");
        var username = conf.getUsername();
        var password = conf.getPassword();
        var from = conf.getFrom();
        var smtp = conf.getSmtpHost();
        var toEmail = conf.getTo().get(0);

        //var port = 465;
        var port = 465;
        var sslEnabled = true;


        LiteMailConfig c = new LiteMailConfig();
        c.setHtmlEnabled(true);
        c.setSmtpHost(smtp);
        c.setPort(port);
        c.setUsername(username);
        c.setPassword(password);
        c.setSsl(sslEnabled);
        //
        c.setFrom(from);
        c.setTo(toEmail);
        c.setSubject("Test LiteMail via armada");
        c.setBody("Body Lite Mail");
        LiteMail m = new LiteMail();
        m.send(c);

        System.out.println("LiteMail Sent");
    }

    @Test
    public void Test_LiteMail_ddc() throws EmailException, LiteMailException {
        LiteMailConfig conf = TestUtil.loadSecret("ddc");
        var username = conf.getUsername();
        var password = conf.getPassword();
        var from = conf.getFrom();
        var smtp = conf.getSmtpHost();
        var toEmail = conf.getTo().get(0);

        var port = LiteMailConfig.PORT;
        var sslEnabled = false;

        //
        LiteMailConfig c = new LiteMailConfig();
        c.setSmtpHost(smtp);
        c.setPort(port);
        c.setUsername(username);
        c.setPassword(password);
        c.setSsl(sslEnabled);
        //
        c.setHtmlEnabled(true);
        //
        c.setFrom(from);
        c.setTo(toEmail);
        c.setSubject("Test LiteMail via delle-cave");
        c.setBody("Body Lite Mail");
        LiteMail m = new LiteMail();
        m.send(c);

        System.out.println("LiteMail Sent");
    }

    @Test
    public void Test_LiteMail_libero() throws EmailException, LiteMailException {
        LiteMailConfig conf = TestUtil.loadSecret("libero");
        var username = conf.getUsername();
        var password = conf.getPassword();
        var from = conf.getFrom();
        var smtp = conf.getSmtpHost();
        var toEmail = conf.getTo().get(0);

        var port = LiteMailConfig.PORT_SSL;
        var sslEnabled = true;
        //
        LiteMailConfig c = new LiteMailConfig();
        c.setSmtpHost(smtp);
        c.setPort(port);
        c.setUsername(username);
        c.setPassword(password);
        c.setSsl(sslEnabled);
        //
        c.setHtmlEnabled(true);
        //
        c.setFrom(from);
        c.setTo(toEmail);
        c.setSubject("Test LiteMail via libero");
        c.setBody("Body Lite Mail");
        LiteMail m = new LiteMail();
        m.send(c);

        System.out.println("LiteMail Sent");
    }

    @Test
    public void Test_LiteMail_gmail() throws EmailException, LiteMailException {

        LiteMailConfig conf = TestUtil.loadSecret("gmail");
        var username = conf.getUsername();
        var password = conf.getPassword();
        var from = conf.getFrom();
        var smtp = conf.getSmtpHost();
        var toEmail = conf.getTo().get(0);

        var port = 465;
        var sslEnabled = true;

        LiteMailConfig c = new LiteMailConfig();
        c.setHtmlEnabled(true);
        c.setSmtpHost(smtp);
        c.setPort(port);
        c.setUsername(username);
        c.setPassword(password);
        c.setSsl(sslEnabled);
        //
        c.setFrom(from);
        c.setTo(toEmail);
        c.setSubject("Test LiteMail via gmail");
        c.setBody("Body Lite Mail via gmail");
        LiteMail m = new LiteMail();
        m.send(c);

        System.out.println("LiteMail Sent");
    }
}
