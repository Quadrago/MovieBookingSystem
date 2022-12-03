package com.example;

import java.io.File;

public class MovieList {

  private String[] movies;
  
  public MovieList() {
    loadMovies();
  }

  /**
   * gets movies from Movies directory and stores in Array
   */
  private void loadMovies() {
    System.out.println("List of files");
    File directoryPath = new File("booking/demo/Movies");
    movies = directoryPath.list();
  }

  public String[] getMovies() {
      return movies;
  }
}
