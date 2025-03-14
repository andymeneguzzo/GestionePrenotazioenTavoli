package model;

/**
 *
 * model to represent the reservation, with specific date
 *
 * */


import java.util.Date;

public class Reservation {
    private static int counter = 1;
    private int id;
    private String customerName;
    private Date reservationDate;
    private int tableNumber;
    private int numberOfGuests;

    // Reservation constructor
    // we pass necessary information and initialize Reservation object
    public Reservation(String customerName, Date reservationDate, int tableNumber, int numberOfGuests) {
        this.id = counter++; // counter updates and saves in id
        this.customerName = customerName;
        this.reservationDate = reservationDate;
        this.tableNumber = tableNumber;
        this.numberOfGuests = numberOfGuests;
    }

    // Getters
    public int getId() {return id;}
    public String getCustomerName() {return customerName;}
    public Date getReservationDate() {return reservationDate;}
    public int getTableNumber() {return tableNumber;}
    public int getNumberOfGuests() {return numberOfGuests;}

    // Setters
    public void setCustomerName(String customerName) {this.customerName = customerName;}
    public void setReservationDate(Date reservationDate) {this.reservationDate = reservationDate;}
    public void setTableNumber(int tableNumber) {this.tableNumber = tableNumber;}
    public void setNumberOfGuests(int numberOfGuests) {this.numberOfGuests = numberOfGuests;}

    // overridden to string method
    @Override
    public String toString() {
        return "Reservation: " +
                "ID = " + id +
                ", Customer = " + customerName + "\n" +
                ", Date = " + reservationDate +
                ", Table = " + tableNumber +
                ", Guests = " + numberOfGuests + "\n";
    }
}
