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
            if (!depend.isCompleted()) {
                temp = false;
                break;
            }
        }

        isTicketCompleted = temp;
    }

    public UserStory[] getDependencies() { return dependencies.clone(); }

    @Override
    public String toString() {
        return "[US " + getId() + "] " + getName();
    }
}
