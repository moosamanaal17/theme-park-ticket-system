package uk.ac.sheffield.com1003.park.exception;

/**
 * Exception thrown when customer tries to buy a ticket for the same category,
 * type and reservation date.
 */
public class DuplicateReservationException extends Exception {

    /**
     * Default constructor with standard message
     */
    public DuplicateReservationException() {
        super("Duplicate reservation found for the same customer, date and ticket.");
    }

    /**
     * Constructor with a custom message.
     *
     * @param message error message to display
     */
    public DuplicateReservationException(String message) {
        super(message);
    }
}
