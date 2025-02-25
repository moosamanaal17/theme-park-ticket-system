package uk.ac.sheffield.com1003.park.tickettypes;

import uk.ac.sheffield.com1003.park.TicketType;

public class Family extends TicketType {
    private int numberOfAdults;
    private int numberOfChildren;


    public Family(double basePrice, int numberOfAdults, int numberOfChildren) {
        super(Family.class.getSimpleName(), numberOfAdults + numberOfChildren, basePrice);
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
    }

    @Override
    public String toString() {
        return super.toString() + " Family{" + "numberOfAdults=" + numberOfAdults +
                ", numberOfChildren=" + numberOfChildren +
                '}';
    }
}
