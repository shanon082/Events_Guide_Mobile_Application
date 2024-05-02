package com.l2101600074.eventguideapp;

public class ListItem {
    String name, amount, booked;
    int seats;

    public ListItem(String name, String amount, String booked, int seats) {
        this.name = name;
        this.amount = amount;
        this.booked = booked;
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBooked() {
        return booked;
    }

    public void setBooked(String booked) {
        this.booked = booked;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
