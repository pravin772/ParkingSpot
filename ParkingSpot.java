import java.util.*;
/**
 * Following Java class ParkingSpot includes 
 * There are two types of parking spots: spots for everyone and spots only for disabled persons. 
 * A parking spot have an identifier, which starts with a capital letter, followed by a two-digit number e.g. “D01”, “E27”. 
 * A parking spot also know if and what a car is parked in the spot. 
 * It able to add a car to the spot and remove a car from the spot.
 * @param spot_id parking spot name
 * @param only_disabled boolean variable
 * @param license_plate license numbaer variable
 * @author      Pravin Bendre <student ID 101990018>
 * @version     1.0                 
 **/

public class ParkingSpot
{
    public String spot_id;
    public boolean only_disabled;
    public Car car = null; // Car class object reference
    
    /**
    * This method is constructor.
    * @param spot spot name variable
    * @param disable boolean variable
    **/          
    public ParkingSpot(String spot, boolean disable)
    {
        this.spot_id = spot;
        this.only_disabled = disable;
    }
    
    /**
    * This method is to set spot.
    * @param spot spot name variable
    **/ 
    public void setParkingSpot(String spot)
    {
        this.spot_id = spot;
    }
    
    /**
    * This method is to set disabled variable.
    * @param bool bool name variable
    **/
    public void setOnlyDisable(boolean bool)
    {
        this.only_disabled = bool;
    }
    
    /**
    * This method is to get spot value.
    * @return spot_id get the spot name
    **/
    public String getParkingSpot()
    {
        return this.spot_id;
    }
    
    /**
    * This method is to check for disable person
    * @return only_disabled get the disable variable value
    **/
    public Boolean isForDisabledPerson()
    {
        return this.only_disabled;
    }
    
    /**
    * This method is to park a car 
    * @param c is the reference of Car class
    * @return boolean parked or not
    **/
    public boolean park(Car c)
    {
        if(c == null || c.for_disabled != only_disabled)
        {
            return false;
        }
        else
        {
            this.car = c ;
            return true;
        }
    }
    
    /**
    * This method is to remove parked car 
    * @param license_plate is the license number string
    * @return boolean removed or not
    **/
    public boolean removePark(String license_plate)
    {
        if(car.license_plate.contains(license_plate))
        {
            car.license_plate = "none";
            return true;
        }
        return false;
    }
    
    /**
    * This method is check is spot available or not 
    * @return boolean available or not
    **/
    public boolean isSpotAvailable()
    {
        return (this.car == null);
    }
    
    /**
    * This method is overiden to print object data
    * @return String data in string format
    **/
    public String toString()
    {
        if(this.car == null)
        {
            return "\nSpot ID   ||   For disable    ||   Occupied car \n  "+this.spot_id+"\t\t"+this.only_disabled+"\t\t\t None";
        }
        else
        {
            return "\nSpot ID   ||   For disable    ||   Occupied car \n  "+this.spot_id+"\t\t"+this.only_disabled+"\t\t\t"+" "+this.car.license_plate+"\n";
        }
    }
}