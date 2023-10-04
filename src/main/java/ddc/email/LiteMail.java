package ddc.email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

public class LiteMail {
	public void send(LiteMailConfig config) throws LiteMailException {
		try {
			doSend(config);
		} catch (EmailException e) {
			throw new LiteMailException(e);
		}
	}	
	
	private void doSend(LiteMailConfig config) throws EmailException {
		if (config.getPort()==-1)
			throw  new EmailException("Port is not configured. Example: 25, 587 (TSL), 465 (SSL), ...)");

		Email email = null;
		if (config.isHtmlEnabled()) {
			email = new HtmlEmail();
		} else {
			email = new SimpleEmail();
		}
		email.setHostName(config.getSmtpHost());
		email.setSmtpPort(config.getPort());
		email.setAuthenticator(new DefaultAuthenticator(config.getUsername(), config.getPassword()));
		email.setSSLOnConnect(config.isSsl());
		if (config.isSsl()) {
			email.setSslSmtpPort(String.valueOf(config.getPort()));
			//email.setSSLCheckServerIdentity(false);
		}
		
		email.setFrom(config.getFrom());
		for (String t : config.getTo()) {
			email.addTo(t);
		}
		for (String t : config.getCc()) {
			email.addCc(t);
		}
		for (String t : config.getBcc()) {
			email.addBcc(t);
		}
		email.setSubject(config.getSubject());
		email.setMsg(config.getBody());
		email.send();
	}
}
