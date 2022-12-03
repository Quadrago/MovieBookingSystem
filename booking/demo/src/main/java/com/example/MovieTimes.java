package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MovieTimes {
    
    private String movieFile;
    private ArrayList<ArrayList<String>> movieTimes;

    public MovieTimes(String movieFile) {
        this.movieFile = movieFile;
        movieTimes = new ArrayList<ArrayList<String>>();
        updateTimes();
    }

    /**
     * Stores all times of movies into array through buffered Reader
     */
    private void updateTimes() {
        BufferedReader br = null;
        try {
            System.out.println(movieFile);
            br = new BufferedReader(new FileReader("booking/demo/Movies/"+movieFile));
            
            //skips header
            br.readLine();
            String line = br.readLine();
            while(line!=null) {
            
                //stores each line of the movie into array
                String[] temp = line.split(",");
                movieTimes.add(new ArrayList<>(Arrays.asList(temp)));

                line = br.readLine();
            }
            System.out.println(movieTimes);


        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public ArrayList<ArrayList<String>> getTimes() {
        return movieTimes;
    }   

    /**
     * will be used for admin to remove time by getting the index of the time in
     * the array list and removing it
     * @param time
     */
    public void remove(String time) {
       for(int i = 0; i < movieTimes.size(); i++) {
            if(movieTimes.get(i).get(2).equals(time)) {
                movieTimes.remove(i);
            }
       }
    }
}
