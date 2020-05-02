package ddc.email;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.TreeMap;

import ddc.support.util.DateUtil;

public class MailInfo {
	private static String[] datePattern = new String[] { "EEE, d MMM yyyy HH:mm:ss Z", "d MMM yyyy HH:mm:ss Z" };
	public int id = 0;
	public Map<String, String> props = new TreeMap<>();

	public MailInfo(int id) {
		super();
		this.id = id;
	}

	public ZonedDateTime getDate() {
		try {
			if (props.containsKey(MailPropEnum.date.name())) {
				String v = props.get(MailPropEnum.date.name());
				// log("v", v);
				Instant i = DateUtil.parseToInstant(v, datePattern);
				// log("i", i);
				ZonedDateTime zdt = DateUtil.toUTC(i);
				// log("zdt", zdt);
				// java.util.Date d = DateUtil.parseToDate(v, datePattern);
				// log("d", d);
				return zdt;
			}
		} catch (Exception e) {

		}
		return null;
	}

	public String getFrom() {
		if (props.containsKey(MailPropEnum.from.name())) {
			return (String) props.get(MailPropEnum.from.name());
		}
		return null;
	}

	public String getsubject() {
		if (props.containsKey(MailPropEnum.subject.name())) {
			return (String) props.get(MailPropEnum.subject.name());
		}
		return null;
	}

	public String parseLine(String line) {
		for (MailPropEnum p : MailPropEnum.values()) {
			String key = p.name().toLowerCase();
			line = line.toLowerCase();
			if (line.startsWith(key)) {
				// log(line);
				int pos = key.length() + 2;
				if (line.length() >= pos) {
					String content = line.substring(pos).trim();
					props.put(key, content);
				} else {
					props.put(key, "");
				}
			}
		}
		return null;
	}

	// public void normalize() {
	// for (Map.Entry<String, Object> entry : props.entrySet()) {
	// if (entry.getKey().equals("date")) {
	// try {
	// entry.setValue(parseDate(entry.getValue()));
	// } catch (ParseException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// // Date v = Date.valueOf(entry.getValue());
	// }
	// }
	// }

	// private Instant parseDate(Object date) throws ParseException {
	// return DateUtil.parseToInstant(String.valueOf(date), datePattern);
	// }

	@Override
	public String toString() {
		// StringBuffer b = new StringBuffer();
		// for (MailProp p : MailProp.values()) {
		// if (props.containsKey(p.name())) {
		// b.append(p.name() + ":[" + props.get(p.) + "] ");
		// }
		// }
		// return b.toString();
		return "id:[" + id + "] props:[" + props.toString() + "]";
	}
}
