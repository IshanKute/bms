package com.bms.services;

import com.bms.models.Ticket;
import com.bms.utils.ConsoleUtil;
import com.bms.models.Show;
import com.bms.models.Theatre;

import java.util.List;
import java.util.Map;

public class ConsoleService {
    private final ConsoleUtil consoleUtil;

    public ConsoleService(ConsoleUtil consoleUtil) {
        this.consoleUtil = consoleUtil;
    }

    public <T> void printList(List<T> list, String message){
        consoleUtil.println(message);
        for (int i = 0; i < list.size(); i++) {
            consoleUtil.println((i + 1) + ". " + list.get(i).toString());
        }
    }

    public void printTheaters(Map<Theatre, List<Show>> timings) {
        consoleUtil.println("\nThe movie is currently being at shown at following theatres:");
        int i = 0;
        for (Map.Entry<Theatre, List<Show>> theatreListEntry : timings.entrySet()) {
            consoleUtil.println("\n" + ++i + ". " + theatreListEntry.getKey().getName());
            printTimings(theatreListEntry.getValue());
        }
    }

    public int getUserChoice(String message) {
        consoleUtil.println("\n" + message + ": ");
        return consoleUtil.nextInt();
    }

    public void printTicket(Ticket ticket) {
        consoleUtil.println("***************************************************************************************");
        consoleUtil.println("Congratulations! Your ticket has been booked successfully. Please find details below: ");
        consoleUtil.println("Movie: " + ticket.getMovie().getName());
        consoleUtil.println("Theatre: " + ticket.getTheatre().getName());
        consoleUtil.println("Screen: " + ticket.getScreen().getName());
        consoleUtil.println("Time: " + ticket.getShow().getTime());
        consoleUtil.println("Price: " + ticket.getShow().getPrice());
        consoleUtil.println("***************************************************************************************");
    }

    private void printTimings(List<Show> shows) {
        for (Show show : shows) {
            consoleUtil.println(show.getTime() + " INR " + show.getPrice());
        }
    }
}
