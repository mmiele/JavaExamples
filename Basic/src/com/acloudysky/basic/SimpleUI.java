/**
 * 
 */
package com.acloudysky.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



/**
 * Displays the menu of choices the user can select from. It processes the
 * user's input and calls the proper method based on the user's choice.
 * @author Michael.
 *
 */
public class SimpleUI {
	// 
	private StringBuilder menu;
	public static final String newline = System.getProperty("line.separator");

	/**
	 * Initializes the menu that allows the user to make the 
	 * allowed choices.
	 * <p>
	 * It uses a StringBuilder to create the formatted menu </p>
	 */
	SimpleUI() {
		menu = new StringBuilder();
		menu.append(String.format("Select one of the following options:%n"));	
		menu.append(String.format("%n%s Show how to implement a class.", "0"));
		menu.append(String.format("%n%s Show how to extend a class, example 1.", "1"));
		menu.append(String.format("%n%s Show how to extend a class, example 2.", "2"));
		menu.append(String.format("%n%s Show how to implement an interface.", "3"));
		

		menu.append(String.format("%n%s Display menu.", "m"));
		menu.append(String.format("%n%s Exit application.", "x"));
		// menu.append(newline);		
	}
	
	/*s
	 * Read user input.
	 */
	private static String readuserinput() {
		
		// Open standard input.
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

		String selection = null;

		//  Read the selection from the command-line; need to use try/catch with the
		//  readLine() method
		try {
				System.out.print("\n>>> ");
				selection = br.readLine();
		} catch (IOException e) {
			System.out.println("IO error trying to read your input!");
			System.out.println(String.format("%s", e.getMessage()));
			System.exit(1);
		}
		
		return selection;

	}
	/**
	 * Gets user selection and calls the related method.
	 */
	public void processUserInput() {
		
		String in = null;
		while (true) {
			
			// Get user input.
			String selection = SimpleUI.readuserinput().toLowerCase();	
			
			try{
				// Exit the application.
				if ("x".equals(selection))
					break;
				else
					if ("m".equals(selection)) {
						// Display menu
						displayMenu();
						continue;
					}
					else 
						// Read the input string.
						in = selection.trim();
	
			}
			catch (Exception e){
				// System.out.println(e.toString());
				System.out.println(String.format("Input %s is not allowed%n", selection));
				continue;
			}
			
			// Select action to perform.
			switch(in) {
			
				case "0": {
					// Instantiate a Bicycle class.
					try {
						Bicycle b = new Bicycle(20, 10, 1);
						b.printDescription();
					}
					catch (Exception e) {
						System.out.println(String.format("%s", e.getMessage()));
						
					}
					break;
				}
				case "1": {	
					// Instantiate a  MountainBicycle class. This example 
					// demonstrates inheritance and polimorphysm.
					try {
						MountainBicycle mb = new MountainBicycle(20, 10, 5, "dual");
						mb.printDescription();
					}
					catch (Exception e) {
						System.out.println(String.format("%s", e.getMessage()));
					}
					break;
				}
				case "2": {
					// Instantiate a  RoadBicycle class. This is another example 
					// which demonstrates inheritance and polimorphysm.
					try {
						RoadBicycle rb = new RoadBicycle(40, 20, 8, 23);
						rb.printDescription();
					}
					catch (Exception e) {
						System.out.println(String.format("%s", e.getMessage()));
					}
					break;
				}
				case "3": {
					// Using interface
					try {
						Rectangle r1 = new Rectangle();
						Rectangle r2 = new Rectangle();
						r1.setHeight(5);
						r1.setWidth(10);
						r2.setHeight(10);
						r2.setWidth(20);
						int result = r1.isLargerThan(r2);
						System.out.println(String.format("Result is: %d", result));
					}
					catch (Exception e) {
						System.out.println(String.format("%s", e.getMessage()));
					}
					break;
				}
				
				default: {
					System.out.println(String.format("%s is not allowed", selection));
					break;
				}
			}
					
		}
		SimpleUI.Exit();
		
	}

	/**
	 * Display menu as defined in the menu variable.
	 */
	public void displayMenu() {
		
		System.out.println(menu.toString());
		
	}
	
	private static void Exit() {
		System.out.println("Bye!\n");
		return;
	}
}
