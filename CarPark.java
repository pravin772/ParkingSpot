 import java.util.*;
/**
 * Following Java class CarPark includes and is responsible for maintaining a list of available parking spots. 
 * It also able to find a spot, add a spot, delete a spot, and provide a list of all spots included in the car park.
 * @param parking_spots object array list of class ParkingSpot
 * @author      Pravin Bendre <student ID 101990018>
 * @version     1.0                 
 **/

public class CarPark
{
    protected ArrayList<ParkingSpot> parking_spots;
    
    /**
    * This method is constructor
    **/
    public CarPark()
    {
        parking_spots = new ArrayList<ParkingSpot>(); // Creating array list of reference Parking SPot
    }

    /**
    * This method is to add a spot
    * @param spot is the spot where spot is added
    * @return boolean added or not
    **/
    public boolean addSpot(ParkingSpot spot)
    {
        if(!(isExisted(spot.spot_id)))
        {
            parking_spots.add(spot);
            return true;
        }
        else
        {
            return false;
        }
    }
        
    /**
    * This method is to remove parked car 
    * @param license_plate is the license number string
    * @return boolean removed or not
    **/
    public ParkingSpot find(String spot_id)
    {
        for(ParkingSpot spot : parking_spots)
        {
            if (spot.spot_id.equals(spot_id)) 
            {
                return spot;
            }
        }
            return null;
        
    }
        
    /**
    * This method is to remove spot  
    * @param spot_name name of the spot to be remove
    * @return boolean removed or not
    **/
    public boolean removeSpot(String spot_name)
    {
        for(ParkingSpot spot : parking_spots)
        {
            if (spot.car.license_plate == "none"  && spot.spot_id.equals(spot_name)) 
            {
                parking_spots.remove(spot);
                return true;
            }
        }
        return false;
    }
    
    /**
    * This method is to check existance of spot 
    * @param spot_name is the spot number to check
    * @return boolean existed or not
    **/
    public boolean isExisted(String spot_name)
    {
        for(ParkingSpot spot : parking_spots)
        {
            if (spot.spot_id.equals(spot_name)) 
            {
                return true;
            }
        }
        return false;
    }
    
    /**
    * This method is override to displat object data 
    * @return String object data in string format
    **/
    public String toString()
    {
        String carpark = "";
        for(ParkingSpot spot : parking_spots)
        {
            carpark += "\n || "+spot;
        }
        return carpark;
    }
}