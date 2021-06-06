package com.bms.models;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private final String name;
    private final List<Screen> screens;

    public Theatre(String name, List<Screen> screens) {
        this.name = name;
        this.screens = screens;
    }

    public List<Show> getShows(int movieId) {
        List<Show> shows = new ArrayList<>();
        for(Screen screen: screens) {
            shows.addAll(screen.getMovieShows(movieId));
        }
        return shows;
    }

    public String getName() {
        return name;
    }

    public Screen getScreen(Movie movie, Show show) {
        for (Screen screen : screens) {
            if(screen.contains(movie, show)) return screen;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Theatre theatre = (Theatre) o;
        return name.equals(theatre.name);
    }
}
