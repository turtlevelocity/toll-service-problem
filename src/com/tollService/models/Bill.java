package com.tollService.models;

public class Bill {
    private final double amount;
    private final Vehicle vehicle;
    private final Toll toll;

    public Bill(double amount, Vehicle vehicle, Toll toll){
        this.amount = amount;
        this.vehicle = vehicle;
        this.toll = toll;
    }

    public double getAmount() {
        return amount;
    }
}
