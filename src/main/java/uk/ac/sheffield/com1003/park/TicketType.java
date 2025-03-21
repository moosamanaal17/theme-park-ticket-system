/**
 * represents a generic ticket type with name, headcount and base price
 */

package uk.ac.sheffield.com1003.park;

import java.util.Objects;

public class TicketType {
    private String name;
    private int headcount;
    private double basePrice;

    /**
     * Constructor for TicketType
     *
     * @param name the name of the ticket type
     * @param headcount number of people allowed with this ticket
     * @param basePrice base cost of the ticket
     */
    // Task 1
    public TicketType(String name, int headcount, double basePrice) {
        this.name = name;
        this.headcount = headcount;
        this.basePrice = basePrice;
    }

    /**
     * gets the ticket type name
     *
     * @return name of the ticket tyoe
     */
    public String getName() {
        return name;
    }

    /**
     * Gets headcount for the ticket
     *
     * @return number of people allowed
     */
    public int getHeadcount() {
        return headcount;
    }

    /**
     * Gets base price
     *
     * @return base cost
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Compares two objects for equality
     * Ignores name and only checks base price and head count
     *
     * @param o object to compare
     * @return true if base price and head count is same
     */
    // Task 5
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketType ticketType = (TicketType) o;
        if (headcount == ticketType.headcount && Double.compare(basePrice, ticketType.basePrice) == 0) {
            return true;
        }
        return false;
    }

    /**
     * Returns a string representation of the ticket type
     *
     * @return formatted string with ticket details
     */
    @Override
    public String toString() {
        return "TicketType{" + "name='" + name + '\'' +
                ", headcount='" + headcount + '\'' +
                ", basePrice=" + basePrice +
                '}';
    }
}
