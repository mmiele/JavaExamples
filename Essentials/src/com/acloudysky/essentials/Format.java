package com.acloudysky.essentials;
import java.lang.System;

public class Format {

	
	public void simpleFormatting() {
		System.out.printf("Integer : %d\n",15);
		System.out.printf("Floating point number with 3 decimal digits: %.3f\n",1.21312939123);
		System.out.printf("Floating point number with 8 decimal digits: %.8f\n",1.21312939123);
		System.out.printf("String: %s, integer: %d, float: %.6f", "Hello World",89,9.231435);
	}

	
	/**
	 * Invokes print or println to output a single value after converting the value 
	 * using the appropriate toString method. 
	 * Notice, you do not have control on the formatting of the output. 
	 * the format used is based on the system default.
	 * @see System
	 * @param i - An integer whose square root must be displayed.
	 */
	public void printing(int i) {
		
		 double r = Math.sqrt(i);
	        
		 System.out.println("Using print method");
	     System.out.print("The square root of ");
	     System.out.print(i);
	     System.out.print(" is ");
	     System.out.print(r);
	     System.out.println(".");

	   
	     r = Math.sqrt(i);
	     System.out.println("Using println method");
	     System.out.println("The square root of " + i + " is " + r + ".");
	}
	
	/**
	 * Invokes format to output a single value after converting the value 
	 * using the appropriate toString method. 
	 * Notice, you do not have control on the formatting of the output. 
	 * the format used is based on the system default.
	 * @see System
	 * @param i - An integer whose square root must be displayed.
	 */
	public void formatting(int i) {
		 
		 double r = Math.sqrt(i);
		 System.out.println("Using format method");   
	     System.out.format("The square root of %d is %f %n", i, r);
	     
	     System.out.printf("%-12s%-12s%s\n","Column 1","Column 2","Column3");
	     System.out.printf("%-12d%-12d%07d\n",15,12,5);

	     performFormatting();
	     
	}
	
	private void performFormatting() {
	
		String header, class1_grade, class2_grade, 
		class3_grade, divider = null;
		header = String.format("%-15s %15s", "Class", "Grade");
		divider = "---------------------------------------------------";
		
		class1_grade = String.format("%-15s %13s %n", "Java", "A");
		class2_grade = String.format("%-15s %13s %n", "C#", "B");
		class3_grade = String.format("%-15s %13s %n", "Python", "C");
		System.out.println(divider);
		System.out.println(header);
		System.out.println(class1_grade);
		System.out.println(class2_grade);
		System.out.println(class3_grade);
	}
	
}
