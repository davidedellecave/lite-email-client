package ddc.email;

public class AcceptMailHeaderFilter implements MailHeaderFilter{

	@Override
	public MailFilterResult filter(LiteMailConfig config, MailHeader header) throws Throwable {
		MailFilterResult r = new MailFilterResult();
		r.set("always", true);
		return r;
	}

}
