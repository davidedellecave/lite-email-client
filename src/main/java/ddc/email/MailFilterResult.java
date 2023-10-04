package ddc.email;

import java.util.Map;
import java.util.TreeMap;

public class MailFilterResult {
	private Map<String, Boolean> filters = new TreeMap<>();

	public MailFilterResult set(String name, boolean selected) {
		filters.put(name, Boolean.valueOf(selected));
		return this;
	}

	public MailFilterResult setFalse() {
		filters.put("default", false);
		return this;
	}

	public MailFilterResult setTrue() {
		filters.put("default", true);
		return this;
	}


	
	public boolean getFilterValue(String name) {
		return filters.containsKey(name) ? filters.get(name) : false;
	}

	public boolean isSelectedAnd() {
		if (filters.size()==0) return false;
		return !filters.values().contains(false);
	}
	
	public boolean isSelectedOr() {
		if (filters.size()==0) return false;
		return filters.values().contains(true);
	}
}
