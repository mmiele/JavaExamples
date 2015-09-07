package com.acloudysky.essentials;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.List;

/**
 * Contains examples on how to use exceptions.
 * @author Michael
 *
 */
public class Exceptions {

	/**
	 * Creates an integer array. It issue an exception when trying to access 
	 * a non existing element.
	 * @see java.lang.ArrayIndexOutOfBoundsException
	 */
	public static void createArray(){
	      int a[] = new int[2];
	      try{
	    	  System.out.println("Access element three :" + a[3]);
	      }catch(ArrayIndexOutOfBoundsException e){
	         System.out.println("Exception thrown  :" + e);
	      }
	      finally{
	         a[0] = 6;
	         System.out.println("First element value: " +a[0]);
	         System.out.println("The finally statement is executed");
	      }
	   }


	/**
	 * Attempts to write an empty list to a file. It shows how to catch all the issued
	 * exceptions.
	 * @see java.lang.IndexOutOfBoundsException 
	 * @see java.io.IOException 
	 */
	public static void writeList() {
		
		List<Integer> list = null;
		final int SIZE = 10;

	    PrintWriter out = null;
	
	    try {
	        System.out.println("Entering" + " try statement");
	
	        out = new PrintWriter(new FileWriter("OutFile.txt"));
	        for (int i = 0; i < SIZE; i++) {
	            out.println("Value at: " + i + " = " + list.get(i));
	        }
	    } catch (IndexOutOfBoundsException e) {
	        System.err.println("Caught IndexOutOfBoundsException: "
	                           +  e.getMessage());
	                                 
	    } catch (IOException e) {
	        System.err.println("Caught IOException: " +  e.getMessage());
	                                 
	    } finally {
	        if (out != null) {
	            System.out.println("Closing PrintWriter");
	            out.close();
	        } 
	        else {
	            System.out.println("PrintWriter not open");
	        }
	    }
	}
}