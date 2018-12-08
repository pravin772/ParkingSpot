import java.util.*;
/**
 * Following Java class Car includes and is identified by its registration number. 
 * A registration number always starts with a capital letter, followed by a four-digit number e.g. “T2345”. 
 * A car should have an owner and knows if it has been registered for a disabled driver.
 * @param owner_name car owner name
 * @param for_disabled boolean variable
 * @param license_plate license numbaer variable
 * @author      Pravin Bendre <student ID 101990018>
 * @version     1.0                 
 **/

public class Car
{
    public String license_plate = "";
    public String owner_name = "";
        public boolean for_disabled;
    
    /**
    * This method is constructor
    **/
    public Car(String nm, String lp, boolean disable) 
    {
        this.owner_name = nm;
        this.license_plate = lp;
        this.for_disabled = disable;
    }
    
    /**
    * This method is to set oener name
    * @param nm is name
    **/
    public void setOwnerName(String nm)
    {
        this.owner_name = nm;
    }
    
    /**
    * This method is to set license plate number
    * @param lp lp is the license number string
    **/
    public void setLicensePlate(String lp)
    {
        this.license_plate = lp;
    }
    
    /**
    * This method is to set disable value
    * @param disable disable is the boolean variable
    * @return for_disabled removed or not
    **/
    public void setDisable(boolean disable)
    {
        this.for_disabled = disable;
    }
    
    /**
    * This method is check for disabled 
    * @return for_disabled true or not
    **/
    public boolean isForDisabled()
    {
        return this.for_disabled == true;
    }
    
    /**
    * This method is get owner name
    * @return owner_name string name
    **/
    public String getOwnerName()
    {
        return this.owner_name;
    }
    
    /**
    * This method is to get license number 
    * @return license_plate string format code
    **/
    public String getLicensePlate()
    {
        return this.license_plate;
    }
    
    /**
    * This method override method to get string formatted object data 
    * @return object object data in string format
    **/
    public String toString()
    {
        return "Car owner :"+this.owner_name+" || Licence plate :"+this.license_plate+" || For disable :"+this.for_disabled+"\n";
    }
}