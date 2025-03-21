package uk.ac.sheffield.com1003.park.tickettypes;

import uk.ac.sheffield.com1003.park.TicketType;

/**
 * Represents a Concession ticket type, which offers a discount
 *
 */
public class Concession extends TicketType {
    private double discountRate;
    private String reason;

    /**
     * Constructor with base price, headcount and reason.
     * fixed 20% discount
     *
     * @param headCount number of people under this ticket
     * @param basePrice base price before discount
     * @param reason justification
     */
    public Concession(int headCount, double basePrice, String reason) {
        super("Concession", headCount, basePrice);
        this.discountRate = 0.2;
        this.reason = reason;
    }

    /**
     * Returns a string representation of Concession ticket type
     *
     * @return Ticket details including discount and reason
     */
    @Override
    public String toString() {
        return super.toString() + " Concession{discountRate=" + discountRate + ", reason='" + reason + "'}";
    }
}
