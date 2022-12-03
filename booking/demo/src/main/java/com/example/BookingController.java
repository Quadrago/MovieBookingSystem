package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class BookingController implements Initializable{

    private ClientSession user = ClientSession.getInstance();
    

    @FXML
    private TextField CVVInput;

    @FXML
    private DatePicker cardDate;

    @FXML
    private TextField cardInput;

    @FXML
    private TextField firstNameInput;

    @FXML
    private TextField lastNameInput;

    @FXML
    private Text movieLabel;

    @FXML
    private Text movieTimeLabel;

    private int numPeople = 1;
    private int ticketPrice = 5;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        System.out.println("Creating booking");
        movieLabel.setText("Movie: " + user.getMovie());
        movieTimeLabel.setText("Time: " + user.getTime());

    }

    /**
     * goes to the receipt screen while also validating data to make sure they can continue
     * @throws IOExceptions
     */
    public void setToReceipt() throws IOException{

        //validates input for each input
        if(firstNameInput.getText().matches("\\d+")) {
            System.out.println("number");
            return;
        }
        if(lastNameInput.getText().matches("\\d+")) {
            System.out.println("last");
            return;
        }
        if(cardInput.getText().length()!=16 || cardInput.getText().matches(".*[a-z].*")) {
            System.out.println("Card");
            return;
        }
        if(CVVInput.getText().length()!=3 || CVVInput.getText().matches(".*[a-z].*")) {
            System.out.println("cvv");
            return;
        }
        user.setPrice(ticketPrice * numPeople);

        addPersonInfo();
        App.setRoot("receipt");
    }

    private void addPersonInfo() {
        try {
            FileWriter personInfo = new FileWriter("Person.csv");
            personInfo.write(firstNameInput.getText() + "," + lastNameInput.getText() + "," +  user.getTime() + "," + user.getMovie());
            personInfo.close();
        }
              
        catch (IOException e) {
            System.out.println("Error has occured.");
            e.printStackTrace();
        }
    }

    

}
