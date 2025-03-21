package uk.ac.sheffield.com1003.park.tickettypes;

import uk.ac.sheffield.com1003.park.TicketType;

/**
 * Represents a single ticket type for one person
 */
public class Single extends TicketType {

    /**
     * Construct a Single ticket type with headcount = 1
     *
     * @param basePrice base cost of a single ticket
     */
    public Single(double basePrice) {
        super(Single.class.getSimpleName(), 1, basePrice);
    }

}
