package com.acloudysky.basic;

import java.awt.Point;

/**
 * The Rectangle class gets and sets a rectangle dimensions. 
 * It implements the MyComparable interface.
 * @see MyComparable 
 * @author Michael
 *
 */
public class Rectangle implements MyComparable {

	private int width = 0;
	private int height = 0;
	
	
	/**
	 * Get the rectangle width.
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Set the rectangle width.
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Get the rectangle height.
	 * @return the rectangle height.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Set the rectangle height.
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}


	/**
	 * Calculate the rectangle area.
	 * @return
	 */
	public int getArea() {
		return width * height;
	}


	/**
	 * Implement the MyComparable interface method.
	 * It compares the areas of the current rectangle with the area of the
	 * passed rectangle (other).
	 * <p>
	 * It returns the following value:
	 * 	<ol>
	 * 		<li> -1 if the area of the current rectangle is less than the area of the passed rectangle
	 * 		<li>  1 if the area of the current rectangle is greater than the area of the passed rectangle
	 * 		<li>  0 if the area of the current rectangle is equal to the area of the passed rectangle
	 * 	</ol>
	 * </p>
	 */
	@Override
	public int isLargerThan(MyComparable other) {
	
		if (this.getArea() < ((Rectangle) other).getArea()) {
			return -1;
		}
		else 
			if (this.getArea() > ((Rectangle) other).getArea()) {
				return 1;
			}
			else
				return 0;
		
	}

	
	
	
	
}
