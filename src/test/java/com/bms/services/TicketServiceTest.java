package com.bms.services;

import com.bms.models.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TicketServiceTest {

    SelectService selectService = mock(SelectService.class);
    Movie movie = mock(Movie.class);
    Schedule schedule = mock(Schedule.class);
    Theatre theatre = mock(Theatre.class);
    Show show = mock(Show.class);
    Screen screen = mock(Screen.class);
    TicketService ticketService = new TicketService(selectService);

    @Test
    void should_generate_ticket_from_the_user_selected_data() {
        List<Movie> movies = Arrays.asList(movie, mock(Movie.class));
        List<Show> shows = Arrays.asList(show, mock(Show.class));
        Map<Theatre, List<Show>> mockAvailableShows = new HashMap<Theatre, List<Show>>() {{
            put(theatre, shows);
        }};
        int movieId = 1;
        when(selectService.selectMovie(movies)).thenReturn(movie);
        when(movie.getId()).thenReturn(movieId);
        when(schedule.getShowsFor(movieId)).thenReturn(mockAvailableShows);
        when(selectService.selectTheatre(mockAvailableShows)).thenReturn(theatre);
        when(selectService.selectShow(shows)).thenReturn(show);
        when(theatre.getScreen(movie, show)).thenReturn(screen);
        Ticket actualTicket = ticketService.generateTicket(movies, schedule);
        Ticket expectedTicket = new Ticket(movie, theatre, screen, show);
        assertEquals(expectedTicket.getMovie(), actualTicket.getMovie());
        assertEquals(expectedTicket.getScreen(), actualTicket.getScreen());
        assertEquals(expectedTicket.getTheatre(), actualTicket.getTheatre());
        assertEquals(expectedTicket.getShow(), actualTicket.getShow());
    }
}