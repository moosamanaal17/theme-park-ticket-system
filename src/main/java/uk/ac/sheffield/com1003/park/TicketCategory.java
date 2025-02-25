package uk.ac.sheffield.com1003.park;

import java.util.Objects;

public class TicketCategory {
    private String categoryName;
    private TicketType ticketType;

    // Task 1
    public TicketCategory(String categoryName, TicketType ticketType) {
        // TODO: Complete this constructor
    }

    public String getCategoryName() {
        return categoryName;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    // Task 5
    @Override
    public boolean equals(Object o) {
        //TODO: Implement
        return false;
    }

    @Override
    public String toString() {
        return "TicketCategory{" +
                "categoryName='" + categoryName + '\'' +
                ", ticketType=" + ticketType +
                '}';
    }
}
