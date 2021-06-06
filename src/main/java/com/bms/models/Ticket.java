package com.bms.models;

public class Ticket {
    private final Movie movie;
    private final Theatre theatre;
    private final Screen screen;
    private final Show show;

    public Ticket(Movie movie, Theatre theatre, Screen screen, Show show) {
        this.movie = movie;
        this.theatre = theatre;
        this.screen = screen;
        this.show = show;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public Screen getScreen() {
        return screen;
    }

    public Show getShow() {
        return show;
    }
}
