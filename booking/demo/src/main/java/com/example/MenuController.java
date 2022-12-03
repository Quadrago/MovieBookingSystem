package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class MenuController {

    @FXML
    private void switchToMovieList() throws IOException {
        App.setRoot("movieList");
    }
    @FXML
    private void switchToAdmin() throws IOException {
        App.setRoot("admin");
    }
    
}
