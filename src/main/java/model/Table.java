package model;

/**
 *
 * model that represents a table with its number, capacity and availability
 *
 * */

public class Table {
    private int tableNumber;
    private int capacity;
    private boolean available;

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.available = true; // default is available
    }

    // Getters
    public int getTableNumber() {return tableNumber;}
    public int getCapacity() {return capacity;}
    public boolean isAvailable() {return available;}

    // Setters
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // to string method
    @Override
    public String toString() {
        return "Table " + tableNumber +
                ", Capacity = " + capacity +
                (available ? "Available" : "Reserved") + "\n"; // used a ? if statement
    }
}
