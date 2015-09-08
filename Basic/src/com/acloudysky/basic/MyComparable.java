/**
 * 
 */
package com.acloudysky.basic;

/**
 * Compares two objects 
 * @author mmiele
 *
 */
public interface MyComparable {
	/**
	 * 
	 * @param other the object to compare against
	 * @return 1, 0, -1 if the calling object (this) is greater, equal or lesser than other. 
	 */
    public int isLargerThan(MyComparable other);
}

