/**
 * Represents ticket categories with their name and ticket type
 */
package uk.ac.sheffield.com1003.park;

import java.util.Objects;

/**
 * Class definition of ticket category
 */
public class TicketCategory {
    private String categoryName;
    private TicketType ticketType;

    /**
     * Constructor for the class with a name and ticket type
     *
     * @param categoryName name of the category
     * @param ticketType ticket type that is included
     */
    // Task 1
    public TicketCategory(String categoryName, TicketType ticketType) {
        this.categoryName = categoryName;
        this.ticketType = ticketType;
    }

    /**
     * Accessor for category name
     *
     * @return the name of the category
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Accessor for ticket type
     *
     * @return the ticket type object
     */
    public TicketType getTicketType() {
        return ticketType;
    }

    /**
     * Compares two object for inequality and check if name and ticket type matches
     *
     * @param o the object being compared
     * @return true if the category name and ticket type are equal
     */
    // Task 5
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketCategory ticketCategory = (TicketCategory) o;
        if (categoryName.equals(ticketCategory.categoryName) && ticketType.equals(ticketCategory.ticketType)) {
            return true;
        }
        return false;
    }

    /**
     * Returns a string representation of ticket category
     *
     * @return a formatted string with category name and ticket type
     */
    @Override
    public String toString() {
        return "TicketCategory{" +
                "categoryName='" + categoryName + '\'' +
                ", ticketType=" + ticketType +
                '}';
    }
}
