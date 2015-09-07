package com.acloudysky.greetings;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Main class.
 * @author mmiele
 *
 */
public class Main {

	public static void main(String[] args) {
		Greetings g = new Greetings();
		String greeting = g.greeting("German");
		String standard = "Hello World. ";
		System.out.println(standard.concat(greeting));
	}

}
 