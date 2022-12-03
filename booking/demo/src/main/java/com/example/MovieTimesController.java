package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.text.Text;

public class MovieTimesController implements Initializable{

    private ClientSession user = ClientSession.getInstance(); 
    
    @FXML
    private Text movieText;

    @FXML
    private ComboBox<String> movieTimes;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        movieText.setText(user.getMovie());
        MovieTimes m = new MovieTimes(user.getMovie());

        //adds times into combobox
        for(ArrayList<String> row: m.getTimes()) {
            movieTimes.getItems().add(row.get(2));
        }
        
    }   

    @FXML
    public void switchToBooking() throws IOException{
        user.setTime(movieTimes.getValue());
        App.setRoot("booking");
    }



    
}
