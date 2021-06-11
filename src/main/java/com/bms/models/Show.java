package com.bms.models;

public class Show {
    private final int movieId;
    private final String time;
    private final double price;

    public Show(int movieId, String time, double price) {
        this.movieId = movieId;
        this.time = time;
        this.price = price;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getTime() {
        return time;
    }

    public double getPrice() { return price; }

    public String getDisplayString() {
        return time + " INR " + price;
    }
}
