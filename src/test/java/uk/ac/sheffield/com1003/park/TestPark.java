package uk.ac.sheffield.com1003.park;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uk.ac.sheffield.com1003.park.exception.TicketLimitReachedException;
import uk.ac.sheffield.com1003.park.tickettypes.Single;
import uk.ac.sheffield.com1003.park.tickettypes.Family;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestPark extends TestParkBase{

    @DisplayName("App class exists in the right package")
    @Test
    public void testAppClassExists() {
        try {
            Class.forName("uk.ac.sheffield.com1003.park.App");
        } catch (ClassNotFoundException e) {
            fail("App class does not exist");
        }
    }

    @DisplayName("The greeting function is implemented")
    @Test
    public void testWelcome() {
        ThemePark park = new ThemePark("Sheffield Adventure Land");
        System.out.println("Test being executed");
        assertEquals("Welcome to Sheffield Adventure Land", park.greeting());
    }


    @DisplayName("The categories available is printed correctly")
    @Test
    public void testPrintAvailableCategories() {
        ThemePark park = new ThemePark("Sheffield Adventure Land");

        try {
            park.addTicketCategory(new TicketCategory("Day Pass",
                    new Single(10)));
            park.addTicketCategory(new TicketCategory("Day Pass",
                    new Family(25, 2, 1)));
        } catch (TicketLimitReachedException e) {
            System.out.println(e.getMessage());
        }

        park.printAvailableCategories();
        ArrayList<String> lines = getOutLines();
        assertEquals(7, lines.size());
        assertEquals("====================", lines.get(0));
        assertEquals("Welcome to Sheffield Adventure Land", lines.get(1));
        assertEquals("Available Ticket Categories", lines.get(2));
        assertEquals("====================", lines.get(3));
        assertEquals("TicketCategory{categoryName='Day Pass', ticketType=TicketType{name='Single', " +
                "headcount='1', basePrice=10.0}}", lines.get(4));
        assertEquals("TicketCategory{categoryName='Day Pass', ticketType=TicketType{name='Family', " +
                "headcount='3', basePrice=25.0} Family{numberOfAdults=2, numberOfChildren=1}}", lines.get(5));
        assertEquals("====================", lines.get(6));
    }

    @DisplayName("Purchase ticket 1 month ahead and check if ticket is printed with printPendingPurchases")
    @Test
    public void testPrintOverdue() throws Exception {
        ThemePark themePark = new ThemePark("Sheffield Adventure Land");
        try {
            themePark.addTicketCategory(new TicketCategory("Day Pass",
                    new Single(10)));
            themePark.addTicketCategory(new TicketCategory("Day Pass",
                    new Family(25, 2, 1)));
        } catch (TicketLimitReachedException e) {
            System.out.println(e.getMessage());
        }
        themePark.makePurchase(new Purchase(
                LocalDate.now().plusMonths(1),
                "Test Customer Name", "Day Pass",
                "Single", 30, "None"));
        themePark.printPendingTickets();
        ArrayList<String> lines = getOutLines();
        assertEquals(5, lines.size());
        assertEquals("====================", lines.get(0));
        assertEquals("Pending Purchases:", lines.get(1));
        assertEquals("====================", lines.get(2));
        assertTrue(lines.get(3).startsWith("Purchase{dateAndTimeOfPurchase"));
    }
}