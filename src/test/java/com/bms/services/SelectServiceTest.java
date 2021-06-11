package com.bms.services;

import com.bms.models.Movie;
import com.bms.models.Show;
import com.bms.models.Theatre;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SelectServiceTest {
    ConsoleService consoleService = mock(ConsoleService.class);
    SelectService selectService = new SelectService(consoleService);

    @Test
    void should_select_movie() {
        int userChoice = 1;
        Movie movie = mock(Movie.class);
        List<Movie> mockMovieList = Arrays.asList(movie, mock(Movie.class));
        doNothing().when(consoleService).printMovies(mockMovieList);
        when(consoleService.getUserChoice("Select movie you want to watch (e.g. 1, 2)")).thenReturn(userChoice);
        Movie actualMovie = selectService.selectMovie(mockMovieList);
        Movie expectedMovie = mockMovieList.get(0);
        assertEquals(expectedMovie, actualMovie);
    }

    @Test
    void should_select_show() {
        int userChoice = 1;
        Show show = mock(Show.class);
        List<Show> mockShowList = Arrays.asList(show, mock(Show.class));
        doNothing().when(consoleService).printShows(mockShowList);
        when(consoleService.getUserChoice("Select show (e.g.1, 2)")).thenReturn(userChoice);
        Show actualShow = selectService.selectShow(mockShowList);
        Show expectedShow = mockShowList.get(0);
        assertEquals(expectedShow, actualShow);
    }

    @Test
    void should_select_theatre() {
        int userChoice = 1;
        Theatre theatre = mock(Theatre.class);
        List<Show> shows = Collections.singletonList(mock(Show.class));
        Map<Theatre, List<Show>> mockAvailableShows = new HashMap<Theatre, List<Show>>() {{
            put(theatre, shows);
        }};
        doNothing().when(consoleService).printTheaters(mockAvailableShows);
        when(consoleService.getUserChoice("\nSelect theatre (e.g. 1, 2)")).thenReturn(userChoice);
        Theatre actualTheatre = selectService.selectTheatre(mockAvailableShows);
        assertEquals(theatre, actualTheatre);
    }
}