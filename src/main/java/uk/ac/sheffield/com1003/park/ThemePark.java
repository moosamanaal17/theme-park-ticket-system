/**
 *
 *  ThemePark.java
 *  represents a simple ticketing system for a theme park.
 *
 */
package uk.ac.sheffield.com1003.park;

import uk.ac.sheffield.com1003.park.exception.DuplicateReservationException;
import uk.ac.sheffield.com1003.park.exception.PurchaseLimitReachedException;
import uk.ac.sheffield.com1003.park.exception.TicketLimitReachedException;
import uk.ac.sheffield.com1003.park.exception.TicketNotFoundException;

import java.time.LocalDate;

/**
 *  ThemePark manages ticket categories and purchases.
 */
public class ThemePark {

    /** Name of the theme park */
    private String name;

    /** Array of available ticket categories (max 10) */
    private TicketCategory[] availableCategories;

    /** Array of purchases made (max 10) */
    private Purchase[] purchases;

    /**
     * Constructs a ThemePark with default maximum categories and purchases
     *
     * @param name the name of the theme park
     */
    public ThemePark(String name) {
        this(name, new TicketCategory[10], new Purchase[10]);
    }

    /**
     * Private constructor
     *
     * @param name name of the park
     * @param availableCategories array of ticket categories
     * @param purchases array of purchases
     */
    private ThemePark(String name, TicketCategory[] availableCategories, Purchase[] purchases) {
        this.name = name;
        this.availableCategories = availableCategories;
        this.purchases = purchases;
    }

    /**
     * Accessor for name
     *
     * @return the theme park name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a welcome message with the theme park name
     *
     * @return greeting string
     */
    public String greeting() {
        return "Welcome to " + this.getName();
    }

    /**
     * Adds new ticket category
     *
     * @param newTicketCategory the category to add
     * @throws TicketLimitReachedException if maximum categories reached
     */
    // Task 1
    public void addTicketCategory(TicketCategory newTicketCategory) throws TicketLimitReachedException {
        for (int i = 0; i < availableCategories.length; i++) {
            if (availableCategories[i] == null) {
                availableCategories[i] = newTicketCategory;
                return;
            }
        }
        throw new TicketLimitReachedException("Cannot add more ticket categories. " +
                "The limit of 10 categories has been reached");
    }

    /**
     * Prints all available categories with greeting.
     */
    // Task 2
    public void printAvailableCategories() {
        System.out.println("====================");
        System.out.println(greeting());
        System.out.println("Available Ticket Categories");
        System.out.println("====================");
        for (TicketCategory ticketCategory : availableCategories) {
            if (ticketCategory != null) {
                System.out.println(ticketCategory);
            }
        }
        System.out.println("====================");
    }

    /**
     * Adds a purchase to the system after validation
     *
     * @param purchase the purchase to be made
     * @return true if purchase successful
     * @throws DuplicateReservationException if a duplicate reservation exists
     * @throws PurchaseLimitReachedException if purchase array is full
     * @throws TicketNotFoundException if ticket category does not exist
     */
    // Task 3
    public boolean makePurchase(Purchase purchase) throws DuplicateReservationException, PurchaseLimitReachedException,
            TicketNotFoundException {

        // Check if ticket category exist
        boolean categoryExists = false;
        for (TicketCategory ticketCategory : availableCategories) {
            if (ticketCategory != null && ticketCategory.getCategoryName().equals
                    (purchase.getTicketCategoryPurchased())) {
                categoryExists = true;
            }
        }
        if (!categoryExists) {
            throw new TicketNotFoundException("Ticket category not found: " + purchase.getTicketCategoryPurchased());
        }

        // Check for duplicate reservations
        for (Purchase existingPurchase : purchases) {
            if (existingPurchase != null && existingPurchase.getCustomerName().equals(purchase.getCustomerName())
            && existingPurchase.getTicketCategoryPurchased().equals(purchase.getTicketCategoryPurchased())
            && existingPurchase.getTicketTypePurchased().equals(purchase.getTicketTypePurchased())
            && existingPurchase.getReservationDate().equals(purchase.getReservationDate())) {
                throw new DuplicateReservationException("Duplicate reservation for " + purchase.getCustomerName());
            }
        }

        // Count current purchases
        int numberOfPurchases = 0;
        for (Purchase existingPurchase : purchases) {
            if (existingPurchase != null){
                numberOfPurchases++;
            }
        }

        if (numberOfPurchases >= purchases.length) {
            throw new PurchaseLimitReachedException("Purchase limit reached");
        }

        // Add new purchase
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = purchase;
                return true;
            }
        }

        return false;
    }

    /**
     * Prints pending purchases with reservation dates in the future
     */
    // Task 4
    public void printPendingTickets() {
        System.out.println("====================");
        System.out.println("Pending Purchases:");
        System.out.println("====================");

        boolean hasPending = false;
        for (Purchase purchase : purchases) {
            if (purchase != null && purchase.getReservationDate().isAfter(LocalDate.now())) {
                hasPending = true;
                System.out.println(purchase);
            }
        }
    }

    /**
     * Removes a ticket category
     *
     * @param categoryName Name of the category to be removed
     * @throws TicketNotFoundException if category does not exist
     */
    // Task 7
    public void removeTicketCategory(String categoryName) throws TicketNotFoundException {
        boolean removed = false;
        for (int i = 0; i < availableCategories.length; i++) {
            if (availableCategories[i] != null
                    && availableCategories[i].getCategoryName().equals(categoryName)) {
                availableCategories[i] = null;
                removed = true;
            }
        }
        if (!removed) {
            throw new TicketNotFoundException("Ticket category '" + categoryName + "' Not found.");
        }
    }

}
