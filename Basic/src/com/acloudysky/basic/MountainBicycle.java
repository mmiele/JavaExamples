package com.acloudysky.basic;

/**
 * The MountainBicycle extends the Bicycle class. It has the suspension characteristic that 
 * the basic Bicycle does not have. 
 * @author mmiele
 *
 */
public class MountainBicycle extends Bicycle {
	
	private String suspension;
	
	public MountainBicycle(int startCadence, int startSpeed, int startGear, String suspensionType) {
		super(startCadence, startSpeed, startGear);
	
		this.setSuspension(suspensionType);
		
	}


	/** 
	 * Get the bicycle suspension.
	 * @return The bicycle suspension
	 */
	public String getSuspension() {
		return suspension;
	}

	/**
	 * Set the bicycle suspension.
	 * @param suspension The bicycle suspension. 
	 * The allowed value are "front" or "dual".
	 */
	public void setSuspension(String suspension) {
		this.suspension = suspension;
	}

	
	/**
	 * Display the bicycle characteristics. 
	 * <b>Note</b>. This method is an example of polimorphic behavior. 
	 * It display the base class characteristics and the ones that apply 
	 * only to the current class.  
	 */
	@Override
	public void printDescription() {
		super.printDescription();
		System.out.println("It is a " + "mountain bicycle that has a " +
	            getSuspension() + " suspension.");
	}


}
