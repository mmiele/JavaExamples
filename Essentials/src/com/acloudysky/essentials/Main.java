package com.acloudysky.essentials;


/**
 * Contains the main entry for the console application. 
 * @author Michael
 *
 */
public class Main {

	/***
	 * Main entry point which displays the start greetings.
	 * It delegates the execution of method calls, displays the selection menu 
	 * and process user input. 
	 * @see SimpleUI
	 * @param args the array string to pass when the program starts.
	 * For example: "Michael" "Java Essentials"
	 * 
	 */
	
	public static void main(String[] args) {
		
		String name, course;
		try {
				name = args[0];
				course = args[1];
				
				// System.out.println(System.getProperty("java.home"));
				
				String startGreetings = String.format("Hello %s let's start %s", name, course);
				System.out.println(startGreetings);
			
		}catch (Exception e) {
			System.out.println("IO error trying to read application input!");
			System.exit(1);
		}
		
		
		SimpleUI sui = new SimpleUI();
		
		sui.displayMenu();
		
		sui.processUserInput();
		
	}

}

