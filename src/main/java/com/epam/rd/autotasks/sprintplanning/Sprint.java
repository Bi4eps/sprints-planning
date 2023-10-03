package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

public class Sprint {
    private final int capacity;
    private final int ticketsLimit;
    private Ticket[] tickets;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
    }

    public boolean addUserStory(UserStory userStory) {
        throw new UnsupportedOperationException("Implement this method");
    }

    public boolean addBug(Bug bugReport) {
        throw new UnsupportedOperationException("Implement this method");
    }

    public Ticket[] getTickets() { return tickets.clone(); }

    public int getTotalEstimate() {
        int sum = 0;
        for (Ticket ticket : tickets)
            sum += ticket.getEstimate();

        return sum;
    }
}
