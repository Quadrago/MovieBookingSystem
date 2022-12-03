package com.example;

public class ClientSession {
    
    private static ClientSession user;

    private String movie;
    private String time;
    private int price;

    //private contructor so there is only one instance of a client
    private ClientSession() {
        System.out.println("Created User");
    }

    public static ClientSession getInstance() {
        if(user==null) {
            user = new ClientSession();
        }
        return user;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }
    public String getMovie() {
        return movie;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }

}
