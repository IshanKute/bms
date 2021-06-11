package com.bms.models;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private final String name;
    private final List<Show> shows;

    public Screen(String name, List<Show> shows) {
        this.name = name;
        this.shows = shows;
    }

    public List<Show> getMovieShows(int movieId) {
        List<Show> shows = new ArrayList<>();
        for (Show show : this.shows) {
            if(show.getMovieId() == movieId) shows.add(show);
        }
        return shows;
    }

    public String getName() {
        return name;
    }

    public boolean contains(Show selectedShow) {
        for (Show show : shows) {
            if(show.getMovieId() == selectedShow.getMovieId() && show.getTime().equals(selectedShow.getTime())) return true;
        }
        return false;
    }
}
