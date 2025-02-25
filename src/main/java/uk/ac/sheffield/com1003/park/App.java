package uk.ac.sheffield.com1003.park;

import uk.ac.sheffield.com1003.park.tickettypes.Single;
import uk.ac.sheffield.com1003.park.tickettypes.Family;


public class App {
    public static void main(String[] args) {

        // =================== Task 1 ===================
        System.out.println("=================== Task 1 ===================");
        ThemePark themePark = new ThemePark("Sheffield Adventure Land");
        themePark.addTicketCategory(new TicketCategory("Day Pass", new Single(10)));
        themePark.addTicketCategory(new TicketCategory("Day Pass",
                new Family(25, 2, 1)));

        //TODO: See Task 1 instructions.

        //Below is an example of how you can inform the user about what is happening in your programme
        System.out.println("Successfully added two ticket types for the Day Pass ticket category.");


        // =================== Task 2 ===================
        System.out.println("\n=================== Task 2 ===================");
        //TODO: See Task 2 instructions.


        // =================== Task 3 ===================
        System.out.println("\n=================== Task 3 ===================");
        //TODO: See Task 3 instructions.


        // =================== Task 4 ===================
        System.out.println("\n=================== Task 4 ===================");
        //TODO: See Task 4 instructions.


        // =================== Task 5 ===================
        System.out.println("\n=================== Task 5 ===================");
        //TODO: See Task 5 instructions.


        // =================== Task 6 ===================
        System.out.println("\n=================== Task 6 ===================");
        //TODO: See Task 6 instructions.


        // =================== Task 7 ===================
        System.out.println("\n=================== Task 7 ===================");
        //TODO: See Task 7 instructions.


    }
}