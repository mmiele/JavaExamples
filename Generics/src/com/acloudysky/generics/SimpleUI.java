/**
 * 
 */
package com.acloudysky.generics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.acloudysky.basic.MountainBicycle;
import com.acloudysky.basic.RoadBicycle;
import com.acloudysky.basic.Rectangle;

/**
 * Displays the menu of choices the user can select from. It processes the
 * user's input and calls the proper method based on the user's choice.
 * @see FileReader and @see FileWriter. 
 * 
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
		menu.append(String.format("%n%s Instantiate simple generic class with String type.", "0"));
		menu.append(String.format("%n%s Instantiate simple generic class with Boolean type.", "1"));
		menu.append(String.format("%n%s Instantiate simple generics class with 2 type parameters.", "2"));
		menu.append(String.format("%n%s Instantiate bounded type using the MountainBicycle type.", "3"));
		menu.append(String.format("%n%s Instantiate bounded type using the RoadBicycle type.", "4"));
		menu.append(String.format("%n%s Bounded types with generics (implements interfaces).", "5"));
		menu.append(String.format("%n%s Generics wild card arguments.", "6"));
	

		menu.append(String.format("%n%s Display menu.", "m"));
		menu.append(String.format("%n%s Exit application.", "x"));
		// menu.append(newline);		
	}
	
	/*
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
					// Instantiate SimpleGeneric using String type. 
					try {
						SimpleGeneric<String> sgs = 
								new  SimpleGeneric<>("this is a simple generic class");
						sgs.printType();
					}
					catch (Exception e) {
						System.out.println(String.format("%s", e.getMessage()));
						
					}
					break;
				}
				case "1": {
					// Instantiate SimpleGeneric using Boolean type. 
					try {
						SimpleGeneric<Boolean> sgs = 
								new  SimpleGeneric<>(Boolean.TRUE);
						sgs.printType();
					}
					catch (Exception e) {
						System.out.println(String.format("%s", e.getMessage()));
						
					}
					break;
				}
				case "2": {
					// Instantiate Simple2Generics using String and Integer types. 
					try {
						Simple2Generics<String, Integer> sgsi = 
								new  Simple2Generics<>("Hello Michael, your lucky number is: ", 8);
						sgsi.printType();
					}
					catch (Exception e) {
						System.out.println(String.format("%s", e.getMessage()));
						
					}
					break;
				}
				case "3": {			
					// Instantiate the container BoundedTypes class to access the 
					// the inner BoundBicycle class.
					BoundedTypes bt = new BoundedTypes();
					
					// Instantiate the MountainBicycle class.
					MountainBicycle mb = new MountainBicycle(20, 10, 5, "dual");
					
					// Instantiate the BoundBicycle class.
					BoundedTypes.BoundBicycle<MountainBicycle> btmb = 
							bt.new BoundBicycle<MountainBicycle>(mb);
					
					// Display the MountainBicycle instance characteristics.
					btmb.printDescription();
				
					break;
				}
				case "4": {
					// Instantiate the container BoundedTypes class to access the 
					// the inner BoundBicycle class.
					BoundedTypes bt = new BoundedTypes();
					
					// Instantiate the RoadBicycle class.
					RoadBicycle rb = new RoadBicycle(20, 10, 5, 23);
					
					// Instantiate the BoundBicycle class.
					BoundedTypes.BoundBicycle<RoadBicycle> btrb = 
							bt.new BoundBicycle<RoadBicycle>(rb);
					
					// Display the RoadBicycle instance characteristics.
					btrb.printDescription();
						
					break;
				}
				case "5": {
					// Instantiate the container BoundedTypes class to access the 
					// the inner BoundBicycle class.
					BoundedTypes bt = new BoundedTypes();
					Rectangle r1 = new Rectangle();
					Rectangle r2 = new Rectangle();
					r1.setHeight(5);
					r1.setWidth(10);
					r2.setHeight(10);
					r2.setWidth(20);
				
					// Instantiate the BoundRectangle class.
					BoundedTypes.BoundRectangle<Rectangle> btr = 
							bt.new BoundRectangle<Rectangle>(r1);
					
					int result = btr.isLargerThan(r2);
					System.out.println(String.format("Result is: %d", result));
					
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
