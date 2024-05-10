package com.mycompany.samsvetbookingsystem;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*
  *@author Sam
  *@version 18 April 2024
  */

public class BookingInterface extends Application {
    // WIDTH and HEIGHT of GUI stored as constants 
    private final int WIDTH = 1200;
    private final int HEIGHT = 600;
    // visual components
    private final Label headingLabel = new Label("Sam's Veterinary Booking System");
    private final Label animalLabel = new Label("Animal Details");
    private final Label speciesLabel = new Label("Species");
    private final TextField speciesField =  new TextField();
    private final Label breedLabel = new Label("Breed");
    private final TextField breedField =  new TextField();
    private final Label animalNameLabel = new Label("Name of Animal");
    private final TextField animalNameField =  new TextField();
    private final Label ageLabel = new Label("Age");
    private final TextField ageField =  new TextField();
    private final Separator sectSeparator = new Separator();
    private final Separator sectSeparator2 = new Separator();
    private final Separator sectSeparator4 = new Separator();
    private final Separator sectSeparator5 = new Separator();
    private final Label ownerLabel = new Label("Owner Details");
    private final Label nameLabel = new Label("Given Name");
    private final  TextField nameField =  new TextField();
    private final Label surnameLabel = new Label("Surname");
    private final  TextField surnameField =  new TextField();
    private final TextArea patientsWaiting  = new TextArea();
    private final Button addButton = new Button("Book the Animal!");
    private final Button clearButton = new Button("Clear");

    private AnimalsToBeSeen listOfAnimals;

    @Override
    public void start(Stage stage) {
        // Initialize the list of animals
        listOfAnimals = new AnimalsToBeSeen(20);

        // Set up UI components
        HBox headings = new HBox(10);
        VBox animalsDetails = new VBox(10);
        VBox ownerDetails = new VBox(10);
        
        HBox completeDetails = new HBox(20);
        
        HBox completeAdmin = new HBox(20);
        VBox adminButtons = new VBox(10);
        
        VBox root = new VBox(10);

        // Add components to VBoxes
        headings.getChildren().addAll(headingLabel);

        animalsDetails.getChildren().addAll(sectSeparator, animalLabel, speciesLabel, speciesField, breedLabel, breedField, animalNameLabel, animalNameField, ageLabel, ageField);

        ownerDetails.getChildren().addAll(sectSeparator2, ownerLabel, nameLabel, nameField, surnameLabel, surnameField);

        completeDetails.getChildren().addAll(animalsDetails,ownerDetails );
                
        adminButtons.getChildren().addAll(addButton, clearButton);
        
        completeAdmin.getChildren().addAll(completeDetails, patientsWaiting, adminButtons);
        
  
       
        // Add all components to VBox
        root.getChildren().addAll(headings, completeAdmin);
        // Create the scene
        Scene scene = new Scene(root, Color.web("#FDF8FC"));

        // Set font of heading
        Font font = new Font("Verdana", 50);
        headingLabel.setFont(font);
        font = new Font("Verdana", 30);
        animalLabel.setFont(font);
        ownerLabel.setFont(font);

        // Set alignment of VBoxes
        headings.setAlignment(Pos.CENTER);
        completeAdmin.setAlignment(Pos.CENTER);
//      animalsDetails.setAlignment(Pos.CENTER);
//      ownerDetails.setAlignment(Pos.CENTER);
        adminButtons.setAlignment(Pos.CENTER);

        // Set alignment and Colour of VBox
        root.setAlignment(Pos.CENTER);
        root.setBackground(Background.EMPTY);
        // Set minimum and maximum width of components

        patientsWaiting.setMaxSize(400, 700);

        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);

        // Call private methods for button event handlers
        addButton.setOnAction(e -> addHandler());
        
        clearButton.setOnAction(e -> clearDetails());

        stage.setScene(scene);
        stage.setTitle("Vet Booking System");
        stage.show();
    }

    private void clearDetails(){
        speciesField.clear();
        breedField.clear();
        animalNameField.clear();
        ageField.clear();
        nameField.clear();
        surnameField.clear();
        patientsWaiting.clear();
    }
    
    private void addHandler() {
        String species = speciesField.getText();
        String breed = breedField.getText();
        String animalName = animalNameField.getText();
        String age = ageField.getText();
        String givenName = nameField.getText();
        String surname = surnameField.getText();
        // Check for errors
        if (species.isEmpty() || breed.isEmpty() || animalName.isEmpty()) {
            patientsWaiting.setText("You must enter the animal details, Species, Age or Breed of the animal");
        } else if (givenName.isEmpty() || surname.isEmpty()) {
            patientsWaiting.setText("You must enter both your given name and surname");
        } else {
            // Ok to add an animal
            Animal animalToAdd = new Animal(species, breed, animalName, age, givenName, surname);
            listOfAnimals.addAnimal(animalToAdd);
            // Clear the fields
            speciesField.clear();
            breedField.clear();
            animalNameField.clear();
            ageField.clear();
            nameField.clear();
            surnameField.clear();
            patientsWaiting.clear();
            patientsWaiting.appendText(species + " successfully added\n\nThe animal awaiting to see the Vet\n");
            patientsWaiting.appendText(listOfAnimals.displayAnimal());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
