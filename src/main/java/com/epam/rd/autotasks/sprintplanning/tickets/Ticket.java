package com.epam.rd.autotasks.sprintplanning.tickets;

public class Ticket {
    private final int id;
    private final String name;
    private final int estimate;
    protected boolean isTicketCompleted = false;


    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
    }

    public boolean isCompleted() { return isTicketCompleted; }

    public void complete() { isTicketCompleted = true; }

    public int getId() { return this.id; }

    public String getName() { return this.name; }

    public int getEstimate() { return this.estimate; }
}
