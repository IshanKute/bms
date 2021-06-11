package com.bms.services;

import com.bms.TestData;
import com.bms.models.Movie;
import com.bms.models.Show;
import com.bms.models.Theatre;
import com.bms.utils.ConsoleUtil;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ConsoleServiceTest {

    ConsoleUtil consoleUtil = mock(ConsoleUtil.class);
    ConsoleService consoleService = new ConsoleService(consoleUtil);

    @Test
    void should_print_movie_list() {
        List<Movie> movies = Collections.singletonList(new Movie(1, "Interstellar"));
        consoleService.printMovies(movies);
        InOrder orderVerifier = inOrder(consoleUtil);
        orderVerifier.verify(consoleUtil).println("The movies currently screening:");
        orderVerifier.verify(consoleUtil).println("1. Interstellar");
    }

    @Test
    void should_print_show_list() {
        List<Show> shows = Collections.singletonList(new Show(1, "9AM", 120.0));
        consoleService.printShows(shows);
        InOrder orderVerifier = inOrder(consoleUtil);
        orderVerifier.verify(consoleUtil).println("Select your show:");
        orderVerifier.verify(consoleUtil).println("1. 9AM INR 120.0");
    }

    @Test
    void should_print_theatre_info() {
        List<Show> shows = Arrays.asList(new Show(1, "9 AM", 100.0), new Show(1, "3 PM", 120.0));
        Map<Theatre, List<Show>> mockAvailableShows = new HashMap<Theatre, List<Show>>() {{
            put(TestData.theatre, shows);
        }};
        consoleService.printTheaters(mockAvailableShows);
        InOrder orderVerifier = inOrder(consoleUtil);
        orderVerifier.verify(consoleUtil).println("\nThe movie is currently being at shown at following theatres:");
        orderVerifier.verify(consoleUtil).println("\n1. PVR");
        orderVerifier.verify(consoleUtil).println("9 AM INR 100.0");
        orderVerifier.verify(consoleUtil).println("3 PM INR 120.0");
    }

    @Test
    void should_get_User_Choice() {
        when(consoleUtil.nextInt()).thenReturn(1);
        int actualChoice = consoleService.getUserChoice("some message");
        assertEquals(1, actualChoice);
        verify(consoleUtil).println("\nsome message: ");
    }

    @Test
    void should_print_ticket() {
        consoleService.printTicket(TestData.ticket);
        InOrder orderVerifier = inOrder(consoleUtil);
        orderVerifier.verify(consoleUtil).println("***************************************************************************************");
        orderVerifier.verify(consoleUtil).println("Congratulations! Your ticket has been booked successfully. Please find details below: ");
        orderVerifier.verify(consoleUtil).println("Movie: Bahubali");
        orderVerifier.verify(consoleUtil).println("Theatre: PVR");
        orderVerifier.verify(consoleUtil).println("Screen: 1");
        orderVerifier.verify(consoleUtil).println("Time: 9 AM");
        orderVerifier.verify(consoleUtil).println("Price: 100.0");
        orderVerifier.verify(consoleUtil).println("***************************************************************************************");
    }
}