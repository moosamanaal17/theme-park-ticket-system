package uk.ac.sheffield.com1003.park.tickettypes;

import uk.ac.sheffield.com1003.park.TicketType;

/**
 * Represents family ticket type that includes multiple people
 */
public class Family extends TicketType {
    private int numberOfAdults;
    private int numberOfChildren;

    /**
     * Constructor for Family ticket type
     * total head count is sum of children and adults
     *
     * @param basePrice base cost of family ticket
     * @param numberOfAdults number of adult members
     * @param numberOfChildren number of child members
     */
    public Family(double basePrice, int numberOfAdults, int numberOfChildren) {
        super(Family.class.getSimpleName(), numberOfAdults + numberOfChildren, basePrice);
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
    }

    /**
     * Returns a string representation of family ticket
     * @return formatted string with ticket type and family details
     */
    @Override
    public String toString() {
        return super.toString() + " Family{" + "numberOfAdults=" + numberOfAdults +
                ", numberOfChildren=" + numberOfChildren +
                '}';
    }
}
