package uk.ac.sheffield.com1003.park;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Represents a ticket purchase in the theme park.
 * Stores customer details, reservation info and payment details.
 */
public class Purchase {
    private LocalDateTime dateAndTimeOfPurchase;
    private LocalDate reservationDate;
    private String customerName;
    private String ticketCategoryPurchased;
    private String ticketTypePurchased;
    private double moneyPaid;
    private String specialRequest;

    /**
     * Constructs a Purchase object with the provided details
     *
     * @param reservationDate date ticket is booked
     * @param customerName name of the customer
     * @param ticketCategoryPurchased name of the category purchased
     * @param ticketTypePurchased name of the ticket type purchased
     * @param moneyPaid amount of money paid
     * @param specialRequest additional requests
     */
    public Purchase(LocalDate reservationDate, String customerName, String ticketCategoryPurchased, String ticketTypePurchased, double moneyPaid, String specialRequest) {
        this.dateAndTimeOfPurchase = LocalDateTime.now();
        this.reservationDate = reservationDate;
        this.customerName = customerName;
        this.ticketCategoryPurchased = ticketCategoryPurchased;
        this.ticketTypePurchased = ticketTypePurchased;
        this.moneyPaid = moneyPaid;
        this.specialRequest = specialRequest;
    }

    /**
     * Gets the date ticket is booked for
     *
     * @return reservation date
     */
    public LocalDate getReservationDate() {
        return reservationDate;
    }

    /**
     * Gets the name of the customer who bought the ticket
     *
     * @return customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Gets the category purchased
     *
     * @return category name
     */
    public String getTicketCategoryPurchased() {
        return ticketCategoryPurchased;
    }

    /**
     * Updates the purchased ticket category
     *
     * @param ticketCategoryPurchased new category name
     */
    public void setTicketCategoryPurchased(String ticketCategoryPurchased) {
        this.ticketCategoryPurchased = ticketCategoryPurchased;
    }

    /**
     * Gets purchased ticket type
     *
     * @return ticket type name
     */
    public String getTicketTypePurchased() {
        return ticketTypePurchased;
    }

    /**
     * Gets the amount of money paid
     *
     * @return payment amount
     */
    public double getMoneyPaid() {
        return moneyPaid;
    }

    /**
     * Updates the amount paid
     *
     * @param moneyPaid new amount
     */
    public void setMoneyPaid(double moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    /**
     * Returns a formatted string with the purchase details
     *
     * @return string containing all the purchase info
     */
    @Override
    public String toString() {
        return "Purchase{" +
                "dateAndTimeOfPurchase=" + dateAndTimeOfPurchase +
                ", reservationDate=" + reservationDate +
                ", customerName='" + customerName + '\'' +
                ", ticketCategoryPurchased='" + ticketCategoryPurchased + '\'' +
                ", ticketTypePurchased='" + ticketTypePurchased + '\'' +
                ", moneyPaid=" + moneyPaid +
                ", specialRequest='" + specialRequest + '\'' +
                '}';
    }
}
