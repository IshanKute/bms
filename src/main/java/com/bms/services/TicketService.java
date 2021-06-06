package com.bms.services;

import com.bms.models.*;

import java.util.List;
import java.util.Map;

public class TicketService {
    private final SelectService selectService;

    public TicketService(SelectService selectService) {
        this.selectService = selectService;
    }

    public Ticket generateTicket(List<Movie> movies, Schedule schedule){
        Movie movie = selectService.selectMovie(movies);
        Map<Theatre, List<Show>> availableShows = schedule.getShowsFor(movie.getId());
        Theatre theatre = selectService.selectTheatre(availableShows);
        Show show = selectService.selectShow(availableShows.get(theatre));
        Screen screen = theatre.getScreen(movie, show);
        return new Ticket(movie, theatre, screen, show);
    }
}
