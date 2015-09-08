package com.acloudysky.basic;

public class RoadBicycle extends Bicycle {
	
	private int tireWidth;

	public RoadBicycle(int startCadence, int startSpeed, int startGear, int width) {
		super(startCadence, startSpeed, startGear);
	
		this.setTireWidth(width);
		
	}

	public int getTireWidth() {
		return tireWidth;
	}

	public void setTireWidth(int tireWidth) {
		this.tireWidth = tireWidth;
	}

	@Override
	public void printDescription() {
		// TODO Auto-generated method stub
		super.printDescription();
		System.out.println("This is a road bicycle" + " that has " + getTireWidth() +
	            " MM tires.");
	}

	
	
}
