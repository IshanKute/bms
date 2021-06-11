package com.bms.repository;

import com.bms.models.Movie;
import com.bms.models.Schedule;
import com.bms.models.Theatre;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileRepositoryTest {

    FileRepository repository = new FileRepository();

    @Test
    void should_get_movies_from_file() {
        try {
            List<Movie> movies = repository.getMovies("src/test/resources/test-movies.json");
            assertAll(
                    () -> assertEquals(2, movies.size()),
                    () -> assertEquals(1, movies.get(0).getId()),
                    () -> assertEquals("Bahubali", movies.get(0).getName()),
                    () -> assertEquals(2, movies.get(1).getId()),
                    () -> assertEquals("Kapoor & Sons", movies.get(1).getName())
            );
        } catch (IOException e) {
            fail("should not have thrown any exception");
        }
    }

    @Test
    void should_get_schedule() {
        try {
            Schedule schedule = repository.getSchedule("src/test/resources/test-schedule.json");
            Theatre theatre = schedule.getTheatres().get(0);
            assertEquals("PVR", theatre.getName());
        } catch (IOException e) {
            fail("should not have thrown any exception");
        }
    }
}