package com.mycompany.samsvetbookingsystem;


import java.util.ArrayList;


public class AnimalsToBeSeen  
{
    private ArrayList<Animal> patientList;
    public final int MAX;
        
    /** Constructor initialises the empty motorbike list and sets the maximum list size 
     *  @param   maxIn The maximum number of motorbikes in the list
     */
    public AnimalsToBeSeen(int maxIn)
    {
        patientList = new ArrayList<>();
        MAX = maxIn;
    }
	
    /** Adds a new Motorbike to the list
     *  @param  theBike The Bike to add
     *  @return Returns true if the bike was added successfully and false otherwise
     */
    
    //you should be able to Breed similar code to delete bike, search for bikes etc
    public boolean addAnimal(Animal theAnimal)
    {
        if(!isFull())
        {
            patientList.add(theAnimal);
            return true;
        }
        else
        {
            return false;
        }
    }
        


   /** Reports on whether or not the list is empty
     *  @return Returns true if the list is empty and false otherwise
     */
    public boolean isEmpty()
    {
        return patientList.isEmpty();
    }
	
    /** Reports on whether or not the list is full
     *  @return Returns true if the list is full and false otherwise
     */	
    public boolean isFull()
    {
        return patientList.size()== MAX;
    }
        
  
    public int getTotal()
    {       
        return patientList.size();
    }
      
 
    public Animal getBike(int positionIn)
    {
        if (positionIn < 0 || positionIn >= getTotal()) // check for valid position
        {
            return null; // no object found at given position
        }
        else
        {
            // remove one frm logical poition to get ArrayList position
            return patientList.get(positionIn);
        }
    }
    
  
    
    public String displayAnimal()
    {
      String output = "\n";  
      for (int counter = 0; counter < patientList.size(); counter++) { 
          output += patientList.get(counter).ownerGivName + "\t" + patientList.get(counter).ownerSurname;
          output += "\n" + patientList.get(counter).species + "\t" + patientList.get(counter).Breed + "\t" + patientList.get(counter).animalName + "\t" + patientList.get(counter).age;	
          output += "\n\n";
      } 
        return output;
    }
}

