package com.acloudysky.greetings;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Greetings utility class.
 * It defines greetings in different languages.
 * It shows how to use the Map collection along with Hashtable type.
 * @author milexm@gmail.com
 *
 */
public class Greetings {
	
Map<String, String> table = new Hashtable<String, String>();
	
	public Greetings() {	
		table.put("Italian", "Buongiorno!");
		table.put("Spanish", "Buenos Dias!");
		table.put("English", "Good Morning!");
		table.put("French",  "Bonjour!");	
		table.put("German",  "Guten Morgen!");
	}

	public Map<String, String> getTable() {
		return table;
	}

	public void setTable(Map<String, String> table) {
		this.table = table;
	}
	
	
	public  String greeting(String language) {
		String greeting = "no greeting found";
		Iterator<Entry<String, String>> entries = table.entrySet().iterator();
		while (entries.hasNext()) {
				Entry<String, String> thisEntry = (Entry<String, String>) entries.next();
				Object key = thisEntry.getKey();
				Object value = thisEntry.getValue();
				if ((String) key == language) 
					greeting = (String) value;
		}
		
		return greeting;
	}
}