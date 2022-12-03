package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class movieListController implements Initializable {

    private ClientSession user = ClientSession.getInstance();

    @FXML
    private ComboBox<String> movieList;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        MovieList list = new MovieList();
        movieList.getItems().addAll(list.getMovies());

    }

    @FXML
    private void switchToList() throws IOException {
        user.setMovie(movieList.getValue());
        App.setRoot("movieTimes");
        
    }
}
