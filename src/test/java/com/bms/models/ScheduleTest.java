package com.bms.models;

import com.bms.TestData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {
    Schedule schedule = TestData.schedule;
    @Test
    void should_get_shows_for_given_movie_id() {
        Map<Theatre, List<Show>> actualResult =  schedule.getShowsFor(1);
        assertEquals(TestData.theatre, actualResult.keySet().toArray()[0]);
        assertEquals(2, actualResult.get(TestData.theatre).size());
        assertEquals(TestData.show, actualResult.get(TestData.theatre).get(0));
    }
}