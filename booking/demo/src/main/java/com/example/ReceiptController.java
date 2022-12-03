package com.example;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class ReceiptController implements Initializable{

    private ClientSession user = ClientSession.getInstance();

    @FXML
    private Text movieText;

    @FXML
    private Text ticketPriceText;

    @FXML
    private Text timeText;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        //sets label with respective data for client
        movieText.setText("Movie: "+ user.getMovie());
        ticketPriceText.setText("Price: "+Integer.toString(user.getPrice()));
        timeText.setText("Time: "+user.getTime());

    }

    public void switchToMenu() throws IOException {
        App.setRoot("menu");
    }


}
