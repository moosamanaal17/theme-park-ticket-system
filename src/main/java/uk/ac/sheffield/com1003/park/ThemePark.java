package uk.ac.sheffield.com1003.park;

public class ThemePark {
    private String name;
    private TicketCategory[] availableCategories;
    private Purchase[] purchases;


    public ThemePark(String name) {
        this(name, new TicketCategory[10], new Purchase[10]);
    }

    private ThemePark(String name, TicketCategory[] availableCategories, Purchase[] purchases) {
        this.name = name;
        this.availableCategories = availableCategories;
        this.purchases = purchases;
    }


    public String getName() {
        return name;
    }

    public String greeting() {
        return "Welcome to " + this.getName();
    }


    // Task 1
    public void addTicketCategory(TicketCategory newTicketCategory) {
        //TODO: Implement
    }


    // Task 2
    public void printAvailableCategories() {
        //TODO: Implement
    }


    // Task 3
    public boolean makePurchase(Purchase purchase) {
        //TODO: Implement
        return false;
    }


    // Task 4
    public void printPendingTickets() {
        //TODO: Implement
    }

    // Task 7
    public void removeTicketCategory(String categoryName) {
        //TODO: Implement
    }

}
