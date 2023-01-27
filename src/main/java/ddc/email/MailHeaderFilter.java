package ddc.email;

public interface MailHeaderFilter {
	public MailFilterResult filter(LiteMailConfig config, MailHeader header) throws Throwable;
}
