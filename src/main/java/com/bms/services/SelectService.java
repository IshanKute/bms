package com.bms.services;

import com.bms.models.Movie;
import com.bms.models.Show;
import com.bms.models.Theatre;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SelectService {
    private final ConsoleService consoleService;

    public SelectService(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    public Movie selectMovie(List<Movie> movies) {
        consoleService.printMovies(movies);
        int userChoice = consoleService.getUserChoice("Select movie you want to watch (e.g. 1, 2)");
        return movies.get(userChoice - 1);
    }

    public Show selectShow(List<Show> shows) {
        consoleService.printShows(shows);
        int userChoice = consoleService.getUserChoice("Select show (e.g.1, 2)");
        return shows.get(userChoice-1);
    }

    public Theatre selectTheatre(Map<Theatre, List<Show>> availableShows) {
        consoleService.printTheaters(availableShows);
        int userChoice = consoleService.getUserChoice("\nSelect theatre (e.g. 1, 2)");
        Set<Theatre> theatres = availableShows.keySet();
        return (Theatre) theatres.toArray()[userChoice-1];
    }
}
