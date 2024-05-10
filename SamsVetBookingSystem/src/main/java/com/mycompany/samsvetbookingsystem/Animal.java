/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.samsvetbookingsystem;

/** Class used to record the details of a motorbike
 *  @author Andy
 *  @version 21 April 2021
 */
public class Animal {
    String species;
    String Breed;
    String animalName;
    String age;
    String ownerGivName;
    String ownerSurname;

    public Animal(String species, String breed, String animalName, String age, String ownerGivName, String ownerSurname) {
        this.species = species;
        this.Breed = breed;
        this.animalName = animalName;
        this.age = age;
        this.ownerGivName = ownerGivName;
        this.ownerSurname = ownerSurname;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return Breed;
    }

    public void setBreed(String breed) {
        this.Breed = breed;
    }

    public String getanimalName() {
        return animalName;
    }

    public void setanimalNmae(String animalName) {
        this.animalName = animalName;
    }

    public String getage() {
        return age;
    }
    
    public void setage(String age) {
        this.age = age;
    }
    
    public String getOwnerGivName() {
        return ownerGivName;
    }

    public void setOwnerGivName(String ownerGivName) {
        this.ownerGivName = ownerGivName;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public void setOwnerSurname(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }
    
    
    
}
