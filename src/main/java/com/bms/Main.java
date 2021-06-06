package com.bms;

import com.bms.models.Movie;
import com.bms.models.Schedule;
import com.bms.models.Ticket;
import com.bms.repository.FileRepository;
import com.bms.services.ConsoleService;
import com.bms.services.SelectService;
import com.bms.services.TicketService;
import com.bms.utils.ConsoleUtil;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        FileRepository repository = new FileRepository();
        ConsoleUtil consoleUtil = new ConsoleUtil();
        ConsoleService consoleService = new ConsoleService(consoleUtil);
        SelectService selectService = new SelectService(consoleService);
        TicketService ticketService = new TicketService(selectService);

        Schedule schedule = repository.getSchedule("src/main/resources/schedule.json") ;
        List<Movie> movies = repository.getMovies("src/main/resources/movies.json");
        Ticket ticket = ticketService.generateTicket(movies, schedule);
        consoleService.printTicket(ticket);
    }
}
