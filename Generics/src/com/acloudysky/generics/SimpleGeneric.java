package com.acloudysky.generics;

/**
 * <h1>SimpleGeneric</h1>
 * This a simple generic class.
 * <p>T is a type parameter, and it will be replaced with
 * actual type when the class is instantiated.</p>
 * <p>When you instantiate the class, you must pass to the constructor a parameter 
 * whose type matches the class type parameter.<br/>
 * For example, if you set T to be a String, then in the constructor you must pass
 * a parameter of type String.</p>
 */
public class SimpleGeneric<T>{
     
    // Define an object of type T
    private T typeParm = null;
     
    /**
     * Class constructor.  
     * @param param Is the value to assign to the typeParam data field.
     * <p>Notice that the type of the value must match the class type parameter.</p>
     */
    public SimpleGeneric(T param){
        this.typeParm = param;
    }
    
    /**
     * Get the type parameter
     * @return The specified typeParam value
     */
    public T getTypeParm() {
		return this.typeParm;
	}

    /**
     * Set the typeParm value
     * @param typeParm
     */
	public void setTypeParm(T typeParm) {
		this.typeParm = typeParm;
	}

	/**
	 * Print the current parameter type and its value.
	 */
    public void printType(){
        System.out.println("Type: " + typeParm.getClass().getName());
        System.out.println("Value: " + typeParm.toString());
        
    }
}
