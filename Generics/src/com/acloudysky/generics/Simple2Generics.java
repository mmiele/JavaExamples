package com.acloudysky.generics;

/**
 * <h1>Simple2Generics</h1>
 * This a simple generic class which accepts the following 2 type parameters:
 * <ul> 
 * 	<li>U is the first type parameter</li>
 * 	<li>V is the second type parameter</li>
 * </ul>
 * <p>
 * Both parameters will be replaced with the actual types when the class is instantiated.
 * </p>
 * <p>When you instantiate the class, you must pass to the constructor 2 parameters 
 * whose types match the class type parameters.<br/>
 * For example, if you set U to be a String, and V to be an Integer, then in the constructor 
 * you must pass a parameter of type String and another of type Integer.</p>
 */
public class Simple2Generics<U, V>{
     
    // Define objects of type U and V
    private U typeUParmValue = null;
    private V typeVParmValue = null;
    
   
    /**
     * Clas constructor.
     * @param param1 Value to assign the variable of type typeUParmValue
     * @param param2 Value to assign the variable of type typeVParmValue
     */
    public Simple2Generics(U param1, V param2){
        this.typeUParmValue = param1;
        this.typeVParmValue = param2;
    }
    
    /**
     * Get the typeUParm value
     * @return The typeUParam value
     */
    public U getTypeUParm() {
		return this.typeUParmValue;
	}

    /**
     * Set the typeUParm value
     * @param typeUParm the value to assign to the type parameter
     */
	public void setTypeUParm(U typeUParm) {
		this.typeUParmValue = typeUParm;
	}

	
	  /**
     * Get the typeVParm value
     * @return The typeVParam value
     */
	public V getTypeVParm() {
		return typeVParmValue;
	}

	 /**
     * Set the typeVParm value
     * @param typeVParmValue the value to assign to the type parameter
     */
	public void setTypeVParm(V typeVParmValue) {
		this.typeVParmValue = typeVParmValue;
	}

	/**
	 * Print the current parameter types and their values.
	 */
    public void printType(){
        System.out.println("U Type: " + typeUParmValue.getClass().getName());
        System.out.println("U Value: " + typeUParmValue.toString());
        System.out.println("V Type: " + typeVParmValue.getClass().getName());
        System.out.println("V Value: " + typeVParmValue.toString());
    }
}
