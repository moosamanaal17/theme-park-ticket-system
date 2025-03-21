package uk.ac.sheffield.com1003.park;

import uk.ac.sheffield.com1003.park.exception.DuplicateReservationException;
import uk.ac.sheffield.com1003.park.exception.PurchaseLimitReachedException;
import uk.ac.sheffield.com1003.park.exception.TicketLimitReachedException;
import uk.ac.sheffield.com1003.park.exception.TicketNotFoundException;
import uk.ac.sheffield.com1003.park.tickettypes.Concession;
import uk.ac.sheffield.com1003.park.tickettypes.Single;
import uk.ac.sheffield.com1003.park.tickettypes.Family;

import java.time.LocalDate;

/**
 * Main app to demonstrate theme park.
 *
 */
public class App {

    /**
     * The entry point
     *
     * @param args command-line arguments passed to the program
     */
    public static void main(String[] args) {

        // =================== Task 1 ===================
        // Add ticket categories and types
        System.out.println("=================== Task 1 ===================");
        ThemePark themePark = new ThemePark("Sheffield Adventure Land");
        try {
            themePark.addTicketCategory(new TicketCategory("Day Pass", new Single(10)));
            themePark.addTicketCategory(new TicketCategory("Day Pass",
                    new Family(25, 2, 1)));
            themePark.addTicketCategory(new TicketCategory("Two-Day Pass", new Single(15)));
            themePark.addTicketCategory(new TicketCategory("Two-Day Pass",
                    new Family(40, 2, 2)));
            themePark.addTicketCategory(new TicketCategory("Annual Pass", new Single(30)));
            themePark.addTicketCategory(new TicketCategory("Annual Pass",
                    new Family(80, 2, 2)));

            System.out.println("Successfully added ticket types for the ticket categories.");
        } catch (TicketLimitReachedException e){
            System.out.println("Error: " + e.getMessage());
        }


        // =================== Task 2 ===================
        // Print available categories
        System.out.println("\n=================== Task 2 ===================");
        themePark.printAvailableCategories();


        // =================== Task 3 ===================
        // Make valid, invalid, duplicate and overflow purchases
        System.out.println("\n=================== Task 3 ===================");

        // Valid Purchase
        Purchase purchase1 = new Purchase(
                LocalDate.of(2025, 3, 14),
                "Alice Jackson",
                "Day Pass",
                "Single",
                10,
                "Wheelchair Access"
        );

        try {
            if (themePark.makePurchase(purchase1)) {
                System.out.println("Purchase Made - " + purchase1);
            }
        } catch (DuplicateReservationException | PurchaseLimitReachedException | TicketNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }

        // Duplicate purchase
        Purchase duplicate = new Purchase(
                LocalDate.of(2025, 3, 14),
                "Alice Jackson",
                "Day Pass",
                "Single",
                10,
                "Wheelchair Access"
        );

        try {
            if (themePark.makePurchase(duplicate)) {
                System.out.println("Purchase Made - " + duplicate);
            }
        } catch (Exception e){
            System.out.println("Expected Duplicate Error: " + e.getMessage());
        }

        // Invalid purchase with wrong ticket category
        Purchase invalid = new Purchase(
                LocalDate.of(2025, 3, 15),
                "Tom Brady",
                "Week Pass",
                "Single",
                10,
                null
        );

        try {
            if (themePark.makePurchase(invalid)) {
                System.out.println("Purchase Made - " + invalid);
            }
        } catch (Exception e){
            System.out.println("Expected Ticket Category Error: " + e.getMessage());
        }

        // Exceeding purchase limit to fill up the array
        for (int i = 0; i < 5; i++) {
            Purchase extraPurchase = new Purchase(
                    LocalDate.of(2025, 3, 17),
                    "Customer" + i,
                    "Day Pass",
                    "Single",
                    10,
                    null
            );

            try {
                if (themePark.makePurchase(extraPurchase)) {
                    System.out.println("Purchase Made - " + extraPurchase);
                }
            } catch (Exception e) {
                System.out.println("Expected Purchase Limit Error: " + e.getMessage());
            }
        }


        // =================== Task 4 ===================
        // Print pending tickets
        System.out.println("\n=================== Task 4 ===================");

        Purchase futurePurchase = new Purchase(
                LocalDate.of(2025, 7, 20),
                "Thierry Henry",
                "Two-Day Pass",
                "Family",
                40,
                null
        );

        try {
            if (themePark.makePurchase(futurePurchase)) {
                System.out.println("Purchase Made - " + futurePurchase);
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        themePark.printPendingTickets();


        // =================== Task 5 ===================
        // Test equality of TicketCategory objects
        System.out.println("\n=================== Task 5 ===================");
        TicketCategory category1 = new TicketCategory("Day Pass",
                new Family(25, 2,2));
        TicketCategory category2 = new TicketCategory("Day Pass",
                new Family(25, 2,2));
        TicketCategory category3 = new TicketCategory("Two-Day Pass",
                new Family(40, 2,2));

        System.out.println(category1);
        System.out.println(category2);
        System.out.println(category3);

        System.out.println("is category1 equal to category2? " + category1.equals(category2));
        System.out.println("is category1 equal to category3? " + category1.equals(category3));


        // =================== Task 6 ===================
        // Add Concession ticket and make a purchase
        System.out.println("\n=================== Task 6 ===================");
        try {
            themePark.addTicketCategory(new TicketCategory("Day Pass",
                    new Concession(1, 10, "child")));
        } catch (TicketLimitReachedException e){
            System.out.println("Error: " + e.getMessage());
        }

        Purchase concessionPurchase = new Purchase(
                LocalDate.of(2025, 3, 25),
                "Jack Harlow",
                "Day Pass",
                "Concession",
                8,
                null
        );
        try {
            if (themePark.makePurchase(concessionPurchase)) {
                System.out.println("Purchase Made - " + concessionPurchase);
            }
        } catch ( Exception e ){
            System.out.println("Error: " + e.getMessage());
        }


        // =================== Task 7 ===================
        // Remove ticket category
        System.out.println("\n=================== Task 7 ===================");

        try {
            System.out.println("Before removing Day pass");
            themePark.printAvailableCategories();

            themePark.removeTicketCategory("Day Pass");
            System.out.println("After removing Day pass");
            themePark.printAvailableCategories();
        } catch (TicketNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            themePark.removeTicketCategory("Week Pass");
        } catch (TicketNotFoundException e) {
            System.out.println("Expected Ticket Not Found Error: " + e.getMessage() + " So cannot be removed");
        }
    }
}