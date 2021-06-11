package com.bms.services;

import com.bms.models.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestData {
    public static List<Movie> movies = Arrays.asList(
            new Movie(1, "Bahubali"),
            new Movie(2, "Sairat"),
            new Movie(3, "Don"),
            new Movie(4, "Interstellar")
    );

    public static final Show show = new Show(1, "9 AM", 100.0);

    public static final Screen screen = new Screen("1", Arrays.asList(
            show,
            new Show(2, "12 PM", 100.0),
            new Show(1, "3 PM", 120.0),
            new Show(2, "6 PM", 120.0)
    ));

    public static Theatre theatre = new Theatre("PVR", Arrays.asList(
            screen,
            new Screen("2", Arrays.asList(
                    new Show(3, "9 AM", 100.0),
                    new Show(4, "12 PM", 100.0),
                    new Show(3, "3 PM", 120.0),
                    new Show(4, "6 PM", 120.0)
            ))
    ));

    public static Ticket ticket = new Ticket(movies.get(0), theatre, screen, show);

    public static Schedule schedule = new Schedule(
            Collections.singletonList(theatre)
    );
}
