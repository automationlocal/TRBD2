package stepdefinition;

import java.util.HashMap;
import java.util.Map;
public class ApplicationSession {
	
	static ApplicationSession session;
	static Map<String, Object> attributes;
	
	private ApplicationSession () {
		
	}
	
	public static ApplicationSession getInstance() {
		
		if (session == null) {
			session = new ApplicationSession();
			attributes = new HashMap<String, Object>();
		}
		
		return session;
	}
	
	public Object getAttribute(String key) {
				
		return attributes.get(key);		
	}

	public void addAtrribute(String key,Object value) {

		attributes.put(key, value);		
	}
	
	public void removeAtrribute(String key) {

		attributes.remove(key);		
	}
	
	public void invalidateSession() {
		
		attributes.clear();
	}
	
	public String getStringItemFromSession(String key) {
		
		String value = null;
		Object obj = getAttribute(key);
		
		if (obj != null ) {
			value = ((String) obj).toString();
		}
		
		return value;
	}
	
	public boolean getBooleanItemFromSession(String key) {
		
		boolean value = true;
		Object obj = getAttribute(key);
		
		if (obj == null ) {
			value = false;
		}
		
		if (obj != null ) {
			value = ((Boolean) obj).booleanValue();
		}
		
		return value;
	}
}