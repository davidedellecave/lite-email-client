package ddc.email;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ddc.support.util.Clone;

public class LiteMailConfig {
	public static final int PORT = 25;
	public static final int PORT_SSL = 465;
	public static final int PORT_TLS = 587;
	private String smtpHost = "";
	private String popHost = "";
	private int port = -1;// 25, 587
	private String username = "";
	private String password = "";
	private String from = "";
	private String subject = "";
	private String body = "";
	private List<String> to = new ArrayList<>();
	private List<String> cc = new ArrayList<>();
	private List<String> bcc = new ArrayList<>();
	private boolean htmlEnabled = false;
	private boolean ssl = false;
	private String bodyTemplate = "";
	private String subjectTemplate = "";
	//
	private boolean mailboxSimulation = false;
	private int mailboxLimit = 1;

	public LiteMailConfig clone() throws CloneNotSupportedException {
		return (LiteMailConfig) Clone.clone(this);
	}

	public String getSmtpHost() {
		return smtpHost;
	}

	public boolean isHtmlEnabled() {
		return htmlEnabled;
	}

	public void setHtmlEnabled(boolean htmlEnabled) {
		this.htmlEnabled = htmlEnabled;
	}

	public boolean isSsl() {
		return ssl;
	}

	public void setSsl(boolean ssl) {
		this.ssl = ssl;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<String> getTo() {
		return to;
	}

	@JsonIgnore
	public void setTo(List<String> to) {
		this.to = to;
	}

	public void setTo(String... to) {
		this.to = Arrays.asList(to);
	}

	@JsonIgnore
	public void setTo(String toRecipient) {
		List<String> list = new ArrayList<String>();
		list.add(toRecipient);
		this.to = list;
	}

	public void addTo(String to) {
		this.to.add(to);
	}

	public List<String> getCc() {
		return cc;
	}

	public void setCc(List<String> cc) {
		this.cc = cc;
	}

	public List<String> getBcc() {
		return bcc;
	}

	public void setBcc(List<String> bcc) {
		this.bcc = bcc;
	}

	public String getBodyTemplate() {
		return bodyTemplate;
	}

	public void setBodyTemplate(String bodyTemplate) {
		this.bodyTemplate = bodyTemplate;
	}

	public String getSubjectTemplate() {
		return subjectTemplate;
	}

	public void setSubjectTemplate(String subjectTemplate) {
		this.subjectTemplate = subjectTemplate;
	}

	public String getPopHost() {
		return popHost;
	}

	public void setPopHost(String popHost) {
		this.popHost = popHost;
	}

	public boolean isMailboxSimulation() {
		return mailboxSimulation;
	}

	public void setMailboxSimulation(boolean mailboxSimulation) {
		this.mailboxSimulation = mailboxSimulation;
	}

	public int getMailboxLimit() {
		return mailboxLimit;
	}

	public void setMailboxLimit(int mailboxLimit) {
		this.mailboxLimit = mailboxLimit;
	}

	@Override
	public String toString() {
		 String s = "MailConfig -";
		 s += " username:[" + getUsername() + "]";
		 s += " popHost:[" + getPopHost() + "]";		 
		 s += " smtp:[" + getSmtpHost() + "]";
		 s += " port:[" + getPort() + "]";
		 s += " from:[" + getFrom() + "]";
		 s += " to:[" + getTo()+ "]";
		 s += " cc:[" + getCc() + "]";
		 s += " bcc:[" + getBcc() + "]";
		 s += " subject:[" + getSubject() + "]";		 
		 s += " body:[" + getBody() + "]";
		 s += " subjectTemplate:[" + getSubjectTemplate() + "]";
		 s += " bodyTemplate:[" + getBodyTemplate() + "]";		 
		 s += " mailboxLimit:[" + getMailboxLimit() + "]";		 
		return s;

	}
}
