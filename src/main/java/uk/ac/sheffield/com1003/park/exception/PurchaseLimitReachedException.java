package uk.ac.sheffield.com1003.park.exception;

/**
 * Exception thrown when the number of purchases exceed maximum limit
 */
public class PurchaseLimitReachedException extends Exception {

    /**
     * Default constructor with a standard message
     */
    public PurchaseLimitReachedException() {
        super("Purchase limit reached. Cannot add anymore purchases.");
    }

    /**
     * Constructor with the custom message
     *
     * @param message error message to be printed
     */
    public PurchaseLimitReachedException(String message) {
        super(message);
    }
}
