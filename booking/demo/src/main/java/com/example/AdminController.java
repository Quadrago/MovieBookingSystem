package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AdminController {

    @FXML
    private TextField inputMovie;

    @FXML
    /**
     * adds movie based on the inputMoive textfield
     */
    public void addMovie() {
        try {
            FileWriter movieWrite = new FileWriter("booking/demo/Movies/" + inputMovie.getText()+".csv");
            movieWrite.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
