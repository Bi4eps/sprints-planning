package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

public class Sprint {
    private final int capacity;
    //private final int ticketsLimit;
    private Ticket[] tickets;
    private int numInArr = 0;
    private int totalEstimate = 0;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        //this.ticketsLimit = ticketsLimit;
        this.tickets = new Ticket[ticketsLimit];
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
        tickets[numInArr] = ticket;
        numInArr++;//

        this.totalEstimate += ticket.getEstimate();
    }

    private boolean ticketUnsuitable(Ticket ticket) {
        return (numInArr >= tickets.length
                || ticket == null || ticket.isCompleted()
                || (totalEstimate + ticket.getEstimate() > capacity));
    }

    public Ticket[] getTickets() {
        return tickets.clone();
    }

    public int getTotalEstimate() {
        /*int sum = 0;
        for (Ticket ticket : tickets)
            sum += ticket.getEstimate();*/

        return totalEstimate;
    }
}
