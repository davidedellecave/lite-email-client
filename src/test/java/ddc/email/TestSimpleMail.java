package ddc.email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.junit.jupiter.api.Test;

public class TestSimpleMail {

    @Test
    public void Test_SimpleMail() throws EmailException {

        var username = "SMTP-BASIC-9476";
        var password = "m877UsKn8s";
        var from = "info@medisportgottardo.it";
        //var port = 465;
        var port = 465;
        var sPort = "465";
        var smtp = "smtp100.ext.armada.it";
        var SslEnabled = true;
        var toEmail = "davide.dellecave@gmail.com";

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
        var username = "SMTP-BASIC-9476";
        var password = "m877UsKn8s";
        //Obbligatoriamente da medisport
        var from = "info@medisportgottardo.it";
        //var port = 465;
        var port = 465;
        var smtp = "smtp100.ext.armada.it";
        var sslEnabled = true;
        var toEmail = "davide.dellecave@gmail.com";

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
    public void Test_LiteMail_dellecave() throws EmailException, LiteMailException {
        var smtp = "delle-cave.it";
        var port = LiteMailConfig.PORT;
        var sslEnabled = false;
        //
        var username = "davide@delle-cave.it";
        var password = "gnpri1925";
        //
        var from = "davide@delle-cave.it";
        var toEmail = "davide.dellecave@gmail.com";
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
        var smtp = "smtp.libero.it";
        var port = LiteMailConfig.PORT_SSL;
        var sslEnabled = true;
        //
        var username = "davidedc@libero.it";
        var password = "1Novembre2018";
        //
        var from = "davidedc@libero.it";
        var toEmail = "davide.dellecave@gmail.com";
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
        var username = "davide.dellecave@gmail.com";
        var password = "gnpdri&1925";
        var from = "davide.dellecave@gmail.com";
        var port = 465;
        var smtp = "smtp.gmail.com";
        var sslEnabled = true;
        var toEmail = "davide.dellecave@gmail.com";

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
