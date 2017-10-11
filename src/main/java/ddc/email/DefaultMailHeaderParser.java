package ddc.email;

public class DefaultMailHeaderParser implements MailHeaderParser {

	@Override
	public void parse(LiteMailConfig config, int messageId, String rawLine, MailHeader header) {
//		System.out.println(rawLine);
		if (rawLine == null)
			return;
		if (rawLine.startsWith(" ")) return;
		int pos1 = rawLine.indexOf(' ');
		if (pos1 <= 0)
			return;
		String key = rawLine.substring(0, pos1).toLowerCase().trim();
		String value = "";
		int pos2 = pos1 + 1;
		if (rawLine.length() >= pos2) {
			value = rawLine.substring(pos2).trim();
		}
		if (key.length() > 0) {
			if (key.endsWith(":"))
				header.getProps().put(key.substring(0, key.length()-1) , value);
			else
				header.getProps().put(key, value);
		}
	}

}
