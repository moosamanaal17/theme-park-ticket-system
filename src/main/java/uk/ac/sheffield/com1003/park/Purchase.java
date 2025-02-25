package uk.ac.sheffield.com1003.park;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Purchase {
    private LocalDateTime dateAndTimeOfPurchase;
    private LocalDate reservationDate;
    private String customerName;
    private String ticketCategoryPurchased;
    private String ticketTypePurchased;
    private double moneyPaid;
    private String specialRequest;

    public Purchase(LocalDate reservationDate, String customerName, String ticketCategoryPurchased, String ticketTypePurchased, double moneyPaid, String specialRequest) {
        this.dateAndTimeOfPurchase = LocalDateTime.now();
        this.reservationDate = reservationDate;
        this.customerName = customerName;
        this.ticketCategoryPurchased = ticketCategoryPurchased;
        this.ticketTypePurchased = ticketTypePurchased;
        this.moneyPaid = moneyPaid;
        this.specialRequest = specialRequest;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getTicketCategoryPurchased() {
        return ticketCategoryPurchased;
    }

    public void setTicketCategoryPurchased(String ticketCategoryPurchased) {
        this.ticketCategoryPurchased = ticketCategoryPurchased;
    }

    public String getTicketTypePurchased() {
        return ticketTypePurchased;
    }

    public double getMoneyPaid() {
        return moneyPaid;
    }

    public void setMoneyPaid(double moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

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
