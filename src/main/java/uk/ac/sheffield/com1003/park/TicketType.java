package uk.ac.sheffield.com1003.park;

import java.util.Objects;

public class TicketType {
    private String name;
    private int headcount;
    private double basePrice;

    // Task 1
    public TicketType(String name, int headcount, double basePrice) {
        // TODO: Complete this constructor
    }

    public String getName() {
        return name;
    }

    public int getHeadcount() {
        return headcount;
    }

    public double getBasePrice() {
        return basePrice;
    }

    // Task 5
    @Override
    public boolean equals(Object o) {
        //TODO: Implement
        return false;
    }

    @Override
    public String toString() {
        return "TicketType{" + "name='" + name + '\'' +
                ", headcount='" + headcount + '\'' +
                ", basePrice=" + basePrice +
                '}';
    }
}
