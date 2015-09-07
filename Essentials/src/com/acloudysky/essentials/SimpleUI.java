/**
 * 
 */
package com.acloudysky.essentials;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



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
		menu.append(String.format("%n%s Show how to use try/catch.", "b0"));
		menu.append(String.format("%n%s Show how to use Byte Streams.", "b1"));
		menu.append(String.format("%n%s Show how to use Character Streams.", "b2"));
		menu.append(String.format("%n%s Show how to use Buffered Streams.", "b3"));
		menu.append(String.format("%n%s Scan input file containing words.", "b4"));
		menu.append(String.format("%n%s Scan input file containing doubles.", "b5"));
		menu.append(String.format("%n%s Format output using print and println methods.", "b6"));
		menu.append(String.format("%n%s Format output using format method.", "b7"));
		menu.append(String.format("%n%s Using Console class.", "b8"));

		menu.append(String.format("%n%s  Display menu.", "m"));
		menu.append(String.format("%n%s  Exit application.", "x"));
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
			
				case "b0": {
					Exceptions.createArray();
					Exceptions.writeList();
					break;
				}
				case "b1": {
					// Instantiate the Stream class.
					Stream strm = new Stream();
					try{
						// Copy input to output stream, one byte at the time.
						strm.copyByteStream("sanmartino.txt", "cb.sanmartino.txt");
						System.out.println(String.format("%s", "File copied."));
					}
					catch (IOException e){
						System.out.println(String.format("%s", e.getMessage()));
					}
					break;
				}
				case "b2": {
					// Instantiate the Stream class.
					Stream strm = new Stream();
					// Copy input to output stream, one character at the time.
					try{
						// Copy input to output stream, one character at the time.
						strm.copyCharacterStream("sanmartino.txt", "cc.sanmartino.txt");
						System.out.println(String.format("%s", "File copied."));
					}
					catch (IOException e){
						System.out.println(String.format("%s", e.getMessage()));
					}
					break;
				}
				case "b3": {
					// Instantiate the Stream class.
					Stream strm = new Stream();
					// Copy input to output stream, one line at the time with
					// buffering.
					try{
						// Copy input to output stream, one line at the time.
						strm.copyBufferedStream("sanmartino.txt", "cl.sanmartino.txt");
						System.out.println(String.format("%s", "File copied."));
					}
					catch (IOException e){
						System.out.println(String.format("%s", e.getMessage()));
					}
					break;
				}
				case "b4": {
					// Instantiate the Scan class.
					Scan sc = new Scan();
					// Scan input file and print one word per line.
					sc.readWords("sanmartino.txt");
					break;
				}
				case "b5": {
					// Instantiate the Scan class.
					Scan sc = new Scan();
					// Scan input file and add the double values it contains.
					sc.readDouble("usnumbers.txt");
					break;
				}
				case "b6": {
					// Instantiate the Scan class.
					Format fm = new Format();
					// 
					fm.printing(5);
					break;
				}
				case "b7": {
					// Instantiate the Scan class.
					Format fm = new Format();
					// 
					fm.formatting(5);
					break;
				}
				case "b8": {
					// Instantiate the UsingConsole class.
					UsingConsole uc = new UsingConsole();
					try{
						// Call password method.
						uc.password();
					}
					catch (IOException e){
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

	public void displayMenu() {
		
		System.out.println(menu.toString());
		
	}
	
	private static void Exit() {
		System.out.println("Bye!\n");
		return;
	}
}
