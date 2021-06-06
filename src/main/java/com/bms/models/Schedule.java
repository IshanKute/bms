package com.bms.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schedule {
    private final List<Theatre> theatres;

    public Schedule(List<Theatre> theatres) {
        this.theatres = theatres;
    }

    public Map<Theatre, List<Show>> getShowsFor(int movieId) {
        HashMap<Theatre, List<Show>> theatreMap = new HashMap<>();
        for(Theatre theatre: theatres) {
            List<Show> shows = theatre.getShows(movieId);
            if(!shows.isEmpty()) theatreMap.put(theatre, shows);
        }
        return theatreMap;
    }
}
