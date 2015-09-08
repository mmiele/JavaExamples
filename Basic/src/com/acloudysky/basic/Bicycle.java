package com.acloudysky.basic;

/**
 * Show how to define a simple class.
 * @author Michael
 *
 */
public class Bicycle {

    public int cadence;
    public int gear;
    public int speed;
        
    /**
     * Instantiate a Bicycle object.
     * @param startCadence 	The cadence of the bicycle
     * @param startSpeed	The speed of the bicycle
     * @param startGear		The gear of the bicycle
     */
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }
        
   
    /***
     * Set the bicycle cadence
     * @param newValue The bicycle new cadence
     */
    public void setCadence(int newValue) {
        cadence = newValue;
    }
        
    /**
     * Set the bicycle gear
     * @param newValue The bicycle new gear
     */
    public void setGear(int newValue) {
        gear = newValue;
    }
        
    /**
     * Reduce bicycle speed.
     * @param decrement
     */
    public void applyBrake(int decrement) {
        speed -= decrement;
    }
        
    /**
     * Increase bicycle speed.
     * @param increment
     */
    public void speedUp(int increment) {
        speed += increment;
    }
     
    /**
     * Display the bicycle characteristics.
     */
    public void printDescription(){
        System.out.println("\nThe bycicle is " + "in gear " + this.gear
            + " with a cadence of " + this.cadence +
            " and travelling at a speed of " + this.speed + ". ");
    }
}

