package com.acloudysky.generics;

import com.acloudysky.basic.Bicycle;
import com.acloudysky.basic.MyComparable;

/**
 * The BoundedTypes class shows how to use generic bounded types as follows:
 * <ol>
 * 	<li>Generic type extending the specified class. The generic type parameters are restricted to the specified class. 
 * 	<li>Generic type extending the specified interface. The generic type parameters are restricted to the specified interface. 
 * </ol>
 * <b>Note</b>: Bounded types limit the type of the generics parameters to that of the specified class or interface. 
 * @author Michael
 *
 */


public class BoundedTypes {

	
	/**
	 * The BoundBicycle shows how to define a bounded generic type 
	 * by extending a superclass.
	 * <b>Note</b>. You can instantiate the BoundBicycle class by using the MountainBicycle 
	 * or the RoadBicycle types.
	 * @see MountainBicycle RoadBicycle 
	 * @author Michael
	 * @param <T> The generic type which extends the superclass.
	 */
	class BoundBicycle<T extends Bicycle>{
	
		private T objRef;
		     

		/**
		 * Class constructor
		 * @param obj The object whose type matches the generic parameter type.
		 */
		public BoundBicycle(T obj){
		        this.objRef = obj;
		}
		
		/**
		 * Apply the specific printDescription as it apply to the 
		 * current T parameter type.
		 */
		public void printDescription(){
		        this.objRef.printDescription();
		    }
		}
		 
	
	class BoundRectangle<T extends MyComparable>{
		
		private T objRef;
		     

		/**
		 * Class constructor
		 * @param obj The object whose type matches the generic parameter type.
		 */
		public BoundRectangle(T obj){
		        this.objRef = obj;
		}
		
		/**
		 * Apply the specific isLargerThan as it apply to the 
		 * current T parameter type.
		 */
		public int isLargerThan(T other){
		     return this.objRef.isLargerThan(other);
		    }
		}
	
}
