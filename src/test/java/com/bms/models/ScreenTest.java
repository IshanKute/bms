package com.bms.models;

import com.bms.services.TestData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScreenTest {

    Screen screen = TestData.screen;

    @Test
    void should_get_all_shows_which_has_particular_movie(){
        List<Show> actualResult = screen.getMovieShows(1);
        assertEquals(2, actualResult.size());
        assertEquals(TestData.show, actualResult.get(0));
    }

    @Test
    void should_return_true_when_the_shows_contain_the_given_movie() {
        boolean actualResult = screen.contains(new Show(1, "3 PM", 120.0));
        assertTrue(actualResult);
    }

    @Test
    void should_return_false_when_the_shows_do_not_contain_the_given_movie() {
        boolean actualResult = screen.contains(new Show(3, "3 PM", 120.0));
        assertFalse(actualResult);
    }
}