package uk.ac.sheffield.com1003.park.exception;

/**
 * Exception thrown when ticket category cannot be found in the theme park
 */
public class TicketNotFoundException extends Exception {

    /**
     * Default constructor with a standard message
     */
    public TicketNotFoundException() {
        super("Ticket category not found.");
    }

    /**
     * Constructor with the custom message
     *
     * @param message error message to be printed
     */
    public TicketNotFoundException(String message) {
        super(message);
    }
}
