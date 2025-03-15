package service;

import model.Reservation;
import model.Table;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class ReservationManager {
    private List<Reservation> reservations;
    private List<Table> tables;

    public ReservationManager() {
        reservations = new ArrayList<>();
        tables = new ArrayList<>();

        // Inizializzazione di alcuni tavoli (esempio: tavoli da 1 a 10 con capacità variabile)
        tables.add(new Table(1, 2));
        tables.add(new Table(2, 4));
        tables.add(new Table(3, 4));
        tables.add(new Table(4, 6));
        tables.add(new Table(5, 2));
        tables.add(new Table(6, 4));
        tables.add(new Table(7, 4));
        tables.add(new Table(8, 6));
        tables.add(new Table(9, 2));
        tables.add(new Table(10, 4));
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    public List<Reservation> getAllReservations() {
        return new ArrayList<>(reservations);
    }

    public List<Table> getAvailableTables() {
        return new ArrayList<>(tables);
    }

    public Table findAvailableTable(int requiredSeats, String dateTime) {
        for (Table table : tables) {
            if (table.getCapacity() >= requiredSeats && isTableAvailable(table, dateTime)) {
                return table;
            }
        }
        return null;
    }

    private boolean isTableAvailable(Table table, String dateTime) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = sdf.parse(dateTime);
            for (Reservation reservation : reservations) {
                if (reservation.getTableNumber() == table.getTableNumber() && 
                    reservation.getReservationDate().equals(date)) {
                    return false;
                }
            }
            return true;
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format. Use yyyy-MM-dd HH:mm", e);
        }
    }

    public boolean cancelReservation(int reservationId) {
        return reservations.removeIf(r -> r.getId() == reservationId);
    }

    public List<Reservation> getReservationsForDate(String date) {
        List<Reservation> dateReservations = new ArrayList<>();
        for (Reservation reservation : reservations) {
            String reservationDate = reservation.getReservationDate().toString();
            if (reservationDate.startsWith(date)) {
                dateReservations.add(reservation);
            }
        }
        return dateReservations;
    }
}
