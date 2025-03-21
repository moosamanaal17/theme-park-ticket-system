package uk.ac.sheffield.com1003.park.exception;

/**
 * Exception thrown when number of categories exceeds maximum allowed.
 */
public class TicketLimitReachedException extends Exception {

    /**
     * Default constructor with a standard message
     */
    public TicketLimitReachedException(){
        super("Ticket category limit reached. Cannot add more categories.");
    }

    /**
     * Constructor with the custom message
     *
     * @param message error message to be printed
     */
    public TicketLimitReachedException(String message){
        super(message);
    }
}
