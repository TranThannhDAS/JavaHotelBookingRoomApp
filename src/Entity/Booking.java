package Entity;

import java.time.LocalDate;

public class Booking {
    private int id;
    private Room room;
    private Customer customer;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Booking() {
    }

    public Booking(int id, Room room, Customer customer, LocalDate checkIn, LocalDate checkOut) {
        this.id = id;
        this.room = room;
        this.customer = customer;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
    public Booking(int id,LocalDate checkIn, LocalDate checkOut) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Booking: " +
                "id=" + id +
                ", room=" + room +
                ", customer=" + customer +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '.';
    }
}
