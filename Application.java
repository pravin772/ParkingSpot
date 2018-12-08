import java.util.*;
/**
 * Following Java Application is the interface class including the main() method and handling all inputs and outputs.
 * @param choice choice is used for switch case choice
 * @author      Pravin Bendre <student ID 101990018>
 * @version     1.0                 
 **/

public class Application
{
    /**
    * This methos is entry poit for execution and handles some input output operations
    * @param args its a array of string  
    * @return its a void method
    **/  
    public static void main(String[] args)
    {
        int choice;
        
        Scanner sc = new Scanner(System.in); // Scanner classs object
        App app = new App(); // App class object
        
        do
        {
            System.out.println("\n********Parking Spot System Admin Panel********");    
            System.out.println("\n\t1. Add a parking spot");    
            System.out.println("\t2. Delete a parking spot");     
            System.out.println("\t3. List all spots");    
            System.out.println("\t4. Park a car");    
            System.out.println("\t5. Find car"); 
            System.out.println("\t6. Remove a car");  
            System.out.println("\t7. Exit\n"); 
            do
            {
                System.out.println("Enter your choice : ");
                choice = sc.nextInt();
                sc.nextLine();
            }while(!((choice <= 7 || choice >= 1)) );
        
            switch (choice)
            {
                case 1: app.addSpot();
                    break;
                case 2: app.deleteSpot();
                    break;
                case 3: app.listSpots();
                   break;
                case 4: app.parkCar();
                   break;
                case 5: app.findCar();
                   break;
                case 6: app.removeCar();
                   break; 
                case 7: System.out.println("Program terminated. Bye!!!");
                     System.exit(0);
                   break;
                default: 
               //default statements
                   break;
            }
        }while(choice != 7);

    }
    
}

/**
 * Following Java class App containd data mebers and methods used in Application class for parking spot system.
 * @param spot_name parking spot name
 * @param for_disable boolean variable
 * @param owner owner name variable
 * @param license_plate license numbaer variable
 * @author      Pravin Bendre <student ID 101990018>
 * @version     1.0                 
 **/
 
class App
{
          public String spot_name = "";
          public boolean for_disable = false;
          public String owner = "";
          public String license_plate = "";
        
          Scanner sc = new Scanner(System.in); // Scanner class object
          CarPark carp = new CarPark(); // CarPark class object
    /**
    * This methos is to add spot in the parking spot place.
    * @return its a void method
    **/ 
     public void addSpot()
      {
              do
                    {
                        System.out.println("Enter parking spot name : ");
                        spot_name = sc.nextLine();
                    }while(!spot_name.matches("[A-Z]{1}[0-9]{2}"));
                    
                            System.out.println("Is spot for disabled person(Enter Y for yes and N for no) : ");
                            String temp = sc.nextLine();
                            if(temp.equalsIgnoreCase("y"))
                            {
                                for_disable = true;
                            }
                            else if(temp.equalsIgnoreCase("n"))
                            {
                                for_disable = false;
                            }
             
                    ParkingSpot ps = new ParkingSpot(spot_name, for_disable);
                    if(carp.addSpot(ps))
                        {
                            System.out.println("Successfully added");
                            System.out.println(carp.parking_spots.toString());
                        }
                        else
                        {
                            System.out.println("Unsuccessfully! May be already exist");
                        }
              }
              
              /**
              * This methos is to remove spot in the parking spot place.
              * @return its a void method
              **/
              public void deleteSpot()
              {
                  System.out.println("Enter parking spot id : ");
                    spot_name = sc.nextLine();
                        if(carp.removeSpot(spot_name))
                        {
                            System.out.println("Successfully removed");
                            System.out.println(carp.parking_spots.toString());
                        }
                        else
                        {
                             System.out.println("Unsuccessfully! invalid input");
                        }
              }
              
              /**
              * This methos is to list spots present in the parking spot place.
              **/
              public void listSpots()
              {
                  System.out.println(carp.parking_spots.toString());
              }
              
              /**
              * This methos is to park a car in the parking spot place.
              * @return its a void method
              **/
              public void parkCar()
              {
                   do
                    {
                        System.out.println("Enter car owner name : ");
                        owner = sc.nextLine().trim();
                        System.out.println("Enter car license number : ");
                        license_plate = sc.nextLine().trim();
                        System.out.println("Is car for disabled person(Enter Y for yes and N for no) : ");
                        String str = sc.nextLine();
                            if(str.equalsIgnoreCase("y"))
                            {
                                for_disable = true;
                            }
                            else if(str.equalsIgnoreCase("n"))
                            {
                                for_disable = false;
                            }
                    }while(!(license_plate.matches("[A-Z]{1}[0-9]{4}")));
                    Car c = new Car(owner, license_plate, for_disable);
                    System.out.println(c.toString());
                    for(ParkingSpot spot : carp.parking_spots)
                        {
                                if ( spot.isSpotAvailable()) 
                                {
                                    if(spot.park(c))
                                    {
                                        System.out.println("Car parked successfully ");
                                        System.out.println(carp.parking_spots.toString());
                                    }     
                                    break;
                                }
                                else
                                   {
                                        System.out.println("Car cannot parked. Unsuccessful ");
                                    }
                         }
              }
              
              /**
              * This methos is to find a spot in the parking spot place.
              * @return its a void method
              **/
              public void findCar()
              {
                   System.out.println(carp.parking_spots.toString());
                    do
                    {
                        System.out.println("Enter parking spot number[ID] : ");
                        spot_name = sc.nextLine().trim();
                    }while(!spot_name.matches("[A-Z]{1}[0-9]{2}"));
                    if(carp.find(spot_name) != null)
                    {
                        System.out.println(carp.find(spot_name).toString());
                    }
                    else
                    {
                         System.out.println("\nCan not find spot. May not exist");
                        }
              }

              /**
              * This methos is to remove car park from the parking spot place.
              * @return its a void method
              **/
              public void removeCar()
              {
                  System.out.println(carp.parking_spots);
                    System.out.println("Enter car license plate number : ");
                    license_plate = sc.nextLine();
                   
                        for(ParkingSpot spot : carp.parking_spots)
                        {
                            if(spot.car != null)
                            {
                                if (spot.car.license_plate.equals(license_plate)) 
                                {
                                        if(spot.removePark(license_plate))
                                        {
                                            System.out.println("Car parking removed successfully ");
                                            System.out.println(carp.parking_spots.toString());
                                        }  
                                        else
                                        {
                                            System.out.println("Car parking remove unsuccessful ");
                                        }
                                 }
                              }
                         }
                   
              }
              
}