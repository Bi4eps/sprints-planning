package com.epam.rd.autotasks.sprintplanning.tickets;

public class UserStory extends Ticket {
    private final UserStory[] dependencies;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        dependencies = dependsOn;
    }

    @Override
    public void complete() {
        boolean temp = true;
        for (UserStory depend : dependencies) {
            System.out.println("from complete - " + depend.isCompleted()); //
            if (!depend.isCompleted()) temp = false;
        }

        isTicketCompleted = temp;
    }

    public UserStory[] getDependencies() {
        return dependencies.clone();
    }

    @Override
    public String toString() {
        return "[US " + getId() + "] " + getName();
    }
}
