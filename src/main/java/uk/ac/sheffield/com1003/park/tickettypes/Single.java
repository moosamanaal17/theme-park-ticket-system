package uk.ac.sheffield.com1003.park.tickettypes;

import uk.ac.sheffield.com1003.park.TicketType;

public class Single extends TicketType {

    public Single(double basePrice) {
        super(Single.class.getSimpleName(), 1, basePrice);
    }

}
