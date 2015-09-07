package com.acloudysky.essentials;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;

import com.acloudysky.essentials.Main;

/**
 * Demonstrates how to use the Scanner type for breaking down formatted input into tokens and 
 * translating individual tokens according to their data type.
 * @author Michael
 * @see java.util.Scanner
 */
public class Scan {
	
	/*
	 * Gets the absolute path of the files used in the I/O stream examples.
	 * The file is contained in the resources folder.
	 * @param fileName - the name of the file for which to get the absolute path.
	 * @return - the absolute path of the file.
	 */
	private String getFilePath (String fileName) {
		
		// Get the resource URL.
        URL resource = Scan.class.getResource("/" + fileName);
		URI uri = null;
		String filePath = null;
		try {
			// Get the resources URI.
			uri = resource.toURI();
			// Get the file.
			File currentFile = Paths.get(uri).toFile();
			// Get the file path and add the prefix file for the
			// expected format.
			filePath = currentFile.getPath();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
		// Return the file path.
		return filePath;

	}
	
	
	// Initialize player with default video.
			
	
	/**
	 * Reads a text file containing words and print one word per line.
	 * Notice that this method uses the Scanner default values for the tokens delimiter
	 * and type that are whitespace and String respectively.
	 * @param inFileName - The input file name.
	 */
	public void readWords(String inFileName){
		 Scanner s = null;
		 String inFilePath = this.getFilePath(inFileName);

	        try {
	        	// Create a Scanner object and initialize it with
	        	// a buffered text file containing words.
	            s = new Scanner(new BufferedReader(new FileReader(inFilePath)));

	            // Scan the file and print each word.
	            // By default, a scanner uses white space to separate tokens.
	            while (s.hasNext()) {
	                System.out.println(s.next());
	            }
	        } catch (FileNotFoundException e) {
	        	System.out.println(String.format("%s", e.getMessage()));
			} finally {
	            if (s != null) {
	                s.close();
	            }
	        }
		
	}

	/**
	 * Reads a a text file containing a list of double values and add them.
	 * Notice that this method uses the Scanner default values for the tokens delimiter
	 * and type that are whitespace and String respectively.
	 * @param inFileName - The input file name.
	 */
	public void readDouble(String inFileName){
		 Scanner s = null;
		 String inFilePath = this.getFilePath(inFileName);
		 Double sum = (double) 0;
		 
	        try {
	        	// Create a Scanner object and initialize it with
	        	// a buffered text file containing numbers.
	            s = new Scanner(new BufferedReader(new FileReader(inFilePath)));
	            s.useLocale(Locale.US);
	            
	            // Scan the file and print each word.
	            // By default, a scanner uses white space to separate tokens.
	            while (s.hasNext()) {
	            	if (s.hasNextDouble()) {
	            		sum += s.nextDouble();
	            	} else {
	            		s.next();
	            	}
	            }
	        } catch (FileNotFoundException e) {
	        	System.out.println(String.format("%s", e.getMessage()));
			} finally {
	            if (s != null) {
	                s.close();
	            }
	            System.out.println(String.format("The sum of all the doubles is: %.8f" , sum));
	        }
		
	}
}
