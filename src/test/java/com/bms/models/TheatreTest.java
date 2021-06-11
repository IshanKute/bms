package com.bms.models;

import com.bms.TestData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheatreTest {

    Theatre theatre = TestData.theatre;

    @Test
    void should_get_screen_for_show() {
        Screen screen = theatre.getScreen(TestData.show);
        assertEquals(TestData.screen, screen);
    }

    @Test
    void should_return_null_when_screen_is_not_present_for_show() {
        Screen screen = theatre.getScreen(new Show(12, "Some name", 111.0));
        assertNull(screen);
    }
}