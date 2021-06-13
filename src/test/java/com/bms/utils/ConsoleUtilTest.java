package com.bms.utils;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleUtilTest {

    @Test
    void should_print_line() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        ConsoleUtil consoleUtil = new ConsoleUtil();
        consoleUtil.println("Some message");
        String expected = "Some message\n";
        assertEquals(expected, outputStream.toString());
        System.setOut(System.out);
    }

    @Test
    void should_get_next_int() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1".getBytes());
        System.setIn(inputStream);
        ConsoleUtil consoleUtil = new ConsoleUtil();
        assertEquals(1, consoleUtil.nextInt());
        System.setIn(System.in);
    }
}