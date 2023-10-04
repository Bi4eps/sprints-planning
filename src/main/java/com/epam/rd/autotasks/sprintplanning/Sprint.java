package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

import java.util.ArrayList;

public class Sprint {
    private final int capacity;
    private final int ticketsLimit;
    private ArrayList<Ticket> tickets = new ArrayList<>();
    //private int numInArr = 0;
    private int totalEstimate = 0;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
    }

    public boolean addUserStory(UserStory userStory) {
        if (ticketUnsuitable(userStory)) return false;
        else {
            //
            addTicket(userStory);
            return true;
        }
    }

    public boolean addBug(Bug bugReport) {
        if (ticketUnsuitable(bugReport)) return false;
        else {
            addTicket(bugReport);
            return true;
        }
    }

    private void addTicket(Ticket ticket) {
        tickets.add(ticket);
        this.totalEstimate += ticket.getEstimate();
    }

    private boolean ticketUnsuitable(Ticket ticket) {
        return (tickets.size() >= ticketsLimit
                || ticket == null || ticket.isCompleted()
                || (totalEstimate + ticket.getEstimate() > capacity));
    }

    public Ticket[] getTickets() {
        Ticket[] output = new Ticket[tickets.size()];
        for (int i = 0; i < tickets.size(); i++) {
            output[i] = tickets.get(i);
        }
        return output;
    }

    public int getTotalEstimate() {
        /*int sum = 0;
        for (Ticket ticket : tickets)
            sum += ticket.getEstimate();*/

        return totalEstimate;
    }
}
